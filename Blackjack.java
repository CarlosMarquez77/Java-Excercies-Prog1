/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.blackjack;

/**
 *
 * @author Carlos Márquez
 */
public class Blackjack {

    public static void main(String[] args) {
        Vista v = new Vista();
        Modelo m = new Modelo();
        Controlador c = new Controlador(m,v);
        
        c.start();
    }
}
