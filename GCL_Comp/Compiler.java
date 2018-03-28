/* Authors:
 * 	Sergiu Ojog, s164587
 * 	Nicholas Rose, s164580
 * 	Bosse Bandowski, s164582
 * 
 * This program is based on the provided Calculator example as it is very similar in functionality.
 * It reads the input from the console and tries to parse it. To do so, it recursively iterates over the tree which is defined by the input and the accompanying .g file.
 * In order to implement the error handler as desired by the task description, it is needed to override the standard inbuilt error handler of ANTLR. This requires a few imports:
 */

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import java.io.File;
import java.io.PrintWriter;

public class Compiler {
	
	Output myString = new Output();

	public static void main(String args[]) throws Exception  {

		try {
			// Instantiate a new class member
			Compiler c = new Compiler();
			c.run();
			System.out.println("ok");
		}
		catch (Exception  e) {
			System.out.println("ko");
			// e.printStackTrace ();
		}
	}

	public void run() throws Exception  {

		Checkup check = new Checkup();

		// Read an expression from the console
		System.out.print("Enter your code: ");
		String input = System.console().readLine();

		// Build the parser for the content of the input in several steps

		// Translate the input string into stream of characters
		CharStream inputStream = CharStreams.fromString(input);

		// Create a lexer for the CharStream
		CompilerLexer lex = new CompilerLexer(inputStream);

		// Use the lexer to generate the token stream
		CommonTokenStream tokens = new CommonTokenStream(lex);

		// Create a parser for the given token stream
		CompilerParser parser = new CompilerParser(tokens);
		
		// Remove the inbuilt ANTLR error handler
		lex.removeErrorListeners();
		parser.removeErrorListeners();
		parser.setErrorHandler(new BailErrorStrategy());


		myString.append(check.visit(parser.start()));
		myString.createFile();
		
        
	}
	
	public class Output {
		String oString = "digraph program_graph {rankdir=LR;\n" + 
				"node [shape = circle]; q▷;\n" + 
				"node [shape = doublecircle]; q◀; \n" + 
				"node [shape = circle]";
		int nodeCount = 0;
		
		public void append (String txt) {
			this.oString = this.oString + "\n" + txt;
		}
		
		public void appendEdge (String label, int startNode, int targetNode) {
			
			String edge;
			
			if (this.nodeCount == 0) {
				edge = "q�-� -> q" + Integer.toString(targetNode) + " [label = \"" + label +"\"];";
			} else {
				edge = "q" + Integer.toString(startNode) +" -> q" + Integer.toString(targetNode) + " [label = \"" + label +"\"];";
			}

			this.append(edge);
		}
		
		public void createFile () {
			
			this.append("}");
			
			File f = new File("PG.gv");
	        
	        try (PrintWriter out = new PrintWriter(f)) {
	            out.println(this.oString);
		        f.createNewFile();
	        }
	        catch (Exception e) {
	        	System.out.println("Couldn't write to file");
	        }
		}
		
	}


	public class Checkup extends CompilerBaseVisitor<String> {
	
			// This implements the grammar defined in the .g file. Each node's children are visited to iterate over the tree.
			// We now need to return strings that match the .gv file format and append them in an output file

			@Override public String visitStart(CompilerParser.StartContext ctx) {return visitChildren(ctx);}
			@Override public String visitVarDef(CompilerParser.VarDefContext ctx) {
				return (visit(ctx.lhs)); }// + " := " + visit(ctx.rhs)); }
			@Override public String visitAppend(CompilerParser.AppendContext ctx) { return visitChildren(ctx); }
			@Override public String visitDoLoop(CompilerParser.DoLoopContext ctx) { return visitChildren(ctx); }
			@Override public String visitSkip(CompilerParser.SkipContext ctx) { return visitChildren(ctx); }
			@Override public String visitIf(CompilerParser.IfContext ctx) { return visitChildren(ctx); }
			@Override public String visitIfElif(CompilerParser.IfElifContext ctx) { return visitChildren(ctx); }
			@Override public String visitIfThen(CompilerParser.IfThenContext ctx) { return visitChildren(ctx); }
			@Override public String visitPlusExpr(CompilerParser.PlusExprContext ctx) { return visitChildren(ctx); }
			@Override public String visitVar(CompilerParser.VarContext ctx) { return visitChildren(ctx); }
			@Override public String visitNum(CompilerParser.NumContext ctx) { return visitChildren(ctx); }
			@Override public String visitPowExpr(CompilerParser.PowExprContext ctx) { return visitChildren(ctx); }
			@Override public String visitNestedExpr(CompilerParser.NestedExprContext ctx) { return visitChildren(ctx); }
			@Override public String visitProdExpr(CompilerParser.ProdExprContext ctx) { return visitChildren(ctx); }
			@Override public String visitUMinusExpr(CompilerParser.UMinusExprContext ctx) { return visitChildren(ctx); }
			@Override public String visitMinusExpr(CompilerParser.MinusExprContext ctx) { return visitChildren(ctx); }
			@Override public String visitOr(CompilerParser.OrContext ctx) { return visitChildren(ctx); }
			@Override public String visitTrue(CompilerParser.TrueContext ctx) { return visitChildren(ctx); }
			@Override public String visitSmallerEqual(CompilerParser.SmallerEqualContext ctx) { return visitChildren(ctx); }
			@Override public String visitFalse(CompilerParser.FalseContext ctx) { return visitChildren(ctx); }
			@Override public String visitUnequal(CompilerParser.UnequalContext ctx) { return visitChildren(ctx); }
			@Override public String visitNeg(CompilerParser.NegContext ctx) { return visitChildren(ctx); }
			@Override public String visitGreaterEqual(CompilerParser.GreaterEqualContext ctx) { return visitChildren(ctx); }
			@Override public String visitEqual(CompilerParser.EqualContext ctx) { return visitChildren(ctx); }
			@Override public String visitNestedBool(CompilerParser.NestedBoolContext ctx) { return visitChildren(ctx); }
			@Override public String visitSCOr(CompilerParser.SCOrContext ctx) { return visitChildren(ctx); }
			@Override public String visitAnd(CompilerParser.AndContext ctx) { return visitChildren(ctx); }
			@Override public String visitSCAnd(CompilerParser.SCAndContext ctx) { return visitChildren(ctx); }
			@Override public String visitGreater(CompilerParser.GreaterContext ctx) { return visitChildren(ctx); }
			@Override public String visitSmaller(CompilerParser.SmallerContext ctx) { return visitChildren(ctx); }
	}
	
	// This class is used to throw the correct exception
	public class BailErrorStrategy extends DefaultErrorStrategy {
		
	    @Override
	    public void recover(Parser recognizer, RecognitionException e) {
			for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
				context.exception = e;
			}

	        throw new ParseCancellationException(e);
	    }

	    @Override
	    public Token recoverInline(Parser recognizer)
	        throws RecognitionException
	    {
			InputMismatchException e = new InputMismatchException(recognizer);
			for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
				context.exception = e;
			}

	        throw new ParseCancellationException(e);
	    }

	    @Override
	    public void sync(Parser recognizer) { }
	}
}