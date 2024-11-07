/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blackjack;
import java.util.Random;
/**
 *
 * @author Carlos Márquez
 */

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
