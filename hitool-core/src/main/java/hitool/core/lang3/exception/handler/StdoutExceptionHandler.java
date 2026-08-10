/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.lang3.exception.handler;

/**
 * Implementation of stdout exception handler functionality.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class StdoutExceptionHandler implements ExceptionHandler {
	
	public void handle(Exception e) {
		e.printStackTrace(System.out);
	}

	public void handle(Exception e, String contextMessage) {
		System.out.println("Error during " + contextMessage);
		e.printStackTrace(System.out);
	}

	public static final StdoutExceptionHandler it = new StdoutExceptionHandler();
}
