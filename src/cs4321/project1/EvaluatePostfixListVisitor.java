package cs4321.project1;

import java.util.*;
import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;
import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

/**
 * Provide a comment about what your class does and the overall logic
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
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1+tmp2);
	}

	@Override
	public void visit(SubtractionListNode node) {
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1-tmp2);
	}

	@Override
	public void visit(MultiplicationListNode node) {
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1*tmp2);
	}

	@Override
	public void visit(DivisionListNode node) {
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1/tmp2);
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		double tmp1 = aStack.pop();
		aStack.push(tmp1 * -1.0);
	}

}
