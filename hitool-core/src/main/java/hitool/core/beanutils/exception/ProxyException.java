/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.beanutils.exception;

@SuppressWarnings("serial")
/**
 * Implementation of proxy exception extending PersistenceException.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class ProxyException extends PersistenceException {
	
	public ProxyException() {
		super();
	}

	public ProxyException(String message) {
		super(message);
	}

	public ProxyException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProxyException(Throwable cause) {
		super(cause);
	}
	
}
