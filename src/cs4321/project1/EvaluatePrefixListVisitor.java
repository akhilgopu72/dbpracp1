package cs4321.project1;

import cs4321.project1.list.*;
import java.util.*;

/**
 * The list will start inserting each element of itself onto its respective stack.
 * Once two integers are found, there must be at least one operator on the operator stack.
 * The operator is popped up and the operands are computed. Once complete, the new operand 
 * is pushed back onto the operand stack. This keeps happening until only operand is left.
 * 
 * @author Akhil Gopu (akg68) and Rong Tan (rt389)
 */

public class EvaluatePrefixListVisitor implements ListVisitor {
	
	Stack<Double> operands;
	Stack<ListNode> operators;
	int operandCount;
	boolean operatorFlag = false;

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
		if (operatorFlag)
		{
			double tmp1 = operands.pop();
			double tmp2 = operands.pop();
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
		operatorFlag = true;
		if (node.getNext() != null)
			node.getNext().accept(this);
		if (node.getNext() == null)
			processStacks();
	}
	
	public void processStacks() 
	{
		while (operators.empty() == false)
		{
		double tmp1 = operands.pop();
		double tmp2 = operands.pop();
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
		operatorFlag = false;
		operators.push(node);
		if (node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	public void visit(SubtractionListNode node) {
		operatorFlag = false;
		operators.push(node);
		if (node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	public void visit(MultiplicationListNode node) {
		operatorFlag = false;
		operators.push(node);
		if (node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	public void visit(DivisionListNode node) {
		operatorFlag = false;
		operators.push(node);
		if (node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	public void visit(UnaryMinusListNode node) {
		if (node.getNext() instanceof NumberListNode)
		{
			operands.push(((NumberListNode) (node.getNext())).getData() * -1.0);
			if (node.getNext().getNext() != null)
				node.getNext().getNext().accept(this);
		}
		else {
		if (node.getNext() != null)
			node.getNext().accept(this);
		operands.push(operands.pop() * -1.0);
		}
		
	}
}