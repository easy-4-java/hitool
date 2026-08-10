package hitool.crypto;

import org.apache.commons.codec.DecoderException;

/**
 * Interface providing functionality for BinaryDecryptor.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface BinaryDecryptor extends org.apache.commons.codec.BinaryDecoder {

	public byte[] decode(byte[] encryptedBytes, int times) throws DecoderException;
	
}
