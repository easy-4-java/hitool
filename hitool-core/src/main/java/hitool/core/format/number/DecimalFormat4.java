package hitool.core.format.number;

import java.text.NumberFormat;
/**
 * Class providing functionality for DecimalFormat4.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class DecimalFormat4 {    
    public static void main(String args[]) {    
        NumberFormat nf = NumberFormat.getPercentInstance();    
        System.out.println(nf.format(0.47));    
    }    
}  