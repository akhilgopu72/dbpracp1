package cs4321.project1;

import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.SubtractionTreeNode;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.UnaryMinusTreeNode;
import java.util.*;
/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Rong Tan (rt389) and Akhil Gopu (akg68)
 */

public class EvaluateTreeVisitor implements TreeVisitor {
	private Stack<Double> aStack;
	
	public EvaluateTreeVisitor() {
		aStack = new Stack();
		// TODO fill me in
	}

	public double getResult() {
		// TODO fill me in
		return aStack.peek(); // so that skeleton code compiles
	}

	@Override
	public void visit(LeafTreeNode node) {
		aStack.push(node.getData());
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		if (node.getChild() instanceof LeafTreeNode)
			aStack.push(((LeafTreeNode)node.getChild()).getData() * -1.0);
	}

	@Override
	public void visit(AdditionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1 + tmp2);
	}

	@Override
	public void visit(MultiplicationTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1 * tmp2);
	}

	@Override
	public void visit(SubtractionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1 - tmp2);
	}

	@Override
	public void visit(DivisionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp1 / tmp2);
	}
}