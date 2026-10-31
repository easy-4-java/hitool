package hitool.mail;

import hitool.mail.conf.EmailBody;
import hitool.mail.def.JavaMailClientImpl;
import hitool.mail.provider.def.DefaultEmailPropertiesProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class JavaMailClientTest {
    private LocalSmtpServer smtp;
    private JavaMailClientImpl mailClient;

    @Before
    public void setup() throws Exception {
        smtp = new LocalSmtpServer();
        Properties props = new Properties();
        props.setProperty(JavaMailKey.MAIL_HOST, "127.0.0.1");
        props.setProperty(JavaMailKey.MAIL_PORT, Integer.toString(smtp.port()));
        props.setProperty(JavaMailKey.MAIL_USER, "sender@example.test");
        props.setProperty(JavaMailKey.MAIL_SMTP_AUTH, "false");
        DefaultEmailPropertiesProvider provider = new DefaultEmailPropertiesProvider();
        provider.setProps(props);
        mailClient = new JavaMailClientImpl();
        mailClient.setPropsProvider(provider);
    }

    @Test
    public void sendsMimeMessageToLocalServer() throws Exception {
        EmailBody email = new EmailBody();
        email.setFrom("Sender", "sender@example.test", false);
        email.setMailto("Recipient", "recipient@example.test");
        email.setSubject("Mail client test");
        email.setContent("Hello from Hitool");
        assertTrue(mailClient.sendMime(email));
        assertTrue(smtp.awaitMessage().contains("recipient@example.test"));
    }

    @After
    public void shutdown() throws Exception {
        smtp.close();
    }
}
