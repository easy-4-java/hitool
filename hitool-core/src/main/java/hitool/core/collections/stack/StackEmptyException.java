/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.collections.stack;

@SuppressWarnings("serial")
/**
 * Implementation of stack empty exception extending RuntimeException.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class StackEmptyException extends RuntimeException {
	public StackEmptyException(String err){
		super(err);
	}
}
