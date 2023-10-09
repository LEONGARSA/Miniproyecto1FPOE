/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Logica.Logica;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        sFiguraMuestra = figuras.get(0).substring(3);

        Collections.shuffle(figuras);
        sFigura1 = figuras.get(0).substring(3);
        sFigura2 = figuras.get(1).substring(3);
        sFigura3 = figuras.get(2).substring(3);
        //Configuración de la ventana
        setTitle("Figuras, formas >> Tamaños");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(790,483);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);
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
             
        FiguraMuestra.setBounds(50, 180, 129, 126);
        Figura1.setBounds(250, 180, 129, 126);
        Figura2.setBounds(400, 180, 129, 126);
        Figura3.setBounds(570, 180, 129, 126);
        jlTituloInstruciones.setBounds( 0,60, 790,20);
        jlTituloInstruciones.setForeground(Color.WHITE);
        jlTituloInstruciones.setFont(new Font("arial", Font.BOLD, 25));  
        
        jlInstruciones.setBounds(45,10, 700,150);
        jlInstruciones.setForeground(Color.WHITE);
        jlInstruciones.setFont(new Font("arial", Font.BOLD, 19));
                
        btnTerminar = new JButton ("terminar");
        btnTerminar.setBounds(665,10, 100,35);
        
        jpContenidoJuego.add(jlInstruciones);
        jpContenidoJuego.add(jlTituloInstruciones);
        jpContenidoJuego.add(btnTerminar);
        
        add(FiguraMuestra);
        add(Figura1);
        add(Figura2);
        add(Figura3);

        getContentPane().setComponentZOrder(FiguraMuestra,0);
        getContentPane().setComponentZOrder(Figura1,0);
        getContentPane().setComponentZOrder(Figura2,0);
        getContentPane().setComponentZOrder(Figura3,0);



       
        ManejadoraDeEventos manejadoraEventos = new ManejadoraDeEventos();        
        btnTerminar.addActionListener(manejadoraEventos);
        
        
        
       
        Figura1.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                compararFiguras(sFigura1);
            }
        });
        
        Figura2.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                compararFiguras(sFigura2);
            }
        });

        Figura3.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                compararFiguras(sFigura3);
            }
        });
        
        getContentPane().revalidate();
        
    }
    private void compararFiguras(String figura) {
        
    if (sFiguraMuestra.equals(figura)) {
        
        figuras = logica.getFigures();
       
        sFiguraMuestra = figuras.get(0).substring(3);
        Collections.shuffle(figuras);
        sFigura1 = figuras.get(0).substring(3);
        sFigura2 = figuras.get(1).substring(3);
        sFigura3 = figuras.get(2).substring(3);

        // Cambiar las imágenes de los componentes
        FiguraMuestra.setNombre(sFiguraMuestra);
        Figura1.setNombre(sFigura1);
        Figura2.setNombre(sFigura2);
        Figura3.setNombre(sFigura3);
        
        FiguraMuestra.repaint();
        Figura1.repaint();
        Figura2.repaint();
        Figura3.repaint();

        getContentPane().revalidate();
    }
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
