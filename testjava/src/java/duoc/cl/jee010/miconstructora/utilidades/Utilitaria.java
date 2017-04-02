/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.jee010.miconstructora.utilidades;

/**
 *
 * @author amontess
 */
public class Utilitaria {

    public Utilitaria() {
    }
    
    //metodo que permite generar un codigo con 3 nros al azar y 3 letras.
    public static String generaCodigo(){
        String codigo="cod";
        codigo+=(int)(Math.random()*(999-100+1)+100);        
        for (int i = 0; i < 3; i++) {
            codigo+=(char)((int)(Math.random()*(90-65+1)+65));
        }
        return codigo;
    }
}
