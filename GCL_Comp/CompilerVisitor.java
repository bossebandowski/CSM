// Generated from Compiler.g by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CompilerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CompilerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CompilerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(CompilerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDef}
	 * labeled alternative in {@link CompilerParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(CompilerParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Append}
	 * labeled alternative in {@link CompilerParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppend(CompilerParser.AppendContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoLoop}
	 * labeled alternative in {@link CompilerParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoLoop(CompilerParser.DoLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link CompilerParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(CompilerParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link CompilerParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(CompilerParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElif}
	 * labeled alternative in {@link CompilerParser#gc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElif(CompilerParser.IfElifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfThen}
	 * labeled alternative in {@link CompilerParser#gc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(CompilerParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(CompilerParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(CompilerParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Num}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(CompilerParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PowExpr}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(CompilerParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedExpr}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedExpr(CompilerParser.NestedExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProdExpr}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProdExpr(CompilerParser.ProdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UMinusExpr}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUMinusExpr(CompilerParser.UMinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusExpr}
	 * labeled alternative in {@link CompilerParser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(CompilerParser.MinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(CompilerParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(CompilerParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SmallerEqual}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmallerEqual(CompilerParser.SmallerEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(CompilerParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Unequal}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnequal(CompilerParser.UnequalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Neg}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeg(CompilerParser.NegContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterEqual}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterEqual(CompilerParser.GreaterEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equal}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(CompilerParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedBool}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedBool(CompilerParser.NestedBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SCOr}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSCOr(CompilerParser.SCOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(CompilerParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SCAnd}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSCAnd(CompilerParser.SCAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Greater}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreater(CompilerParser.GreaterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Smaller}
	 * labeled alternative in {@link CompilerParser#b}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmaller(CompilerParser.SmallerContext ctx);
}