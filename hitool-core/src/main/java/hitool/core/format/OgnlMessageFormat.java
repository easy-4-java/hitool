/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.format;

import org.apache.commons.lang3.text.ExtendedMessageFormat;


/**
 * Implementation of ognl message format extending ExtendedMessageFormat.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class OgnlMessageFormat extends ExtendedMessageFormat {
	
	public OgnlMessageFormat(String pattern) {
		super(pattern);
	}

    
}
