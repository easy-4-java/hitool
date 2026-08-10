/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.beanutils.reflection.access;

import java.io.InputStream;

/**
 * Contract interface for ClassLoaderAccessor operations.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface ClassLoaderAccessor {

	<T> Class<T> loadClass(String fqcn);
    
	InputStream getResourceStream(String name);
    
	
}
