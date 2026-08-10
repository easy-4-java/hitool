package hitool.mail.authc;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Implementation of proxy authenticator extending Authenticator.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class ProxyAuthenticator extends Authenticator {
	
	private String user = "";
	private String password = "";

	public ProxyAuthenticator(String user, String password) {
		this.user = user;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password.toCharArray());
	}
}