package cs4321.project1.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs4321.project1.EvaluateTreeVisitor;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.TreeNode;
import cs4321.project1.tree.UnaryMinusTreeNode;

public class EvaluateTreeVisitorTest0 {
	
	private static final double DELTA = 1e-15;
	
	@Test
	public void testEvalTreeVisitor(){
		TreeNode n1 = new LeafTreeNode(12.0); 
		TreeNode n2 = new LeafTreeNode(2.0); 
		TreeNode n3 = new LeafTreeNode(3.0); 
		TreeNode n4 = new UnaryMinusTreeNode(n1); 
		TreeNode n5 = new MultiplicationTreeNode(n2, n3);
        TreeNode n6 = new DivisionTreeNode(n4, n5);
        TreeNode n7 = new LeafTreeNode(5.0);
        TreeNode n8 = new AdditionTreeNode(n7, n6);
        TreeNode n9 = new UnaryMinusTreeNode(n8);
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor(); 
        n9.accept(v1);
		assertEquals(-3.0, v1.getResult(), DELTA);
	}
	
	@Test
	public void testEvalTreeVisitor1(){
		TreeNode n1 = new LeafTreeNode(3.0);
		TreeNode n2 = new LeafTreeNode(1.0);
		TreeNode n3 = new UnaryMinusTreeNode(n1); 
		TreeNode n4 = new UnaryMinusTreeNode(n2);
		TreeNode n5 = new MultiplicationTreeNode(n3, n4);
		TreeNode n6 = new UnaryMinusTreeNode(n5);
		TreeNode n7 = new UnaryMinusTreeNode(n6);
		TreeNode n8 = new UnaryMinusTreeNode(n7);
		
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor(); 
        n8.accept(v1);
		assertEquals(-3.0, v1.getResult(), DELTA);
	}
	
	@Test
	public void testEvalTreeVisitor2(){
		TreeNode n1 = new LeafTreeNode(3.0);
	
		
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor(); 
        n1.accept(v1);
		assertEquals(3.0, v1.getResult(), DELTA);
	}
	

}
