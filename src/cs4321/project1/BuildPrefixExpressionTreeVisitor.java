package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Rong Tan (rt389) Akhil Gopu (akg68)
 */
public class BuildPrefixExpressionTreeVisitor implements TreeVisitor {

	private ListNode node0; // the very first node
	private ListNode nodex; // the temp node attached after the very first node

	public BuildPrefixExpressionTreeVisitor() {
		node0 = new NumberListNode(0);
		nodex = node0;
	}

	public ListNode getResult() {
		return node0.getNext();
	}

	@Override
	public void visit(LeafTreeNode node) {
		nodex.setNext(new NumberListNode(node.getData()));
		nodex = nodex.getNext();
	}

	@Override
	public void visit(UnaryMinusTreeNode node) {
		nodex.setNext(new UnaryMinusListNode());
		nodex = nodex.getNext();
		node.getChild().accept(this);
	}

	@Override
	public void visit(AdditionTreeNode node) {
		nodex.setNext(new AdditionListNode());
		nodex = nodex.getNext();
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

	@Override
	public void visit(MultiplicationTreeNode node) {
		nodex.setNext(new MultiplicationListNode());
		nodex = nodex.getNext();
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

	@Override
	public void visit(SubtractionTreeNode node) {
		nodex.setNext(new MultiplicationListNode());
		nodex = nodex.getNext();
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

	@Override
	public void visit(DivisionTreeNode node) {
		nodex.setNext(new DivisionListNode());
		nodex = nodex.getNext();
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
	}

}
