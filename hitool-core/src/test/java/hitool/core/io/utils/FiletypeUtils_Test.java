package hitool.core.io.utils;

import java.io.File;

import hitool.core.io.FiletypeUtils;
import junit.framework.TestCase;

public class FiletypeUtils_Test extends TestCase {

	
	public void testname() throws Exception {
		
		
		byte[] jarHeader = new byte[] {0x50, 0x4B, 0x03, 0x04, 0x0A, 0, 0, 0, 0, 0, 0};
		assertEquals("jar", FiletypeUtils.getFileType(jarHeader));
		
	}
	
}
