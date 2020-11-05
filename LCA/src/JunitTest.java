import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

class JunitTest {

	@Test
	void findLCA() {
		lowestCommonAncestor test1 = new lowestCommonAncestor();
		int output1 = test1.findLCA(4, 5);
		assertEquals(5, output1);
		
	}
	
	@Test
	void findLCAInternal() {
		lowestCommonAncestor test2 = new lowestCommonAncestor();
		int output2 = test2.findLCA(5, 5);
		assertEquals(5, output2);
		
	}
	
	@Test
	void findPath() {
		lowestCommonAncestor test3 = new lowestCommonAncestor();
	
	}

}
