/**
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 * All Rights Reserved. 
 */
package hitool.core.lang3.bundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Implementation of empty resource bundle extending ResourceBundle.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class EmptyResourceBundle extends ResourceBundle {
	
    @Override
    public Enumeration<String> getKeys() {
        return null; // dummy
    }

    @Override
    protected Object handleGetObject(String key) {
        return null; // dummy
    }
    
}
