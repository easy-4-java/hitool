package hitool.crypto;

import org.apache.commons.codec.DecoderException;

/**
 * Interface providing functionality for StringDecryptor.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface StringDecryptor extends org.apache.commons.codec.StringDecoder{

	public String decode(String encryptedText, int times) throws DecoderException;
	
}
