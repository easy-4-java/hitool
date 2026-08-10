package hitool.core.format.number;

/**
 * Class providing functionality for IntegerNumberUtils.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class IntegerNumberUtils {
    
    public static int intValue(Object obj, int dfl) {
        int ret = dfl;
        if (obj != null) {
            if (obj instanceof Number) {
                ret = ((Number) obj).intValue();
            } else {
                try {
                    ret = Integer.parseInt(obj.toString());
                } catch (NumberFormatException e) {
                    // not an exception condition, fall back to using the
                    // supplied default
                }
            }
        }

        return ret;
    }

    public static int intValue(Object s) {
        return intValue(s, 0);
    }
}
