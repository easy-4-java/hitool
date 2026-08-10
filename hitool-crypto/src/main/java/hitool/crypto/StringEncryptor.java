package hitool.crypto;

import org.apache.commons.codec.EncoderException;

/**
 * Contract interface for StringEncryptor operations.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface StringEncryptor extends org.apache.commons.codec.StringEncoder {
	
	public String encode(String plainText, int times) throws EncoderException;
	
}
