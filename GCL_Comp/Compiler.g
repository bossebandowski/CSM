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

gc    :			lhs = b THEN rhs = c			#IfThen
      |			lhs = gc ELIF rhs = gc		#IfElif
      ;

a     :			exp = NUM					#Num
      |			exp = VAR					#Var
      |			lhs = a PLUS rhs = a			#PlusExpr
      |			lhs = a MIN rhs = a			#MinusExpr
      |			lhs = a MULT rhs = a			#ProdExpr
      | <assoc=right>	lhs = a POW rhs = a			#PowExpr
      |			LPAREN exp = a RPAREN			#NestedExpr
      | 			MIN exp = a				#UMinusExpr
      ;

b     :			TRUE						#True
      |			FALSE						#False
      |			lhs = b AND rhs = b			#And
      |			lhs = b OR rhs = b			#Or
      |			lhs = b SCAND rhs = b			#SCAnd
      |			lhs = b SCOR rhs = b			#SCOr
      |			NOT exp = b				#Neg
      |			lhs = a EQ rhs = a			#Equal
      |			lhs = a UNEQ rhs = a			#Unequal
      |			lhs = a GT rhs = a			#Greater
      |			lhs = a GE rhs = a			#GreaterEqual
      |			lhs = a LT rhs = a			#Smaller
      |			lhs = a LE rhs = a				#SmallerEqual
      |			LPAREN exp = b RPAREN			#NestedBool
      ;