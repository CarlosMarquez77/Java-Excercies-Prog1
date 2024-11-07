package com.mycompany.blackjack;

/**
 *
 * @author Carlos Márquez
 */

//MAIN CLASS
public class Blackjack {

    public static void main(String[] args) {
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(m,v);
        
        c.start();
    }
}

//------------CONTROLLER------------
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

//----------MODEL--------------

import java.util.Random;

public class Modelo {
    private int topePuntos;
    private int puntosJugador;
    private int puntosMaquina;
    private int turno;
    private int dados;
    private Random random;
    
    
    public Modelo(){
        this.dados = 0;
        this.turno = 0;
        this.puntosMaquina = 0;
        this.puntosJugador = 0;
        this.topePuntos = 21;
        this.random = new Random();
    }
    
    public int lanzarDado(){
        return random.nextInt(6)+1;
    }
    
    public int getTurno(){
        return turno;
    }
    
    public void setCambiarTurno(){
        turno = (turno == 0) ? 1 : 0;
    }
    
    public void setPuntosJugador(int dados){
        puntosJugador += dados;
    }
    
    
    public void setPuntosMaquina(int dados){
        puntosMaquina += dados;
    }
    
    public int getPuntosJugador(){
        return puntosJugador;
    }
    
    public int getPuntosMaquina(){
        return puntosMaquina;
    }
    
    public String Ganador(){
        if (puntosJugador > 21 && puntosMaquina > 21) {
            return "Ambos pierden, pasaron de 21.";
        } else if (puntosJugador > 21) {
            return "La máquina gana, el jugador pasó de 21.";
        } else if (puntosMaquina > 21) {
            return "El jugador gana, la máquina pasó de 21.";
        } else if (puntosJugador > puntosMaquina) {
            return "El jugador gana!";
        } else if (puntosMaquina > puntosJugador) {
            return "La máquina gana!";
        } else {
            return "Es un empate!";
        }
    }
    
}

//---------VIEW------------

import javax.swing.JOptionPane;

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
