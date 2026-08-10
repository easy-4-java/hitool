package hitool.crypto;

import java.security.cert.Certificate;
import java.util.Date;

/**
 * 
 * 证书验证接口
 */
public interface CertificateVerifier {

	/**
	 * 
	 *  判断证书是否过期
	 * @param date
	 * @param certificate
	 * @return
	 */
	boolean expire(Date date, Certificate certificate);
	boolean expire(Certificate certificate);
	boolean expire(String certificatePath);
	boolean expire(Date date, String certificatePath);
	
	boolean verify(String keyStorePath, String alias,String password);
	
	boolean verify(Date date, String keyStorePath,String alias, String password);
	
	boolean verify(byte[] data, String sign,String certificatePath) throws Exception;
	
}
