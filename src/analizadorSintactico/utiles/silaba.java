/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico.utiles;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author byron
 */
public class silaba {
    


static public int SyllableCount(String s) {
    int count = 0;
    s = s.toLowerCase(); 
 
    for (int i = 0; i < s.length(); i++) { // traversing till length of string
        if (s.charAt(i) == '\"' || s.charAt(i) == '\'' || s.charAt(i) == '-' || s.charAt(i) == ',' || s.charAt(i) == ')' || s.charAt(i) == '(') {
            // si en algún punto encontramos una expresión de este tipo, subencadenamos la cadena desde el principio hasta ese punto y más.
            s = s.substring(0,i) + s.substring(i+1, s.length());
        }
    }

    boolean isPrevVowel = false;
 
    for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j)==' ' && j<s.length()-1) {
            if (isVowel(s.charAt(j-1)) && isVowel(s.charAt(j+1))) {//yo
                count--;
            }
            if (isVowel(s.charAt(j-1)) && s.charAt(j+1)=='h') {  // a h
                count--;
            }
            if (s.charAt(j-1)=='y' && s.charAt(j+1)=='y') { //y yo
                count++;
            }  
        }
 
        if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
            if ((esVocalTilde(s.charAt(j))) && isVowel(s.charAt(j+1))) { //geo-me-trí-a
                count++;
            }            
            if ((s.charAt(j)=='y') && isVowel(s.charAt(j+1))) { //yo ya 
                count++;
            }    
            if ((s.charAt(j) == 'e') && (j == s.length()-1)) { //termina en E ultima palabara
                    count++;
            }
            if (isVowel(s.charAt(j)) && !((s.charAt(j) == 'e') && (j == s.length()-1))) {
                if (isPrevVowel == false ) { //primera silaba
                    if (s.charAt(j)=='y' && isVowel(s.charAt(j+1))) { //comienza por Y primera silaba
                        count--;
                    } 
                    count++;
                    isPrevVowel = true;
                }
            } else {
                isPrevVowel = false;
            }
        } else {
            count++;
            break;
        }
    }
    return count;
}

static public boolean esVocalTilde(char c) {
    if ( c == 'á' || c == 'é'  || c == 'í'  || c == 'ó'  || c == 'ú') {
        return true;
    } else {
        return false;
    }
}

static public boolean isVowel(char c) {
    if (c == 'a' || c == 'á' || c == 'e' || c == 'é' || c == 'i' || c == 'í' || c == 'o' || c == 'ó' || c == 'u' || c == 'ú' || c == 'y') {
        return true;
    } else {
        return false;
    }
}

public static void checkSilabas(String s, Integer n_verso){
    int n_silaba=SyllableCount(s);
    if (n_silaba!=11) {
        
            throw new Error("El numero de silabas del verso "+n_verso+" es incorrecta");

    }
}

    
}

