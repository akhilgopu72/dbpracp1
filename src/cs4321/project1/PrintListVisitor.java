package cs4321.project1;

import cs4321.project1.list.*;

/**
 * Provide a comment about what your class does and the overall logic
 * 
 * @author Akhil Gopu (akg68) Rong Tan (rt389)
 */

public class PrintListVisitor implements ListVisitor {

	private String result; // running string representation

	public PrintListVisitor() {
		result = "";
	}

	/**
	 * Method to get the finished string representation when visitor is done
	 * 
	 * @return string representation of the visited list
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Visit method for number node; just concatenates the numeric value to the
	 * running string
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(NumberListNode node) {
		result += node.getData();
		if (node.getNext() != null) {
			result += " ";
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for addition node by adding + to the original result string
	 * and proceed to the next node in the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(AdditionListNode node) {
		result += "+";
		if (node.getNext() != null) {
			result += " ";
			node.getNext().accept(this);
		}
	}
	
	/**
	 * Visit method for addition node by adding - to the original result string
	 * and proceed to the next node in the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(SubtractionListNode node) {
		result += "-";
		if (node.getNext() != null) {
			result += " ";
			node.getNext().accept(this);
		}
	}

	/**
	 * Visit method for addition node by adding * to the original result string
	 * and proceed to the next node in the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(MultiplicationListNode node) {
		result += "*";
		if (node.getNext() != null) {
			result += " ";
			node.getNext().accept(this);
		}

	}

	/**
	 * Visit method for addition node by adding / to the original result string
	 * and proceed to the next node in the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(DivisionListNode node) {
		result += "/";
		if (node.getNext() != null) {
			result += " ";
			node.getNext().accept(this);
		}

	}
	
	/**
	 * Visit method for addition node by adding ~ to the original result string
	 * and proceed to the next node in the list
	 * 
	 * @param node
	 *            the node to be visited
	 */
	@Override
	public void visit(UnaryMinusListNode node) {
		result += "~";
		if (node.getNext() != null) {
			result += " ";
			node.getNext().accept(this);
		}

	}

}
