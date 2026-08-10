package hitool.crypto;

import org.apache.commons.codec.DecoderException;

/**
 * Contract interface for BinaryDecryptor operations.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public interface BinaryDecryptor extends org.apache.commons.codec.BinaryDecoder {

	public byte[] decode(byte[] encryptedBytes, int times) throws DecoderException;
	
}
