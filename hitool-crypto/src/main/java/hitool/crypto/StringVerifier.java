package hitool.crypto;

import org.apache.commons.codec.EncoderException;


/**
 * Contract interface for StringVerifier operations.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface StringVerifier {
	
	public boolean verify(String plainText,String key) throws EncoderException;
	
	public boolean verify(String plainText,String key, int times) throws EncoderException;
	
}
