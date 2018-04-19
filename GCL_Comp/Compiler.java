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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Compiler {
	
	Output myString = new Output();
	PG aPG = new PG ();

	public static void main(String args[]) throws Exception  {

		try {
			// Instantiate a new class member
			Compiler c = new Compiler();
			c.run();
			System.out.println("ok");
		}
		catch (Exception  e) {
			System.out.println("ko");
			e.printStackTrace ();
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


		aPG.body = check.visit(parser.start());
		System.out.println(aPG.body);
		System.out.println("--------------");
		
		aPG.toEdge(aPG.body);
		
		for (Edge e : aPG.edges) {
			System.out.println(e);
		}
		
		/*for (int i = 0; i < 5; i++) {
			aPG.removeDuplicateEdges();
			aPG.removeNullEdges();
		}
		
		for (Edge e : aPG.edges) {
			System.out.println(e);
		}*/
		
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
	
	public class PG {
		String header = "digraph program_graph {rankdir=LR;\n" + 
				"node [shape = circle]; q▷;\n" + 
				"node [shape = doublecircle]; q◀; \n" + 
				"node [shape = circle]";
		PG body;
		int nodeCount = 0;
		Node firstNode;
		Node endNode;
		PG midextend;
		PG right;
		PG left;
		Label label;
		Node startNode;
		Node targetNode;
		boolean isNull;
		LinkedList<Node> ifNodeStash = new LinkedList<Node>();
		ArrayList <Edge> edges = new ArrayList <Edge>();
		
		public void toEdge (PG body) {
			if (body.label.name == "null" && !body.midextend.isNull) {
				aPG.edges.add(new Edge(body.midextend.label, body.startNode, body.midextend.targetNode, new Edge(), new Edge(), new Edge()));
				body.midextend.toEdge(body.midextend);
				aPG.edges.add(new Edge(body.midextend.label, body.midextend.targetNode, body.targetNode, new Edge(), new Edge(), new Edge()));
			} else if (body.label.name == "null" && !body.left.isNull && !body.right.isNull) {
				body.left.toEdge(body.left);
				body.right.toEdge(body.right);
			}
			else {
				aPG.edges.add(new Edge(body.label, body.startNode, body.targetNode, new Edge(), new Edge(), new Edge()));
			}
		}
		
		public void removeNullEdges () {
			for (int i = 0; i < this.edges.size(); i++) {
				if (this.edges.get(i).label.name == "null") {
					if (i == 0) {
						this.edges.get(i+1).startNode = this.edges.get(i).startNode;
						this.edges.remove(i);
					} else {
						this.edges.get(i-1).targetNode = this.edges.get(i).startNode;
						this.edges.remove(i);
					}
				}
			}
		}

		public void removeDuplicateEdges () {
			for (int i = 0; i < this.edges.size() - 1; i++) {
				if (this.edges.get(i).label.name == this.edges.get(i+1).label.name) {
					this.edges.get(i).targetNode = this.edges.get(i+1).targetNode;
					this.edges.remove(i+1);
				}
			}
		}
	
	}
	
	
	public class Edge extends PG {
		
		public Edge (Label label, Node startNode, Node targetNode, PG midextend, PG left, PG right) {
			this.label = label;
			this.startNode = startNode;
			this.targetNode = targetNode;
			this.midextend = midextend;
			this.right = right;
			this.left = left;
			this.isNull = false;
		}
		
		public Edge () {
			this.isNull = true;
		}
		
		public void printEdge () {
			System.out.println(this.label + ", " + this.startNode + ", " + this.targetNode);
		}
		
		public String toString() {
			if (this.isNull) {
				return "";
			} else {
				return Integer.toString(this.startNode.number) + " -> " + Integer.toString(this.targetNode.number) + ", [label = " + this.label.name + "]\n" + this.midextend.toString() + this.left.toString() + this.right.toString();
			}
		}
	}
	
	public class Label extends PG {
		String name;
		
		public Label (String name) {
			this.name = name;
		}
	}
	
	public class Node extends PG {
		int number;
		
		public Node (int i) {
			this.number = i;
		}
	}


	public class Checkup extends CompilerBaseVisitor<PG> {
		
			@Override public PG visitStart(CompilerParser.StartContext ctx) {
				System.out.println("Start");
				aPG.firstNode = new Node(-1);
				aPG.endNode = new Node(-2);
				Label label = new Label("null");
				return new Edge(label, aPG.firstNode, aPG.endNode, visit(ctx.exp), new Edge(), new Edge()); }
			@Override public PG visitVarDef(CompilerParser.VarDefContext ctx) {
				System.out.println("vardef");
				Label label = new Label(String.valueOf(ctx.getText()));
				Node startNode = new Node(aPG.nodeCount);
				aPG.nodeCount++;
				Node targetNode = new Node(aPG.nodeCount);
				return new Edge(label, startNode, targetNode, new Edge(), new Edge(), new Edge()); }
			@Override public PG visitAppend(CompilerParser.AppendContext ctx) {
				System.out.println("append");
				Label label = new Label("null");
				Node startNode = new Node(aPG.nodeCount);
				Node targetNode = new Node(aPG.nodeCount);
				return new Edge(label, startNode, targetNode, new Edge(), visit(ctx.lhs), visit(ctx.rhs)); }
			@Override public PG visitDoLoop(CompilerParser.DoLoopContext ctx) {
				System.out.println("do");
				aPG.ifNodeStash.push(new Node(aPG.nodeCount));
				Label label = new Label("null");
				Node startNode = new Node(aPG.nodeCount);
				return new Edge(label, startNode, startNode, visit(ctx.exp), new Edge(), new Edge()); }
			@Override public PG visitSkip(CompilerParser.SkipContext ctx) {
				System.out.println("skip");
				Label label = new Label("skip");
				Node startNode = new Node(aPG.nodeCount);
				aPG.nodeCount++;
				Node targetNode = new Node(aPG.nodeCount);
				return new Edge(label, startNode, targetNode, new Edge(), new Edge(), new Edge()); }
			@Override public PG visitIf(CompilerParser.IfContext ctx) {
				System.out.println("if...fi");
				aPG.ifNodeStash.push(new Node(aPG.nodeCount));
				return visit(ctx.exp); }
			@Override public PG visitIfElif(CompilerParser.IfElifContext ctx) {
				System.out.println("ifElif");
				Label label = new Label("null");
				aPG.ifNodeStash.push(new Node(aPG.nodeCount));
				Node startNode = new Node(aPG.nodeCount);
				Node targetNode = new Node(aPG.nodeCount);
				return new Edge(label, startNode, targetNode, new Edge(), visit(ctx.lhs), visit(ctx.rhs)); }
			@Override public PG visitIfThen(CompilerParser.IfThenContext ctx) {
				System.out.println("ifThen");
				Label label = new Label(String.valueOf(ctx.lhs.getText()));
				Node startNode = aPG.ifNodeStash.pop();
				aPG.nodeCount++;
				Node targetNode = new Node(aPG.nodeCount);
				return new Edge(label, startNode, aPG.endNode, visit(ctx.rhs), new Edge(), new Edge()); }
			@Override public PG visitPlusExpr(CompilerParser.PlusExprContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitVar(CompilerParser.VarContext ctx) { 
				return visitChildren(ctx); }
			@Override public PG visitNum(CompilerParser.NumContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitPowExpr(CompilerParser.PowExprContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitNestedExpr(CompilerParser.NestedExprContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitProdExpr(CompilerParser.ProdExprContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitUMinusExpr(CompilerParser.UMinusExprContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitMinusExpr(CompilerParser.MinusExprContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitOr(CompilerParser.OrContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitTrue(CompilerParser.TrueContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitSmallerEqual(CompilerParser.SmallerEqualContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitFalse(CompilerParser.FalseContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitUnequal(CompilerParser.UnequalContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitNeg(CompilerParser.NegContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitGreaterEqual(CompilerParser.GreaterEqualContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitEqual(CompilerParser.EqualContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitNestedBool(CompilerParser.NestedBoolContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitSCOr(CompilerParser.SCOrContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitAnd(CompilerParser.AndContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitSCAnd(CompilerParser.SCAndContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitGreater(CompilerParser.GreaterContext ctx) {
				return visitChildren(ctx); }
			@Override public PG visitSmaller(CompilerParser.SmallerContext ctx) {
				return visitChildren(ctx); }
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