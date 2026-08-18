/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 * All Rights Reserved. 
 */
package hitool.core.beanutils.reflection.access;

import java.io.InputStream;

public interface ClassLoaderAccessor {

	<T> Class<T> loadClass(String fqcn);
    
	InputStream getResourceStream(String name);
    
	
}
