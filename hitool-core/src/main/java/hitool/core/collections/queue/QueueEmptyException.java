/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.collections.queue;

@SuppressWarnings("serial")
/**
 * Implementation of queue empty exception extending RuntimeException.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class QueueEmptyException extends RuntimeException {
	public QueueEmptyException(String err){
		super(err);
	}
}
