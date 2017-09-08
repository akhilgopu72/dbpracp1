package cs4321.project1.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs4321.project1.EvaluatePostfixListVisitor;
import cs4321.project1.EvaluateTreeVisitor;
import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.ListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.NumberListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.UnaryMinusListNode;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.TreeNode;

public class EvaluatePostfixListVisitorTest0 {
	private static final double DELTA = 1e-15;
	
	
	@Test
	public void testComplexPostfix() {
		//Expresion is : 3 18 ~ 5 3 2 - + / *
		ListNode n1 = new NumberListNode(3.0); 
		ListNode n2 = new NumberListNode(18.0); 
		ListNode n3 = new UnaryMinusListNode();
		ListNode n4 = new NumberListNode(5.0);
		ListNode n5 = new NumberListNode(3.0);
		ListNode n6 = new NumberListNode(2.0);
		ListNode n7 = new SubtractionListNode();
		ListNode n8 = new AdditionListNode();
		ListNode n9 = new DivisionListNode();
		ListNode n10 = new MultiplicationListNode();
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n9);
		n9.setNext(n10);
        EvaluatePostfixListVisitor v1 = new EvaluatePostfixListVisitor();
		n1.accept(v1);
		assertEquals(-9.0, v1.getResult(), DELTA);
	}
	
	@Test
	public void testComplexPostfix1() {
		//Expresion is : 2 ~ 3 ~ * ~
		ListNode n1 = new NumberListNode(2.0);
		ListNode n2 = new UnaryMinusListNode();
		ListNode n3 = new NumberListNode(3.0); 
		ListNode n4 = new UnaryMinusListNode();
		ListNode n5 = new MultiplicationListNode();
		ListNode n6 = new UnaryMinusListNode();
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);

        EvaluatePostfixListVisitor v1 = new EvaluatePostfixListVisitor();
		n1.accept(v1);
		assertEquals(-6.0, v1.getResult(), DELTA);
	}
	
	@Test
	public void testComplexPostfix2() {
		//Expresion is : 2 ~ 3 ~ * ~
		ListNode n1 = new NumberListNode(2.0);
		ListNode n2 = new NumberListNode(1.0);
		ListNode n3 = new MultiplicationListNode();
		ListNode n4 = new UnaryMinusListNode();
		ListNode n5 = new UnaryMinusListNode();
		ListNode n6 = new UnaryMinusListNode();
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);

        EvaluatePostfixListVisitor v1 = new EvaluatePostfixListVisitor();
		n1.accept(v1);
		assertEquals(-2.0, v1.getResult(), DELTA);
	}
	
	@Test
	public void testComplexPostfix3() {
		//Expresion is : 18 ~ 5 3 2 - + / 3 *
		ListNode n1 = new NumberListNode(18.0);
		ListNode n2 = new UnaryMinusListNode();
		ListNode n3 = new NumberListNode(5.0);
		ListNode n4 = new NumberListNode(3.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new SubtractionListNode();
		ListNode n7 = new AdditionListNode();
		ListNode n8 = new DivisionListNode();
		ListNode n9 = new NumberListNode(3.0);
		ListNode n10 = new MultiplicationListNode();

		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n9);
		n9.setNext(n10);

        EvaluatePostfixListVisitor v1 = new EvaluatePostfixListVisitor();
		n1.accept(v1);
		assertEquals(-9.0, v1.getResult(), DELTA);
	}

}
