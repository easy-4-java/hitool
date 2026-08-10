/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.collections.queue;

@SuppressWarnings("serial")
/**
 * Class providing functionality for QueueEmptyException.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class QueueEmptyException extends RuntimeException {
	public QueueEmptyException(String err){
		super(err);
	}
}
