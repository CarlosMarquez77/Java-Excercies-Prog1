/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;

/**
 *
 * @author Carlos Márquez
 */
public class Controlador {
    private Vista v;
    private Modelo m;
    
    public Controlador(Modelo m, Vista v){
        this.m = m;
        this.v = v;
    }
    
    public void start(){
        
        v.mostrarMensaje("¡Bienvenido al BlackJack! (Version Dados) \nTen un Buen Juego");
        boolean jugar = true;
        
        //Capturar errores
        try {
            
            //Bucle del juego
            while(jugar){
            
                String jugadorActual = (m.getTurno() == 0) ? "Jugador" : "Computadora";
                String respuesta = v.preguntarOpcion("Jugador");
                
                switch(respuesta){
                    case "Tirar Dados":
                        int puntos = m.lanzarDado();
                            m.setPuntosJugador(puntos);
                            v.mostrarMensaje("Jugador lanzó el dado y obtuvo: " + puntos + 
                                                 "\nPuntos totales: " + m.getPuntosJugador());
                            break;
                    case "No Tirar":
                        break;
                    case "Salir":
                        jugar = false;
                        break;
                    default:
                        v.mostrarMensaje("Opcion no Valida");
                }
                
                if (!jugar){
                    break;
                }
                
            }
            
        } catch (Exception e){
            v.mostrarMensaje("Ha ocurrido un Error: "+ e.getMessage());
        }
    }
}
