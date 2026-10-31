package hitool.mail;

import hitool.mail.conf.EmailBody;
import hitool.mail.def.CommonsMailClientImpl;
import hitool.mail.provider.def.DefaultEmailPropertiesProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class CommonsMailClientTest {
    private LocalSmtpServer smtp;
    private CommonsMailClientImpl mailClient;

    @Before
    public void setup() throws Exception {
        smtp = new LocalSmtpServer();
        Properties props = new Properties();
        props.setProperty(JavaMailKey.MAIL_HOST, "127.0.0.1");
        props.setProperty(JavaMailKey.MAIL_PORT, Integer.toString(smtp.port()));
        props.setProperty(JavaMailKey.MAIL_USER, "sender@example.test");
        props.setProperty(JavaMailKey.MAIL_SMTP_AUTH, "false");
        props.setProperty(JavaMailKey.MAIL_SMTP_TIMEOUT, "5");
        DefaultEmailPropertiesProvider provider = new DefaultEmailPropertiesProvider();
        provider.setProps(props);
        mailClient = new CommonsMailClientImpl();
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
