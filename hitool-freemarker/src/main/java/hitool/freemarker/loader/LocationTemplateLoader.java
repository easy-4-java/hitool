package hitool.freemarker.loader;

import java.net.URL;

import freemarker.cache.URLTemplateLoader;
import hitool.core.lang3.wraper.ClassLoaderWrapper;

/**
 * Implementation of location template loader extending URLTemplateLoader.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class LocationTemplateLoader extends URLTemplateLoader {
   
	private final ClassLoaderWrapper classLoaderWrapper = new ClassLoaderWrapper();
	
	protected URL getURL(String name) {
        return classLoaderWrapper.getResourceAsURL(name);
    }
    
}	
