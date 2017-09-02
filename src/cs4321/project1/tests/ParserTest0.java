package cs4321.project1.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.Parser;
import cs4321.project1.PrintTreeVisitor;
import cs4321.project1.tree.TreeNode;

public class ParserTest0 {

	@Test
	public void test1() {
		Parser p1 = new Parser("1.0 + 2.0 * 3.5");
		TreeNode parseResult1 =  p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("(1.0+(2.0*3.5))", v1.getResult());
	}
	
	@Test
	public void test2() {
		Parser p1 = new Parser("1.0 * ( - 2.0 * 3.0 + 4.0 / 5.0 ) / 6.0");
		TreeNode parseResult1 =  p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);
		assertEquals("((1.0*(((-2.0)*3.0)+(4.0/5.0)))/6.0)", v1.getResult());
	}
}
