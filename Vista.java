/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;
import javax.swing.JOptionPane;
/**
 *
 * @author Carlos Márquez
 */
public class Vista {
    
    public void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void mostarResultado (String resultado){
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    //Preguntar accion
    public String preguntarOpcion(String jugadorActual){
        //Opciones a mostrar
        String[] opciones = {"Tirar Dados","No Tirar","Salir"};
        
        //Panel
        int seleccion = JOptionPane.showOptionDialog(
                            null,
                            "Que deseas hacer?",
                            "Tirar dados",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            opciones,
                            opciones[0]);
        
        //Devuelve en string
        if(seleccion >= 0){
            return opciones[seleccion].toString();
        } else {
            return "Salir";
        }
    } 
    
    
}
