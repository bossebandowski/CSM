grammar Compiler ;

/* Lexical rules */

IF		: 'if ' ;
FI		: ' fi' ;
DO		: 'do ' ;
OD		: ' od' ;
SKP		: 'skip' ;
SEMI		: ';' ;
VARDEF	: ':=' ;



THEN		: '->' ;
ELIF		: '[]' ;

AND		: '&' ;
SCAND		: '&&' ;
OR		: '|' ;
SCOR		: '||' ;

TRUE		: 'true' ;
FALSE		: 'false' ;

POW		: '^' ;
MULT		: '*' ;
PLUS		: '+' ;
MIN		: '-' ;

UNEQ		: '!=' ;
NOT		: '!' ;
GT		: '>' ;
GE		: '>=' ;
LT		: '<' ;
LE		: '<=' ;
EQ		: '=' ;

LPAREN	: '(' ;
RPAREN	: ')' ;

// Decimal Numbers

NUM		: [0-9]+('.'[0-9]+)? ;

// Variable Names

VAR		: [a-zA-Z][a-zA-Z]* ;

// White Spaces

WS		: [ \r\t\n]+ -> skip ;

/* Grammar rules */

start		: c EOF ;

c     :			lhs = VAR VARDEF rhs = a		#VarDef
      |			SKP						#Skip
      |			lhs = c SEMI rhs = c			#Append
      |			IF exp = gc FI				#If
      |			DO exp = gc OD				#DoLoop
      ;

gc    :			lhs = gc ELIF rhs = gc		#IfElif
      |			lhs = b THEN rhs = c			#IfThen
      ;

a     :			exp = NUM					#Num
      |			exp = VAR					#Var
      | <assoc=right>	lhs = a POW rhs = a			#PowExpr
      |			lhs = a MULT rhs = a			#ProdExpr
      |			lhs = a PLUS rhs = a			#PlusExpr
      |			lhs = a MIN rhs = a			#MinusExpr
      |			LPAREN exp = a RPAREN			#NestedExpr
      | 			MIN exp = a				#UMinusExpr
      ;

b     :			exp = TRUE					#True
      |			exp = FALSE				#False
      |			NOT exp = b				#Neg
      |			lhs = b AND rhs = b			#And
      |			lhs = b OR rhs = b			#Or
      |			lhs = b SCAND rhs = b			#SCAnd
      |			lhs = b SCOR rhs = b			#SCOr
      |			lhs = a EQ rhs = a			#Equal
      |			lhs = a UNEQ rhs = a			#Unequal
      |			lhs = a GT rhs = a			#Greater
      |			lhs = a GE rhs = a			#GreaterEqual
      |			lhs = a LT rhs = a			#Smaller
      |			lhs = a LE rhs = a				#SmallerEqual
      |			LPAREN exp = b RPAREN			#NestedBool
      ;