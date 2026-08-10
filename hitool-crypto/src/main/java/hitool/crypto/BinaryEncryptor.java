package hitool.crypto;

import org.apache.commons.codec.EncoderException;

/**
 * Contract interface for BinaryEncryptor operations.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface BinaryEncryptor extends org.apache.commons.codec.BinaryEncoder{

	public byte[] encode(byte[] plainBytes, int times) throws EncoderException;
	
}
