package cs4321.project1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.BuildPostfixExpressionTreeVisitor;
import cs4321.project1.BuildPrefixExpressionTreeVisitor;
import cs4321.project1.EvaluatePostfixListVisitor;
import cs4321.project1.EvaluatePrefixListVisitor;
import cs4321.project1.EvaluateTreeVisitor;
import cs4321.project1.Parser;
import cs4321.project1.list.ListNode;
import cs4321.project1.tree.TreeNode;

public class EvaluatePrefixListVisitorTEst0 {

	private static final double DELTA = 1e-15;
	
	@Test
	public void testComplexExpression1() {
		Parser p1 = new Parser("4.0 * 2.0 + 5.0");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();
		
		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();
		
		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();
		
		assertEquals(13.0, treeEvaluationResult, DELTA);
		assertEquals(13.0, prefixEvaluationResult, DELTA);
		assertEquals(13.0, postfixEvaluationResult, DELTA);

	}
}
