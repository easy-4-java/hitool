package hitool.core.lang3;

import hitool.core.lang3.network.MacAddressUtils;

import junit.framework.TestCase;

public class MacAddressUtils_Test extends TestCase {

	public void testMacAddress_1() {
		for (String mac : MacAddressUtils.getAllMacAddresses()) {
			System.out.println("Mac Address is : "+ mac);
		}
	}

	public void testRemoteMacAddr_2() {
		System.out.println("MacAddress is : " + MacAddressUtils.getMacAddress());
	}
	
	public void testRemoteMacAddr_4() {
		System.out.println("RemoteMacAddr is : " + MacAddressUtils.getRemoteMacAddr("192.168.31.1"));
	}
	
	public void testRemoteMacAddr_3() {
		assertNull(MacAddressUtils.getHostMacAddress("127.0.0.1"));
	}
	
}
