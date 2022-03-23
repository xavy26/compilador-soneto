/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico.modelo;

/**
 *
 * @author byron
 */
public class Rimas {
    private String ultimasletras;
    private Integer nLinea;

    public  Rimas (){}
    public Rimas(String ultimasletras, Integer nLinea) {
        this.ultimasletras = ultimasletras;
        this.nLinea = nLinea;
    }

    
    public String getUltimasletras() {
        return ultimasletras;
    }

    public void setUltimasletras(String ultimasletras) {
        this.ultimasletras = ultimasletras;
    }

    public Integer getnLinea() {
        return nLinea;
    }

    public void setnLinea(Integer nLinea) {
        this.nLinea = nLinea;
    }
    
    
    
}
