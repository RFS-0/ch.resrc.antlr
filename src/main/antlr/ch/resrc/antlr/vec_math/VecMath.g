grammar VecMath;

@header {
package ch.resrc.antlr.maths;
}

statlist: stat+;

stat:
ID '=' expr
| 'print' expr;

expr:
multExpr ('+' multExpr)*;
multExpr: primary (('*'|'.') primary)*;

primary:
INT
| ID
| '[' expr (',' expr)* ']';

INT: '0'..'9'+;
ID: 'a-z' | 'A-Z';