/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.lang3.exception.handler;

/**
 * Interface providing functionality for ExceptionHandler.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface ExceptionHandler {
	
	public void handle(Exception e);
	public void handle(Exception e, String contextMessage);
    
}
