package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Akhil Gopu (akg68) and Rong Tan (rt389)
 */
public class BuildPostfixExpressionTreeVisitor implements TreeVisitor {

	private ListNode node0; // the very first node
	private ListNode nodex; // the temp node attached after the very first node

	/**
	 * Method to initialize node0, and nodex
	 */
	public BuildPostfixExpressionTreeVisitor() {
		node0 = new NumberListNode(0);
		nodex = node0;
	}
	
	/**
	 * Method to return the first listNode we generated
	 * 
	 * @return the starting node of the whole list, which is the next node of node0
	 */
	public ListNode getResult() {
		return node0.getNext();
	}
	
	/**
	 * Method to attach the information of node to nodex in postfix order when visitor is done
	 * 
	 * @param the LeafTreeNode to get a postfix expression
	 */
	@Override
	public void visit(LeafTreeNode node) {
		nodex.setNext(new NumberListNode(node.getData()));
		nodex = nodex.getNext();
	}
	
	/**
	 * Method to attach the information of node and its child to nodex in postfix order when visitor is done
	 * 
	 * @param the UnaryMinusTreeNode to get a postfix expression
	 */
	@Override
	public void visit(UnaryMinusTreeNode node) {
		node.getChild().accept(this);
		nodex.setNext(new UnaryMinusListNode());
		nodex = nodex.getNext();
	}
	
	/**
	 * Method to attach the information of node and its child to nodex in postfix order when visitor is done
	 * 
	 * @param the AdditionTreeNode to get a postfix expression
	 */
	@Override
	public void visit(AdditionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		nodex.setNext(new AdditionListNode());
		nodex = nodex.getNext();
	}

	/**
	 * Method to attach the information of node and its child to nodex in postfix order when visitor is done
	 * 
	 * @param the MultiplicationTreeNode to get a postfix expression
	 */
	@Override
	public void visit(MultiplicationTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		nodex.setNext(new MultiplicationListNode());
		nodex = nodex.getNext();
	}

	/**
	 * Method to attach the information of node and its child to nodex in postfix order when visitor is done
	 * 
	 * @param the SubtractionTreeNode to get a postfix expression
	 */
	@Override
	public void visit(SubtractionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		nodex.setNext(new MultiplicationListNode());
		nodex = nodex.getNext();
	}

	/**
	 * Method to attach the information of node and its child to nodex when visitor is done
	 * 
	 * @param the DivisionTreeNode to get a postfix expression
	 */
	@Override
	public void visit(DivisionTreeNode node) {
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		nodex.setNext(new DivisionListNode());
		nodex = nodex.getNext();
	}

}
