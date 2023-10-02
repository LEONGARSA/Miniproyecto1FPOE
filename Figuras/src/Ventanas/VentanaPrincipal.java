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
public class VentanaPrincipal extends JFrame {
    
    private JLabel jlMensaje;
    private JLabel jlMensaje1;
    private JPanel jpContenido;
    private JLabel jlNombre;
    private JTextField txtNombre;
    private JButton btnIngresar;
    
     public VentanaPrincipal(){
        iniciarComponentes();
    }
    
     private void iniciarComponentes(){
        //Configuración de la ventana
        setTitle("Figuras, formas >> Tamaños");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(519,530);
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
        setLayout(null);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        
        
        //Configuración del Encabezado
        jpContenido = new JPanel();
        
        jlMensaje = new JLabel("BIENVENIDOS A JUEGOS ARCOIRIS",SwingConstants.CENTER);
        jlMensaje1 = new JLabel("Figuras, formas >> tamaños",SwingConstants.CENTER);
        jlNombre = new JLabel("Ingresa tu nombre",SwingConstants.CENTER );
        
           
        
        jpContenido.setSize(519,500);        
        jpContenido.setBounds(0,110, 519, 500);
        jpContenido.setLayout(null);
        
       
        add(jpContenido);
        
        jlMensaje.setBounds(0,20, 519,20);
        jlMensaje.setForeground(Color.GRAY);
        jlMensaje.setFont(new Font("arial", Font.BOLD, 20));  
        
        jlMensaje1.setBounds(0,80, 519,20);
        jlMensaje1.setForeground(Color.GRAY);
        jlMensaje1.setFont(new Font("arial", Font.BOLD, 15));  
        
        
        jlNombre.setBounds(0,130, 519,35);
        jlNombre.setForeground(new Color(0,87,193));
        jlNombre.setFont(new Font("arial", Font.BOLD, 20)); 
                
        btnIngresar = new JButton("Iniciar Juego");
        btnIngresar.setBounds(180,270, 150,35);
        
        
        jpContenido.add(jlMensaje);
        jpContenido.add(jlMensaje1);
        jpContenido.add(jlNombre);
        jpContenido.add(btnIngresar);
                
        txtNombre = new JTextField("");
        txtNombre.setHorizontalAlignment(JTextField.CENTER);
        txtNombre.setForeground(Color.GRAY);
        txtNombre.setFont(new Font("arial", Font.BOLD, 20)); 
        
        jpContenido.add(txtNombre);
        
        txtNombre.setBounds(50,190,410, 40);
        
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
            VentanaJuego ventanaJuego = new VentanaJuego(jugador);              
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
