/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico.utiles;
import analizadorSintactico.modelo.Rimas;
import static analizadorSintactico.utiles.silaba.SyllableCount;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author byron
 */
public class Utiles {
   static ArrayList<Rimas>letras=new ArrayList<>();
    
    public static void checkVersoParrafo(Integer linea, Integer parrafo)    {
        if (!(linea==14)) {
         
                throw new Error("El numero de versos es incorrecto");
        }
        
        if (!(parrafo==4)) {
   
                throw new Error("El numero de parrafos es incorrecto");
        } 
    }
    
    public static void checkVersoIndividual(Integer n_parrafo, Integer n_linea)  {
            if (!((n_parrafo==1 && n_linea ==4) ||   (n_parrafo==2 && n_linea ==8) || (n_parrafo==3 && n_linea ==11) || (n_parrafo==4 && n_linea ==14))) {
                //System.out.println(n_parrafo+" + "+n_linea);
        
                    throw new Error("El numero de versos del parrafo "+ n_parrafo+" es incorrecto");
            }
    }

    public static void getVerso(String linea, Integer nlinea){

        char letrau = linea.charAt(linea.length()-2);
        char letrapu = linea.charAt(linea.length()-3);
        String ultimasletras=""+letrapu+letrau;
        
        silaba.checkSilabas(linea, nlinea);  // verificar silabas

        Rimas rima = new Rimas(ultimasletras, nlinea);
        letras.add(rima);
        
    }
    

    public static void compararRimas()   {
        if (!letras.isEmpty()) {
            if (!letras.get(0).getUltimasletras().equalsIgnoreCase(letras.get(3).getUltimasletras()) || 
                !letras.get(0).getUltimasletras().equalsIgnoreCase(letras.get(4).getUltimasletras()) ||   
                !letras.get(0).getUltimasletras().equalsIgnoreCase(letras.get(7).getUltimasletras()) ) {
                    letras.clear();
                    throw new Error("ERROR EN LAS RIMAS DE LOS 2 PRIMEROS PARRAFOS");

            } 
            
            if (!letras.get(1).getUltimasletras().equalsIgnoreCase(letras.get(2).getUltimasletras()) || 
                !letras.get(1).getUltimasletras().equalsIgnoreCase(letras.get(5).getUltimasletras()) ||   
                !letras.get(1).getUltimasletras().equalsIgnoreCase(letras.get(6).getUltimasletras()) ) {
                    letras.clear();
                    throw new Error("Error en las rimas de los 2 primeros parrafos"); 
            }
            
            if (!letras.get(8).getUltimasletras().equalsIgnoreCase(letras.get(10).getUltimasletras()) || 
                !letras.get(8).getUltimasletras().equalsIgnoreCase(letras.get(12).getUltimasletras()) ) {
                    letras.clear();
                    throw new Error("Error en las rimas de los 2 ultimos parrafos");
            } 
            
            if (!letras.get(9).getUltimasletras().equalsIgnoreCase(letras.get(11).getUltimasletras()) || 
                !letras.get(9).getUltimasletras().equalsIgnoreCase(letras.get(13).getUltimasletras()) ) {
                    letras.clear();
                    throw new Error("Error en las rimas de los 2 ultimos parrafos");
            }
            letras.clear(); //reinicio el arreglo para rimar
          
        }
        

        
    };
    
}
