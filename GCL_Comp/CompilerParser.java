// Generated from Compiler.g by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CompilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, FI=2, DO=3, OD=4, SKP=5, SEMI=6, VARDEF=7, THEN=8, ELIF=9, AND=10, 
		SCAND=11, OR=12, SCOR=13, TRUE=14, FALSE=15, POW=16, MULT=17, PLUS=18, 
		MIN=19, UNEQ=20, NOT=21, GT=22, GE=23, LT=24, LE=25, EQ=26, LPAREN=27, 
		RPAREN=28, NUM=29, VAR=30, WS=31;
	public static final int
		RULE_start = 0, RULE_c = 1, RULE_gc = 2, RULE_a = 3, RULE_b = 4;
	public static final String[] ruleNames = {
		"start", "c", "gc", "a", "b"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if '", "' fi'", "'do '", "' od'", "'skip'", "';'", "':='", "'->'", 
		"'[]'", "'&'", "'&&'", "'|'", "'||'", "'true'", "'false'", "'^'", "'*'", 
		"'+'", "'-'", "'!='", "'!'", "'>'", "'>='", "'<'", "'<='", "'='", "'('", 
		"')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "IF", "FI", "DO", "OD", "SKP", "SEMI", "VARDEF", "THEN", "ELIF", 
		"AND", "SCAND", "OR", "SCOR", "TRUE", "FALSE", "POW", "MULT", "PLUS", 
		"MIN", "UNEQ", "NOT", "GT", "GE", "LT", "LE", "EQ", "LPAREN", "RPAREN", 
		"NUM", "VAR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Compiler.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CompilerParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			c(0);
			setState(11);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CContext extends ParserRuleContext {
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
	 
		public CContext() { }
		public void copyFrom(CContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDefContext extends CContext {
		public Token lhs;
		public AContext rhs;
		public TerminalNode VARDEF() { return getToken(CompilerParser.VARDEF, 0); }
		public TerminalNode VAR() { return getToken(CompilerParser.VAR, 0); }
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public VarDefContext(CContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AppendContext extends CContext {
		public CContext lhs;
		public CContext rhs;
		public TerminalNode SEMI() { return getToken(CompilerParser.SEMI, 0); }
		public List<CContext> c() {
			return getRuleContexts(CContext.class);
		}
		public CContext c(int i) {
			return getRuleContext(CContext.class,i);
		}
		public AppendContext(CContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitAppend(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoLoopContext extends CContext {
		public GcContext exp;
		public TerminalNode DO() { return getToken(CompilerParser.DO, 0); }
		public TerminalNode OD() { return getToken(CompilerParser.OD, 0); }
		public GcContext gc() {
			return getRuleContext(GcContext.class,0);
		}
		public DoLoopContext(CContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitDoLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipContext extends CContext {
		public TerminalNode SKP() { return getToken(CompilerParser.SKP, 0); }
		public SkipContext(CContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends CContext {
		public GcContext exp;
		public TerminalNode IF() { return getToken(CompilerParser.IF, 0); }
		public TerminalNode FI() { return getToken(CompilerParser.FI, 0); }
		public GcContext gc() {
			return getRuleContext(GcContext.class,0);
		}
		public IfContext(CContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CContext c() throws RecognitionException {
		return c(0);
	}

	private CContext c(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CContext _localctx = new CContext(_ctx, _parentState);
		CContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_c, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				_localctx = new VarDefContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(14);
				((VarDefContext)_localctx).lhs = match(VAR);
				setState(15);
				match(VARDEF);
				setState(16);
				((VarDefContext)_localctx).rhs = a(0);
				}
				break;
			case SKP:
				{
				_localctx = new SkipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(SKP);
				}
				break;
			case IF:
				{
				_localctx = new IfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(IF);
				setState(19);
				((IfContext)_localctx).exp = gc(0);
				setState(20);
				match(FI);
				}
				break;
			case DO:
				{
				_localctx = new DoLoopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(DO);
				setState(23);
				((DoLoopContext)_localctx).exp = gc(0);
				setState(24);
				match(OD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AppendContext(new CContext(_parentctx, _parentState));
					((AppendContext)_localctx).lhs = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_c);
					setState(28);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(29);
					match(SEMI);
					setState(30);
					((AppendContext)_localctx).rhs = c(4);
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GcContext extends ParserRuleContext {
		public GcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gc; }
	 
		public GcContext() { }
		public void copyFrom(GcContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfElifContext extends GcContext {
		public GcContext lhs;
		public GcContext rhs;
		public TerminalNode ELIF() { return getToken(CompilerParser.ELIF, 0); }
		public List<GcContext> gc() {
			return getRuleContexts(GcContext.class);
		}
		public GcContext gc(int i) {
			return getRuleContext(GcContext.class,i);
		}
		public IfElifContext(GcContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitIfElif(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfThenContext extends GcContext {
		public BContext lhs;
		public CContext rhs;
		public TerminalNode THEN() { return getToken(CompilerParser.THEN, 0); }
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public IfThenContext(GcContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitIfThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GcContext gc() throws RecognitionException {
		return gc(0);
	}

	private GcContext gc(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GcContext _localctx = new GcContext(_ctx, _parentState);
		GcContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_gc, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new IfThenContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(37);
			((IfThenContext)_localctx).lhs = b(0);
			setState(38);
			match(THEN);
			setState(39);
			((IfThenContext)_localctx).rhs = c(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IfElifContext(new GcContext(_parentctx, _parentState));
					((IfElifContext)_localctx).lhs = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_gc);
					setState(41);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(42);
					match(ELIF);
					setState(43);
					((IfElifContext)_localctx).rhs = gc(3);
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AContext extends ParserRuleContext {
		public AContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_a; }
	 
		public AContext() { }
		public void copyFrom(AContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusExprContext extends AContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode PLUS() { return getToken(CompilerParser.PLUS, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public PlusExprContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends AContext {
		public Token exp;
		public TerminalNode VAR() { return getToken(CompilerParser.VAR, 0); }
		public VarContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumContext extends AContext {
		public Token exp;
		public TerminalNode NUM() { return getToken(CompilerParser.NUM, 0); }
		public NumContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends AContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode POW() { return getToken(CompilerParser.POW, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public PowExprContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedExprContext extends AContext {
		public AContext exp;
		public TerminalNode LPAREN() { return getToken(CompilerParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CompilerParser.RPAREN, 0); }
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public NestedExprContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitNestedExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ProdExprContext extends AContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode MULT() { return getToken(CompilerParser.MULT, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public ProdExprContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitProdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UMinusExprContext extends AContext {
		public AContext exp;
		public TerminalNode MIN() { return getToken(CompilerParser.MIN, 0); }
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public UMinusExprContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitUMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusExprContext extends AContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode MIN() { return getToken(CompilerParser.MIN, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public MinusExprContext(AContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitMinusExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AContext a() throws RecognitionException {
		return a(0);
	}

	private AContext a(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AContext _localctx = new AContext(_ctx, _parentState);
		AContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_a, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				{
				_localctx = new NumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(50);
				((NumContext)_localctx).exp = match(NUM);
				}
				break;
			case VAR:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51);
				((VarContext)_localctx).exp = match(VAR);
				}
				break;
			case LPAREN:
				{
				_localctx = new NestedExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(LPAREN);
				setState(53);
				((NestedExprContext)_localctx).exp = a(0);
				setState(54);
				match(RPAREN);
				}
				break;
			case MIN:
				{
				_localctx = new UMinusExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(56);
				match(MIN);
				setState(57);
				((UMinusExprContext)_localctx).exp = a(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new AContext(_parentctx, _parentState));
						((PowExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(60);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(61);
						match(POW);
						setState(62);
						((PowExprContext)_localctx).rhs = a(6);
						}
						break;
					case 2:
						{
						_localctx = new ProdExprContext(new AContext(_parentctx, _parentState));
						((ProdExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(63);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(64);
						match(MULT);
						setState(65);
						((ProdExprContext)_localctx).rhs = a(6);
						}
						break;
					case 3:
						{
						_localctx = new PlusExprContext(new AContext(_parentctx, _parentState));
						((PlusExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(66);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(67);
						match(PLUS);
						setState(68);
						((PlusExprContext)_localctx).rhs = a(5);
						}
						break;
					case 4:
						{
						_localctx = new MinusExprContext(new AContext(_parentctx, _parentState));
						((MinusExprContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_a);
						setState(69);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(70);
						match(MIN);
						setState(71);
						((MinusExprContext)_localctx).rhs = a(4);
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BContext extends ParserRuleContext {
		public BContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_b; }
	 
		public BContext() { }
		public void copyFrom(BContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OrContext extends BContext {
		public BContext lhs;
		public BContext rhs;
		public TerminalNode OR() { return getToken(CompilerParser.OR, 0); }
		public List<BContext> b() {
			return getRuleContexts(BContext.class);
		}
		public BContext b(int i) {
			return getRuleContext(BContext.class,i);
		}
		public OrContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueContext extends BContext {
		public Token exp;
		public TerminalNode TRUE() { return getToken(CompilerParser.TRUE, 0); }
		public TrueContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerEqualContext extends BContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode LE() { return getToken(CompilerParser.LE, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public SmallerEqualContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitSmallerEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseContext extends BContext {
		public Token exp;
		public TerminalNode FALSE() { return getToken(CompilerParser.FALSE, 0); }
		public FalseContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnequalContext extends BContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode UNEQ() { return getToken(CompilerParser.UNEQ, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public UnequalContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitUnequal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegContext extends BContext {
		public BContext exp;
		public TerminalNode NOT() { return getToken(CompilerParser.NOT, 0); }
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public NegContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterEqualContext extends BContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode GE() { return getToken(CompilerParser.GE, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public GreaterEqualContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitGreaterEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends BContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode EQ() { return getToken(CompilerParser.EQ, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public EqualContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NestedBoolContext extends BContext {
		public BContext exp;
		public TerminalNode LPAREN() { return getToken(CompilerParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CompilerParser.RPAREN, 0); }
		public BContext b() {
			return getRuleContext(BContext.class,0);
		}
		public NestedBoolContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitNestedBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SCOrContext extends BContext {
		public BContext lhs;
		public BContext rhs;
		public TerminalNode SCOR() { return getToken(CompilerParser.SCOR, 0); }
		public List<BContext> b() {
			return getRuleContexts(BContext.class);
		}
		public BContext b(int i) {
			return getRuleContext(BContext.class,i);
		}
		public SCOrContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitSCOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndContext extends BContext {
		public BContext lhs;
		public BContext rhs;
		public TerminalNode AND() { return getToken(CompilerParser.AND, 0); }
		public List<BContext> b() {
			return getRuleContexts(BContext.class);
		}
		public BContext b(int i) {
			return getRuleContext(BContext.class,i);
		}
		public AndContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SCAndContext extends BContext {
		public BContext lhs;
		public BContext rhs;
		public TerminalNode SCAND() { return getToken(CompilerParser.SCAND, 0); }
		public List<BContext> b() {
			return getRuleContexts(BContext.class);
		}
		public BContext b(int i) {
			return getRuleContext(BContext.class,i);
		}
		public SCAndContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitSCAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterContext extends BContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode GT() { return getToken(CompilerParser.GT, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public GreaterContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitGreater(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallerContext extends BContext {
		public AContext lhs;
		public AContext rhs;
		public TerminalNode LT() { return getToken(CompilerParser.LT, 0); }
		public List<AContext> a() {
			return getRuleContexts(AContext.class);
		}
		public AContext a(int i) {
			return getRuleContext(AContext.class,i);
		}
		public SmallerContext(BContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompilerVisitor ) return ((CompilerVisitor<? extends T>)visitor).visitSmaller(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BContext b() throws RecognitionException {
		return b(0);
	}

	private BContext b(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BContext _localctx = new BContext(_ctx, _parentState);
		BContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_b, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new TrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(78);
				((TrueContext)_localctx).exp = match(TRUE);
				}
				break;
			case 2:
				{
				_localctx = new FalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				((FalseContext)_localctx).exp = match(FALSE);
				}
				break;
			case 3:
				{
				_localctx = new NegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(NOT);
				setState(81);
				((NegContext)_localctx).exp = b(12);
				}
				break;
			case 4:
				{
				_localctx = new EqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				((EqualContext)_localctx).lhs = a(0);
				setState(83);
				match(EQ);
				setState(84);
				((EqualContext)_localctx).rhs = a(0);
				}
				break;
			case 5:
				{
				_localctx = new UnequalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				((UnequalContext)_localctx).lhs = a(0);
				setState(87);
				match(UNEQ);
				setState(88);
				((UnequalContext)_localctx).rhs = a(0);
				}
				break;
			case 6:
				{
				_localctx = new GreaterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				((GreaterContext)_localctx).lhs = a(0);
				setState(91);
				match(GT);
				setState(92);
				((GreaterContext)_localctx).rhs = a(0);
				}
				break;
			case 7:
				{
				_localctx = new GreaterEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				((GreaterEqualContext)_localctx).lhs = a(0);
				setState(95);
				match(GE);
				setState(96);
				((GreaterEqualContext)_localctx).rhs = a(0);
				}
				break;
			case 8:
				{
				_localctx = new SmallerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				((SmallerContext)_localctx).lhs = a(0);
				setState(99);
				match(LT);
				setState(100);
				((SmallerContext)_localctx).rhs = a(0);
				}
				break;
			case 9:
				{
				_localctx = new SmallerEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				((SmallerEqualContext)_localctx).lhs = a(0);
				setState(103);
				match(LE);
				setState(104);
				((SmallerEqualContext)_localctx).rhs = a(0);
				}
				break;
			case 10:
				{
				_localctx = new NestedBoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(LPAREN);
				setState(107);
				((NestedBoolContext)_localctx).exp = b(0);
				setState(108);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(126);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(124);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new BContext(_parentctx, _parentState));
						((AndContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(112);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(113);
						match(AND);
						setState(114);
						((AndContext)_localctx).rhs = b(12);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new BContext(_parentctx, _parentState));
						((OrContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(115);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(116);
						match(OR);
						setState(117);
						((OrContext)_localctx).rhs = b(11);
						}
						break;
					case 3:
						{
						_localctx = new SCAndContext(new BContext(_parentctx, _parentState));
						((SCAndContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(118);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(119);
						match(SCAND);
						setState(120);
						((SCAndContext)_localctx).rhs = b(10);
						}
						break;
					case 4:
						{
						_localctx = new SCOrContext(new BContext(_parentctx, _parentState));
						((SCOrContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_b);
						setState(121);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(122);
						match(SCOR);
						setState(123);
						((SCOrContext)_localctx).rhs = b(9);
						}
						break;
					}
					} 
				}
				setState(128);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return c_sempred((CContext)_localctx, predIndex);
		case 2:
			return gc_sempred((GcContext)_localctx, predIndex);
		case 3:
			return a_sempred((AContext)_localctx, predIndex);
		case 4:
			return b_sempred((BContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean c_sempred(CContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean gc_sempred(GcContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean a_sempred(AContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean b_sempred(BContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u0084\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4/\n\4\f\4\16\4\62\13\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6q\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6\177\n\6\f\6\16\6\u0082\13\6\3\6\2\6\4\6\b\n\7\2"+
		"\4\6\b\n\2\2\2\u0097\2\f\3\2\2\2\4\34\3\2\2\2\6&\3\2\2\2\b<\3\2\2\2\n"+
		"p\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\20\b\3\1\2\20\21\7"+
		" \2\2\21\22\7\t\2\2\22\35\5\b\5\2\23\35\7\7\2\2\24\25\7\3\2\2\25\26\5"+
		"\6\4\2\26\27\7\4\2\2\27\35\3\2\2\2\30\31\7\5\2\2\31\32\5\6\4\2\32\33\7"+
		"\6\2\2\33\35\3\2\2\2\34\17\3\2\2\2\34\23\3\2\2\2\34\24\3\2\2\2\34\30\3"+
		"\2\2\2\35#\3\2\2\2\36\37\f\5\2\2\37 \7\b\2\2 \"\5\4\3\6!\36\3\2\2\2\""+
		"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%#\3\2\2\2&\'\b\4\1\2\'(\5\n\6"+
		"\2()\7\n\2\2)*\5\4\3\2*\60\3\2\2\2+,\f\4\2\2,-\7\13\2\2-/\5\6\4\5.+\3"+
		"\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\7\3\2\2\2\62\60\3\2\2"+
		"\2\63\64\b\5\1\2\64=\7\37\2\2\65=\7 \2\2\66\67\7\35\2\2\678\5\b\5\289"+
		"\7\36\2\29=\3\2\2\2:;\7\25\2\2;=\5\b\5\3<\63\3\2\2\2<\65\3\2\2\2<\66\3"+
		"\2\2\2<:\3\2\2\2=L\3\2\2\2>?\f\b\2\2?@\7\22\2\2@K\5\b\5\bAB\f\7\2\2BC"+
		"\7\23\2\2CK\5\b\5\bDE\f\6\2\2EF\7\24\2\2FK\5\b\5\7GH\f\5\2\2HI\7\25\2"+
		"\2IK\5\b\5\6J>\3\2\2\2JA\3\2\2\2JD\3\2\2\2JG\3\2\2\2KN\3\2\2\2LJ\3\2\2"+
		"\2LM\3\2\2\2M\t\3\2\2\2NL\3\2\2\2OP\b\6\1\2Pq\7\20\2\2Qq\7\21\2\2RS\7"+
		"\27\2\2Sq\5\n\6\16TU\5\b\5\2UV\7\34\2\2VW\5\b\5\2Wq\3\2\2\2XY\5\b\5\2"+
		"YZ\7\26\2\2Z[\5\b\5\2[q\3\2\2\2\\]\5\b\5\2]^\7\30\2\2^_\5\b\5\2_q\3\2"+
		"\2\2`a\5\b\5\2ab\7\31\2\2bc\5\b\5\2cq\3\2\2\2de\5\b\5\2ef\7\32\2\2fg\5"+
		"\b\5\2gq\3\2\2\2hi\5\b\5\2ij\7\33\2\2jk\5\b\5\2kq\3\2\2\2lm\7\35\2\2m"+
		"n\5\n\6\2no\7\36\2\2oq\3\2\2\2pO\3\2\2\2pQ\3\2\2\2pR\3\2\2\2pT\3\2\2\2"+
		"pX\3\2\2\2p\\\3\2\2\2p`\3\2\2\2pd\3\2\2\2ph\3\2\2\2pl\3\2\2\2q\u0080\3"+
		"\2\2\2rs\f\r\2\2st\7\f\2\2t\177\5\n\6\16uv\f\f\2\2vw\7\16\2\2w\177\5\n"+
		"\6\rxy\f\13\2\2yz\7\r\2\2z\177\5\n\6\f{|\f\n\2\2|}\7\17\2\2}\177\5\n\6"+
		"\13~r\3\2\2\2~u\3\2\2\2~x\3\2\2\2~{\3\2\2\2\177\u0082\3\2\2\2\u0080~\3"+
		"\2\2\2\u0080\u0081\3\2\2\2\u0081\13\3\2\2\2\u0082\u0080\3\2\2\2\13\34"+
		"#\60<JLp~\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}