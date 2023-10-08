/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import Jugador.Jugador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author LEONARDO
 */
public class VentanaJuego extends JFrame {
   
    private JButton btnFigura1;
    private JButton btnTerminar;
    private JPanel jpContenidoJuego;
    private JLabel jlTituloInstruciones;
    private JLabel jlInstruciones;
    
    
    
   // private Background jpBackground;
    public VentanaJuego(){
       iniciarComponentes();
    }
    
    private void iniciarComponentes(){

        //Configuración de la ventana
        setTitle("Figuras, formas >> Tamaños");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(790,483);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        jpContenidoJuego = new JPanel();
         
       
        jpContenidoJuego.setSize(790,483);        
        jpContenidoJuego.setBounds(0,0, 790, 483);
        jpContenidoJuego.setBackground(new Color(191,177,210));
        jpContenidoJuego.setLayout(null);
       
        jlTituloInstruciones = new JLabel("ventana juego",SwingConstants.CENTER);
        jlInstruciones = new JLabel("ventana juego",SwingConstants.CENTER);

        add(jpContenidoJuego);
             
        jlTituloInstruciones.setBounds( 0,60, 790,20);
        jlTituloInstruciones.setForeground(Color.WHITE);
        jlTituloInstruciones.setFont(new Font("arial", Font.BOLD, 25));  
        
        jlInstruciones.setBounds(45,120, 700,150);
        jlInstruciones.setForeground(Color.WHITE);
        jlInstruciones.setFont(new Font("arial", Font.BOLD, 19));
        
        btnFigura1 = new JButton ("Jugar");
        btnFigura1.setBounds(320, 300, 150, 35);    
        jpContenidoJuego.add(btnFigura1);
        
        btnTerminar = new JButton ("terminar");
        btnTerminar.setBounds(665,10, 100,35);
        
        jpContenidoJuego.add(jlInstruciones);
        jpContenidoJuego.add(jlTituloInstruciones);
        jpContenidoJuego.add(btnTerminar);
        
       
        ManejadoraDeEventos manejadoraEventos = new ManejadoraDeEventos();
        
        btnFigura1.addActionListener(manejadoraEventos); 
        btnTerminar.addActionListener(manejadoraEventos);              
                

    }
    
    
    

    class ManejadoraDeEventos implements ActionListener {

        public ManejadoraDeEventos() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                      
            if (e.getSource() == btnTerminar){
                
                 JOptionPane.showMessageDialog(null,"Por favor que acabe ya este Proyecto", 
                 "me la esta pelando", JOptionPane.ERROR_MESSAGE);
                
                 dispose(); 
                 VentanaDeMenu ventanaMenu = new VentanaDeMenu();
                 ventanaMenu.setVisible(true); 
            
            }
                
        }
    }
}
