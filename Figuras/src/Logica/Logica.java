/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
 import Jugador.Jugador;

/**
 *
 * @author LEONARDO
 */
public class Logica {
    private Jugador jugador;
    
     public Logica (Jugador jugador){
        this.jugador = jugador;              
    }
     public String getJugador(){
        return jugador.getNombre();
    }
}
