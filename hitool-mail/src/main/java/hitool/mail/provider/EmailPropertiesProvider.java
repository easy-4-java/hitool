package hitool.mail.provider;

import java.util.Properties;

/**
 * Interface providing functionality for EmailPropertiesProvider.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface EmailPropertiesProvider {

	public Properties props();
	
	public void setProps(Properties props);
	
}
