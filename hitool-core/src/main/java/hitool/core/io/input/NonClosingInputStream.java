package hitool.core.io.input;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Implementation of non closing input stream extending FilterInputStream.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public class NonClosingInputStream extends FilterInputStream {

	public NonClosingInputStream(InputStream input) {
		super(input);
	}

	@Override
	public void close() throws IOException {
	}

}