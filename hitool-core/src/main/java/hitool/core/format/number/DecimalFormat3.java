package hitool.core.format.number;

import java.text.DecimalFormat;
/**
 * Implementation of decimal format3 functionality.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class DecimalFormat3 {    
    public static void main(String args[]) {    
        DecimalFormat df = new DecimalFormat("0.000E0000");    
        System.out.println(df.format(1234.56));    
    }    
}  