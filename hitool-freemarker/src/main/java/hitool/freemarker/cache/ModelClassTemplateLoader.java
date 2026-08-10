package hitool.freemarker.cache;

import java.net.URL;

import freemarker.cache.URLTemplateLoader;
import hitool.core.io.ResourceUtils;

/**
 * Class providing functionality for ModelClassTemplateLoader.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class ModelClassTemplateLoader extends URLTemplateLoader {
   
	protected URL getURL(String name) {
    	return ResourceUtils.getResourceAsURL(name, getClass());
    }
    
}