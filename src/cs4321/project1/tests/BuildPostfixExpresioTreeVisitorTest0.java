package cs4321.project1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.BuildPostfixExpressionTreeVisitor;
import cs4321.project1.list.ListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.NumberListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.SubtractionTreeNode;
import cs4321.project1.tree.TreeNode;

public class BuildPostfixExpresioTreeVisitorTest0 {

	private static final double DELTA = 1e-15;
	
	//Test Tree: 1-(2*3)
	@Test
	public void test() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3= new LeafTreeNode(3.0);
		TreeNode nmuiltiply = new MultiplicationTreeNode(n2, n3);
		TreeNode nminus = new SubtractionTreeNode(n1, nmuiltiply);
		
        BuildPostfixExpressionTreeVisitor v1 = new BuildPostfixExpressionTreeVisitor();
		nminus.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		ListNode first = result.getNext();
		assertTrue(first instanceof NumberListNode);
		assertEquals(((NumberListNode) first).getData(), 2.0, DELTA);
		ListNode second = first.getNext();
		assertTrue(second instanceof NumberListNode);
		assertEquals(((NumberListNode) second).getData(), 3.0, DELTA);
		ListNode third = second.getNext();
		assertTrue(third instanceof MultiplicationListNode);
		ListNode fourth = third.getNext();
		assertTrue(fourth instanceof SubtractionListNode);
	}

}
