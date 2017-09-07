package cs4321.project1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.BuildPostfixExpressionTreeVisitor;
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

	// Test Tree: -1+2+3-4
	// Pre fix expression 1 + - 1 + 2 - 3 4
	@Test
	public void test3() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new LeafTreeNode(3.0);
		TreeNode n4 = new LeafTreeNode(4.0);
		TreeNode nunary = new UnaryMinusTreeNode(n1);
		TreeNode nplus = new SubtractionTreeNode(n3, n4);
		TreeNode nplus2 = new AdditionTreeNode(n2, nplus);
		TreeNode nplus3 = new AdditionTreeNode(nunary, nplus2);

		BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		nplus3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof AdditionListNode);
		ListNode first = result.getNext();
		assertTrue(first instanceof UnaryMinusListNode);
		ListNode second = first.getNext();
		assertTrue(second instanceof NumberListNode);
		assertEquals(((NumberListNode) second).getData(), 1.0, DELTA);
		ListNode third = second.getNext();
		assertTrue(third instanceof AdditionListNode);
		ListNode fourth = third.getNext();
		assertTrue(fourth instanceof NumberListNode);
		assertEquals(((NumberListNode) fourth).getData(), 2.0, DELTA);
		ListNode fifth = fourth.getNext();
		assertTrue(fifth instanceof SubtractionListNode);
		ListNode sixth = fifth.getNext();
		assertTrue(sixth instanceof NumberListNode);
		assertEquals(((NumberListNode) sixth).getData(), 3.0, DELTA);
		ListNode seventh = sixth.getNext();
		assertTrue(seventh instanceof NumberListNode);
		assertEquals(((NumberListNode) seventh).getData(), 4.0, DELTA);
	}

	// Test Tree: -1*2*3/4
	// Post fix expression 1 - 2 3 4 * * / 
	@Test
	public void test4() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new LeafTreeNode(3.0);
		TreeNode n4 = new LeafTreeNode(4.0);
		TreeNode nunary = new UnaryMinusTreeNode(n1);
		TreeNode nplus = new DivisionTreeNode(n3, n4);
		TreeNode nplus2 = new MultiplicationTreeNode(n2, nplus);
		TreeNode nplus3 = new MultiplicationTreeNode(nunary, nplus2);

		BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		nplus3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof MultiplicationListNode);
		ListNode first = result.getNext();
		assertTrue(first instanceof UnaryMinusListNode);
		ListNode second = first.getNext();
		assertTrue(second instanceof NumberListNode);
		assertEquals(((NumberListNode) second).getData(), 1.0, DELTA);
		ListNode third = second.getNext();
		assertTrue(third instanceof MultiplicationListNode);
		ListNode fourth = third.getNext();
		assertTrue(fourth instanceof NumberListNode);
		assertEquals(((NumberListNode) fourth).getData(), 2.0, DELTA);
		ListNode fifth = fourth.getNext();
		assertTrue(fifth instanceof DivisionListNode);
		ListNode sixth = fifth.getNext();
		assertTrue(sixth instanceof NumberListNode);
		assertEquals(((NumberListNode) sixth).getData(), 3.0, DELTA);
		ListNode seventh = sixth.getNext();
		assertTrue(seventh instanceof NumberListNode);
		assertEquals(((NumberListNode) seventh).getData(), 4.0, DELTA);
	}
	
}
