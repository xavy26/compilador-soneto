package analizadorSintactico;
import java_cup.runtime.Symbol;
%%
%public
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z] | [á|é|í|ó|ú|ñ|Ñ]
D=[0-9]+
espacio=[\s*,\t,\r,\n]+
%{
    private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline, yycolumn, value);

    }
    private Symbol symbol  (int type){
        return new Symbol (type, yyline, yycolumn);

    }
%}
%%
/*Espacio en blanco*/
{espacio} {/*Ignore*/}

/*Comentarios*/
("//"(.)*) {/*Ignore*/}

/*Inicio de poema*/
("[") {TablaSimbolos.addArrayList("Inicio poema");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Poema_i,yychar,yyline,yytext());}


/*Fin de poema*/
("]") {TablaSimbolos.addArrayList("Fin poema");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1);return new Symbol (sym.Poema_f,yychar,yyline,yytext());}

/*Inicio de verso*/
("{") {TablaSimbolos.addArrayList("Inicio verso");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Verso_i,yychar,yyline,yytext());}

/*Fin de verso*/
("}") {TablaSimbolos.addArrayList("Fin verso");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Verso_f,yychar,yyline,yytext());}

/*Inicio de parrafo*/
("(") {TablaSimbolos.addArrayList("Inicio parrafo");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Parrafo_i,yychar,yyline,yytext());}

/*Fin de parrafo*/
(")") {TablaSimbolos.addArrayList("Fin parrafo");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Parrafo_f,yychar,yyline,yytext());}

/*Inicio exclamacion*/
("¡") {TablaSimbolos.addArrayList("Exclamación");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Exclamacion_i,yychar,yyline,yytext());}

/*Fin exclamacion*/
("!") {TablaSimbolos.addArrayList("Exclamación");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Exclamacion_f,yychar,yyline,yytext());}

/*Inicio interrogacion*/
("¿") {TablaSimbolos.addArrayList("Interrogación");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Interrogacion_i,yychar,yyline,yytext());}

/*Fin interrogacion*/
("?") {TablaSimbolos.addArrayList("Interrogación");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Interrogacion_f,yychar,yyline,yytext());}

/*Punto*/
(".") {TablaSimbolos.addArrayList("Punto ");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Punto,yychar,yyline,yytext());}

/*Coma*/
(",") {TablaSimbolos.addArrayList("Coma ");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Coma,yychar,yyline,yytext());}

/*Punto y coma*/
(";") {TablaSimbolos.addArrayList("Punto y coma ");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Punto_coma,yychar,yyline,yytext());}

/*Cadena de texto*/
{L}+ {TablaSimbolos.addArrayList("Texto ");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Cadena_texto,yychar,yyline,yytext());}

/*numero*/
{D}+ {TablaSimbolos.addArrayList("Número");  TablaSimbolos.addArrayList2(yytext()); TablaSimbolos.addArrayList3(yyline+1); TablaSimbolos.addArrayList4(yycolumn+1); return new Symbol (sym.Numero,yychar,yyline,yytext());}

/*error de analisis*/
 . {return new Symbol (sym.ERROR,yychar,yyline,yytext());}