package hitool.crypto;

import hitool.crypto.keypair.KeyPairCrypto.KeyPairEntry;
import hitool.crypto.keypair.algorithm.RSABase64Crypto;
import hitool.crypto.keypair.algorithm.RSACrypto;
import hitool.crypto.keypair.algorithm.RSAHexCrypto;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * 三线相同的 RSA 字符串密文与 UTF-8 明文契约。
 */
public class RSAStringContractTest {

    private static final String PLAINTEXT = "订单-加密-测试";

    @Test
    public void rsaStringCiphertextIsBase64OfDecryptableBytes() throws Exception {
        RSACrypto crypto = new RSACrypto();
        KeyPairEntry<RSAPublicKey, RSAPrivateKey> keys = crypto.genKeyEntry(1024);

        String ciphertext = crypto.encrypt(PLAINTEXT, keys.getPublicKey());

        assertArrayEquals(PLAINTEXT.getBytes(StandardCharsets.UTF_8),
                crypto.decrypt(Base64.getDecoder().decode(ciphertext), keys.getPrivateKey()));
        assertEquals(PLAINTEXT, crypto.decrypt(ciphertext, keys.getPrivateKey()));
    }

    @Test
    public void hexStringCiphertextRoundTripsUtf8Plaintext() throws Exception {
        RSAHexCrypto crypto = RSAHexCrypto.instance();
        KeyPairEntry<RSAPublicKey, RSAPrivateKey> keys = crypto.genKeyEntry(1024);

        String ciphertext = crypto.encrypt(PLAINTEXT, keys.getPublicKey());

        assertArrayEquals(PLAINTEXT.getBytes(StandardCharsets.UTF_8),
                new RSACrypto().decrypt(Hex.decodeHex(ciphertext.toCharArray()), keys.getPrivateKey()));
        assertEquals(PLAINTEXT, crypto.decrypt(ciphertext, keys.getPrivateKey()));
    }

    @Test
    public void base64VariantRoundTripsUtf8Plaintext() throws Exception {
        RSABase64Crypto crypto = RSABase64Crypto.instance();
        KeyPairEntry<RSAPublicKey, RSAPrivateKey> keys = crypto.genKeyEntry(1024);

        String ciphertext = crypto.encrypt(PLAINTEXT, keys.getPublicKey());

        assertArrayEquals(PLAINTEXT.getBytes(StandardCharsets.UTF_8),
                new RSACrypto().decrypt(Base64.getDecoder().decode(ciphertext), keys.getPrivateKey()));
        assertEquals(PLAINTEXT, crypto.decrypt(ciphertext, keys.getPrivateKey()));
    }
}
