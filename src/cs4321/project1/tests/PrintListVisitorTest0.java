package cs4321.project1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.PrintListVisitor;
import cs4321.project1.list.*;

public class PrintListVisitorTest0 {

	//Prefix order of (-1.0)*2.0+(3.0/4.0)
	@Test
	public void test() {
		ListNode n1 = new AdditionListNode();
		ListNode n2 = new MultiplicationListNode();
		ListNode n3 = new UnaryMinusListNode();
		ListNode n4 = new NumberListNode(1.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new DivisionListNode();
		ListNode n7 = new NumberListNode(3.0);
		ListNode n8 = new NumberListNode(4.0);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		PrintListVisitor pv1 = new PrintListVisitor();
		n1.accept(pv1);
		assertEquals("+ * ~ 1.0 2.0 / 3.0 4.0", pv1.getResult());
	}

}
