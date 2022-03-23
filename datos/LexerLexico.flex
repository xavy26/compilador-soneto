package analizadorSintactico;
import analizadorSintactico.Tokens;

%%
%public
%class LexerLexico
%type Tokens

L=[a-zA-Z] | [á|é|í|ó|ú|ñ|Ñ]
D=[0-9]+
espacio=[\s*,\t,\r,\n]+

%{
    public String lexema;
%}
%%


/*Espacio en blanco*/
{espacio} {/*Ignore*/}

/*Comentarios*/
("//"(.)*) {/*Ignore*/}


/*Inicio de poema*/
"[" {lexema=yytext(); return Tokens.Poema_i;}

/*Fin de poema*/
"]" {lexema=yytext(); return Tokens.Poema_f;}

/*Inicio de verso*/
"{" {lexema=yytext(); return Tokens.Verso_i;}

/*Fin de verso*/
"}" {lexema=yytext(); return Tokens.Verso_f;}

/*Inicio de parrafo*/
"(" {lexema=yytext(); return Tokens.Parrafo_i;}

/*Fin de parrafo*/
")" {lexema=yytext(); return Tokens.Parrafo_f;}

/*Inicio exclamacion*/
"¡" {lexema=yytext(); return Tokens.Exclamacion_i;}

/*Fin exclamacion*/
"!" {lexema=yytext(); return Tokens.Exclamacion_f;}

/*Inicio interrogacion*/
"¿" {lexema=yytext(); return Tokens.Interrogacion_i;}

/*Fin interrogacion*/
"?" {lexema=yytext(); return Tokens.Interrogacion_f;}

/*Punto*/
"." {lexema=yytext(); return Tokens.Punto;}

/*Coma*/
"," {lexema=yytext(); return Tokens.Coma;}

/*Punto y coma*/
";" {lexema=yytext(); return Tokens.Punto_coma;}


/*Cadena de texto*/
{L}+ {lexema=yytext(); return Tokens.Cadena_texto;}

/*numero*/
{D}+ {lexema=yytext(); return Tokens.Numero;}


 . {lexema=yytext(); return Tokens.ERROR;}

