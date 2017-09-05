package cs4321.project1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.BuildPrefixExpressionTreeVisitor;
import cs4321.project1.list.*;
import cs4321.project1.tree.*;
public class BuildPrefixExpressionTreeVisitorTest0 {

	private static final double DELTA = 1e-15;
	
	//Test Tree: 1-(2*3)
	@Test
	public void test() {
		
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3= new LeafTreeNode(3.0);
		TreeNode nmuiltiply = new MultiplicationTreeNode(n2, n3);
		TreeNode nminus = new SubtractionTreeNode(n1, nmuiltiply);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		nminus.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof SubtractionListNode);
		ListNode first = result.getNext();
		assertTrue(first instanceof NumberListNode);
		assertEquals(((NumberListNode) first).getData(), 1.0, DELTA);
		ListNode second = first.getNext();
		assertTrue(second instanceof MultiplicationListNode);
		ListNode third = second.getNext();
		assertTrue(third instanceof NumberListNode);
		assertEquals(((NumberListNode) third).getData(), 2.0, DELTA);
		ListNode fourth = third.getNext();
		assertTrue(fourth instanceof NumberListNode);
		assertEquals(((NumberListNode) third).getData(), 2.0, DELTA);
		
	}

}
