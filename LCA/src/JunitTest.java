import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 

class JunitTest {

	//checks if findLCA works for negative numbers
	@Test
	void testLCAForNonPositive() {
		LCA test = new LCA();
		test.root = new Node(-3); 
		test.root.left = new Node(-2); 
		test.root.right = new Node(-5); 
		int output1 = test.findLCA(-2, -5);
		assertEquals(-3, output1);
		
	}
	
	//checks if node constructor works as expected
	@Test
	void nodeConstructor() {
		Node test = new Node(1);
		assertNotNull("Node constructor test: ", test);
	}
	
	//checks what happens when a node that is not part of tree is queried 
	@Test
	void nonExistentNodeTest() {
		LCA test = new LCA();
		test.root = new Node(1);
		test.root.left = new Node(2);
		test.root.right = new Node(3);
		test.root.left.left = new Node(4);
		test.root.left.right = new Node(5);
		test.root.right.left = new Node(6);
		test.root.right.right = new Node(7);

		assertEquals(-1, test.findLCA(8, 9));//-1 = FALSE
		assertEquals(-1, test.findLCA(33, 132));
	}
	
	//checks to see if program can find LCA with only two nodes
	@Test
	void onlyTwo() {
		LCA test = new LCA();
		test.root = new Node(1);
		test.root.right = new Node(2);
		assertEquals(1, test.findLCA(1, 2));
		
	}
	
}
