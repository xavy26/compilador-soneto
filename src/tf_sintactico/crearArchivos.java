/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tf_sintactico;

/**
 *
 * @author byron
 */
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author byron
 */
public class crearArchivos {
    public static void main(String[] args) {
        generarArchivo();
        try {
            String ruta = "datos" +File.separatorChar;
            String [] rutas ={ruta+"Lexer.flex"};
            
                        //CUP
            String [] rutasS={"-parser","Sintax",ruta+"Sintax.cup"};
            jflex.Main.generate(rutas);
            java_cup.Main.main(rutasS);

            //java_cup.Main.main(rutasS);
            Path sym=Paths.get(System.getProperty("user.dir")+File.separatorChar +"src" +File.separatorChar+ "analizadorSintactico"+File.separatorChar+"sym.java");
            
            eliminar(sym);
            
            Path sym1=Paths.get(System.getProperty("user.dir")+File.separatorChar +"src" +File.separatorChar+ "analizadorSintactico"+File.separatorChar+"Sintax.java");
            eliminar(sym1);
            
            Path lex=Paths.get(System.getProperty("user.dir")+File.separatorChar +"src" +File.separatorChar+ "analizadorSintactico"+File.separatorChar+"LexerCup.java");
            eliminar(lex);
            //System.out.println("AAAAAAAAAA");
            Files.move(Paths.get(System.getProperty("user.dir")+File.separatorChar + "sym.java"),sym);
            //System.out.println("AAAAAAAAAA" + sym);
            Files.move(Paths.get(System.getProperty("user.dir")+File.separatorChar + "Sintax.java"),sym1);
            Files.move(Paths.get(ruta+ "LexerCup.java"),lex);
            
        } catch (Exception e) {
            System.out.println("Error en analizador ***** " +e);
        }
    }
    
    private static void eliminar (Path ruta){
        try{
            if (Files.exists(ruta)){
                Files.delete(ruta);
            }
        } catch (Exception e) {
            System.out.println("Error "+ ruta +""+e);
        
        }
    }
    
    public static void generarArchivo(){ //Generar el Lexer.java para el LEXICO
        try {         
                       
            String ruta = "datos" +File.separatorChar;
            
            String [] rutaL ={ruta+"LexerLexico.flex"}; 
           
            jflex.Main.generate(rutaL);//generar el archivo lexer
            
            Path lexico=Paths.get(System.getProperty("user.dir")+File.separatorChar +"src" +File.separatorChar+ "analizadorSintactico"+File.separatorChar+"LexerLexico.java");
            eliminar(lexico);
            Files.move(Paths.get(System.getProperty("user.dir")+File.separatorChar + "LexerLexico.java"),lexico);     
            
        } catch (Exception e) {
            System.out.println("Error en generar archivo Lexico "+e);
        }
    }
    
}