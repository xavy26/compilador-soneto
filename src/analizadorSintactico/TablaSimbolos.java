/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author byron
 */
public class TablaSimbolos {
    public static List lista = new ArrayList();
    public static List lista2 = new ArrayList();
    public static List lista3 = new ArrayList();
    public static List lista4 = new ArrayList();
    //Listas creadas
    //1. Nos da que lista es
    //2. Propiamente el texto
    //3. La linea
    //4. La columna
    
    public static List getLista() {
        return lista;
    }

    public static void setLista(List lista) {
        TablaSimbolos.lista = lista;
    }

    public static List getLista2() {
        return lista2;
    }

    public static void setLista2(List lista2) {
        TablaSimbolos.lista2 = lista2;
    }

    public static List getLista3() {
        return lista3;
    }

    public static void setLista3(List lista3) {
        TablaSimbolos.lista3 = lista3;
    }

    public static List getLista4() {
        return lista4;
    }

    public static void setLista4(List lista4) {
        TablaSimbolos.lista4 = lista4;
    }
    
    public static void addArrayList(String dato){
        lista.add(dato);
    }
    
    public static void addArrayList2(String dato){
        lista2.add(dato);
    }
    public static void addArrayList3(Integer dato){
        lista3.add(dato);
    }
    public static void addArrayList4(Integer dato){
        lista4.add(dato);
        //ver();
    }
    
    public static void ver(){
        
        for (int i = 0; i < TablaSimbolos.lista.size(); i++) {
            System.out.println(TablaSimbolos.lista.get(i)+"-->\t"+TablaSimbolos.lista2.get(i)+"\t"+TablaSimbolos.lista3.get(i)+"\t"+TablaSimbolos.lista4.get(i)+"");
        }
    }
}
