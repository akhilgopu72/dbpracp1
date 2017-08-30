package cs4321.project1;

import java.util.*;
import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;
import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

/**
 * This class uses a stack to keep track of the integers being processed.
 * As each integer gets reviewed, it gets pushed. When there are 2 integers on the queue,
 * an operator will definitely be next because of the way postfix lists work. When that operation
 * is complete, the new operand will get pushed back to the stack and so on until there 
 * is only operand left.
 * 
 * @author Akhil Gopu (akg68) and Rong Tan (rt389)
 */
public class EvaluatePostfixListVisitor implements ListVisitor {
	
	private Stack<Double> aStack;

	public EvaluatePostfixListVisitor() {
		aStack = new Stack<Double>();
	}

	public double getResult() {
		return aStack.peek();
	}

	@Override
	public void visit(NumberListNode node) {
		aStack.push(node.getData());
	}

	@Override
	public void visit(AdditionListNode node) {
		node.getNext().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1+tmp2);
	}

	@Override
	public void visit(SubtractionListNode node) {
		node.getNext().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1-tmp2);
	}

	@Override
	public void visit(MultiplicationListNode node) {
		node.getNext().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1*tmp2);
	}

	@Override
	public void visit(DivisionListNode node) {
		node.getNext().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1/tmp2);
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		node.getNext().accept(this);
		double tmp1 = aStack.pop();
		aStack.push(tmp1 * -1.0);
	}

}
