package hitool.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class LocalSmtpServer implements AutoCloseable {
    private final ServerSocket server;
    private final CountDownLatch received = new CountDownLatch(1);
    private final Thread worker;
    private volatile String message;

    LocalSmtpServer() throws IOException {
        server = new ServerSocket(0, 1, InetAddress.getLoopbackAddress());
        server.setSoTimeout(10000);
        worker = new Thread(this::serve, "hitool-test-smtp");
        worker.setDaemon(true);
        worker.start();
    }

    int port() {
        return server.getLocalPort();
    }

    String awaitMessage() throws InterruptedException {
        if (!received.await(5, TimeUnit.SECONDS)) {
            throw new AssertionError("No message reached the local SMTP server");
        }
        return message;
    }

    private void serve() {
        try (Socket socket = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            socket.setSoTimeout(10000);
            out.print("220 localhost ESMTP\r\n");
            out.flush();
            String line;
            while ((line = in.readLine()) != null) {
                if (line.startsWith("EHLO") || line.startsWith("HELO")) {
                    out.print("250 localhost\r\n");
                } else if (line.equals("DATA")) {
                    out.print("354 End data with <CR><LF>.<CR><LF>\r\n");
                    out.flush();
                    StringBuilder data = new StringBuilder();
                    while ((line = in.readLine()) != null && !line.equals(".")) {
                        data.append(line).append('\n');
                    }
                    message = data.toString();
                    received.countDown();
                    out.print("250 Message accepted\r\n");
                } else if (line.equals("QUIT")) {
                    out.print("221 Bye\r\n");
                    out.flush();
                    break;
                } else {
                    out.print("250 OK\r\n");
                }
                out.flush();
            }
        } catch (IOException e) {
            // The assertion in awaitMessage reports a failed exchange.
        }
    }

    @Override
    public void close() throws IOException {
        server.close();
        try {
            worker.join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
