package cs4321.project1;

import cs4321.project1.list.*;
import java.util.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Akhil Gopu (akg68) and Rong Tan (rt389)
 */

public class EvaluatePrefixListVisitor implements ListVisitor {
	
	Stack<Double> operands;
	Stack<ListNode> operators;
	int operandCount;

	public EvaluatePrefixListVisitor() {
		operands = new Stack<Double>();
		operators = new Stack<ListNode>();
	}

	public double getResult() {
		return operands.peek();
	}

	@Override
	public void visit(NumberListNode node) {
		operands.push(node.getData());
		operandCount++;
		if (operandCount >= 2)
		{
			double tmp1 = operands.pop();
			double tmp2 = operands.pop();
			operandCount -= 2;
			ListNode operate = operators.pop();
			if (operate instanceof AdditionListNode)
				operands.push(tmp1 + tmp2);
			else if (operate instanceof SubtractionListNode)
				operands.push(tmp2 - tmp1); //pop off stack in reverse order
			else if (operate instanceof MultiplicationListNode)
				operands.push(tmp1 * tmp2);
			else if (operate instanceof DivisionListNode)
				operands.push(tmp2 / tmp1);
		}
	}

	@Override
	public void visit(AdditionListNode node) {
		operators.push(node);
	}

	@Override
	public void visit(SubtractionListNode node) {
		operators.push(node);
	}

	@Override
	public void visit(MultiplicationListNode node) {
		operators.push(node);
	}

	@Override
	public void visit(DivisionListNode node) {
		operators.push(node);
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		operands.push(((NumberListNode)node.getNext()).getData() * -1.0);
	}
}
