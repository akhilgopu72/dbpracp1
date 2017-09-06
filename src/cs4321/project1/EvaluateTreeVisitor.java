package cs4321.project1;

import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.SubtractionTreeNode;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.UnaryMinusTreeNode;
import java.util.*;
/**
 * Used postorder method to go in order: left, right, root
 * This accomplishes the task of computing the left side of the tree and then the right
 * and using those two values to compute the root operation. Then this gets saved to our 
 * stack, and will remain there for this instance of EvaluateTreeVisitor
 * 
 * @author Rong Tan (rt389) and Akhil Gopu (akg68)
 */

public class EvaluateTreeVisitor implements TreeVisitor {
	private Stack<Double> aStack;
	
	public EvaluateTreeVisitor() {
		aStack = new Stack<Double>();
	}

	public double getResult() {
		return aStack.peek(); // so that skeleton code compiles
	}

	@Override
	public void visit(LeafTreeNode node) {
		aStack.push(node.getData());
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		if (node.getChild() instanceof LeafTreeNode)
			aStack.push(((LeafTreeNode)(node.getChild())).getData() * -1.0);
		else 
		{
			node.getChild().accept(this);
			double tmp1 = aStack.pop() * -1.0;
			aStack.push(tmp1);
		}
		
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
		aStack.push(tmp2 - tmp1);
	}

	@Override
	public void visit(DivisionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		double tmp1 = aStack.pop();
		double tmp2 = aStack.pop();
		aStack.push(tmp2 / tmp1);
	}
}