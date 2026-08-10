package hitool.core.format.number;

/**
 * Class providing functionality for DoubleNumberUtils.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class DoubleNumberUtils {
    
    public static double doubleValue(Object obj, double dfl) {
        double ret = dfl;
        if (obj != null) {
            if (obj instanceof Number) {
                ret = ((Number) obj).doubleValue();
            } else {
                try {
                    ret = Double.parseDouble(obj.toString());
                } catch (NumberFormatException e) {
                    // not an exception condition, fall back to using the
                    // supplied default
                }
            }
        }

        return ret;
    }

    public static double doubleValue(Object s) {
        return doubleValue(s, 0);
    }
}
