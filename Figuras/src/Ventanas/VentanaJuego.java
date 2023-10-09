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
import Logica.Logica;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LEONARDO
 */
public class VentanaJuego extends JFrame {
   
    private JLabel jlTituloInstruciones;
    private JLabel jlInstruciones;
    private String sFiguraMuestra;
    private String sFigura1;
    private String sFigura2;
    private String sFigura3;
    private Background FiguraMuestra;
    private Background Figura1;
    private Background Figura2;
    private Background Figura3;
    private JButton btnTerminar;
    private JPanel jpContenidoJuego;
    private Logica logica;
    private List<String> figuras;

    
    
    
   // private Background jpBackground;
    public VentanaJuego(){
       iniciarComponentes();
    }
    
    private void iniciarComponentes(){
        
        logica = new Logica();
        figuras = logica.getFigures();
        System.out.println(figuras);
        //sFiguraMuestra = figuras.get(0).substring(3);

        Collections.shuffle(figuras);
       // sFigura1 = figuras.get(0).substring(3);
        //sFigura2 = figuras.get(1).substring(3);
        //sFigura3 = figuras.get(2).substring(3);
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
       
        FiguraMuestra = new Background(sFiguraMuestra);
        Figura1 = new Background(sFigura1);
        Figura2 = new Background(sFigura2);
        Figura3 = new Background(sFigura3);

        jlTituloInstruciones = new JLabel("ventana juego",SwingConstants.CENTER);
        jlInstruciones = new JLabel("ventana juego",SwingConstants.CENTER);

        add(jpContenidoJuego);
             
        jlTituloInstruciones.setBounds( 0,60, 790,20);
        jlTituloInstruciones.setForeground(Color.WHITE);
        jlTituloInstruciones.setFont(new Font("arial", Font.BOLD, 25));  
        
        jlInstruciones.setBounds(45,120, 700,150);
        jlInstruciones.setForeground(Color.WHITE);
        jlInstruciones.setFont(new Font("arial", Font.BOLD, 19));
                
        btnTerminar = new JButton ("terminar");
        btnTerminar.setBounds(665,10, 100,35);
        
        jpContenidoJuego.add(jlInstruciones);
        jpContenidoJuego.add(jlTituloInstruciones);
        jpContenidoJuego.add(btnTerminar);
        
       
        ManejadoraDeEventos manejadoraEventos = new ManejadoraDeEventos();
        
 
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
