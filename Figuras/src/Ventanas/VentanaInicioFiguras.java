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
public class VentanaInicioFiguras extends JFrame {
    
    private JLabel jlMensaje;
    private JLabel jlMensaje1;
    private JPanel jpContenido;
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnIngresar;
    
     public VentanaInicioFiguras(){
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
        
        
        //Configuración del Encabezado
        jpContenido = new JPanel();
        
        jlMensaje = new JLabel("BIENVENIDOS A JUEGOS ARCOIRIS",SwingConstants.CENTER);
        jlMensaje1 = new JLabel("Figuras, formas >> tamaños",SwingConstants.CENTER);
        jlNombre = new JLabel("POR FAVOR DIGITE SU NOMBRE",SwingConstants.CENTER );
        
           
        
        jpContenido.setSize(790,483);        
        jpContenido.setBounds(0,0, 790, 483);
        jpContenido.setLayout(null);
        
       
        add(jpContenido);
        
        jlMensaje.setBounds( 0,60, 790,20);
        jlMensaje.setForeground(Color.WHITE);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 25));  
        
        jlMensaje1.setBounds(0,120, 790,20);
        jlMensaje1.setForeground(Color.WHITE);
        jlMensaje1.setFont(new Font("arial", Font.BOLD, 19));  
        
        
        jlNombre.setBounds(0,250, 790,35);
        jlNombre.setForeground(new Color(0,87,193));
        jlNombre.setFont(new Font("arial", Font.BOLD, 15)); 
                
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(320,350, 150,35);
        
        
        jpContenido.add(jlMensaje);
        jpContenido.add(jlMensaje1);
        jpContenido.add(jlNombre);
        jpContenido.add(btnIngresar);
                
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20)); 
        
        jpContenido.add(txtNombre);
        jpContenido.setBackground(new Color(191,177,210));

        txtNombre.setBounds(198,300,395, 30);
        
        ManejadorDeEventos manejadorEventos = new ManejadorDeEventos();
        
        btnIngresar.addActionListener(manejadorEventos);
        txtNombre.addKeyListener(manejadorEventos);
        
        txtNombre.requestFocusInWindow();
       
               
    }
    
    private void iniciarJuego(){
        String nombre =txtNombre.getText();
        if(!nombre.trim().isEmpty() || nombre.trim().length() > 0){
            Jugador jugador = new Jugador(nombre);        
            dispose(); 
            VentanaMenu ventanaMenu = new VentanaMenu(jugador);              
        } else {
            JOptionPane.showMessageDialog(null,"Por favor ingrese su nombre", 
                    "Advertencia", JOptionPane.ERROR_MESSAGE);
            txtNombre.requestFocusInWindow();
        }
    }
    
    class ManejadorDeEventos implements ActionListener, KeyListener{
        @Override
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource() == btnIngresar){                
                iniciarJuego();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           /* System.out.println("Se liberó la tecla " + e.getKeyChar() +
                    " Con codigo " + e.getKeyCode());*/
            if(e.getKeyCode() == e.VK_ENTER){
                btnIngresar.doClick();
            }
        }
        

    }
}
