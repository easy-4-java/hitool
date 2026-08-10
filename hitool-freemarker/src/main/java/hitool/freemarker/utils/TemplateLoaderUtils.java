package hitool.freemarker.utils;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;

/**
 * Implementation of template loader utils functionality.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class TemplateLoaderUtils {

	 public static String getClassNameForToString(TemplateLoader templateLoader) {
        final Class<? extends TemplateLoader> tlClass = templateLoader.getClass();
        final Package tlPackage = tlClass.getPackage();
        return tlPackage == Configuration.class.getPackage() || tlPackage == TemplateLoader.class.getPackage()
                ? getSimpleName(tlClass) : tlClass.getName();
    }

    // [Java 5] Replace with Class.getSimpleName()
    private static String getSimpleName(final Class<? extends TemplateLoader> tlClass) {
        final String name = tlClass.getName();
        int lastDotIdx = name.lastIndexOf('.'); 
        return lastDotIdx < 0 ? name : name.substring(lastDotIdx + 1);
    }
	
}
