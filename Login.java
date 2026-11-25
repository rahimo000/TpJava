/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soulution;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author rahim
 */
public class Login {
    public static void main(String[] args) {
        JFrame fenetre = new JFrame("test tp");
        fenetre.setSize(500,400);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel form_panel = new JPanel(new GridLayout(5,2,10,20));
        
        form_panel.add(new JLabel("Nom"));
        JTextField nom_txt = new JTextField("entrer votre nom");
        form_panel.add(nom_txt);
        
        form_panel.add(new JLabel("Mot de pass"));
        JPasswordField pass_txt = new JPasswordField("");
        form_panel.add(pass_txt);
        
        form_panel.add(new JLabel("Nom"));
        JPasswordField repass_txt = new JPasswordField("");
        form_panel.add(repass_txt);
        
        form_panel.add(new JLabel("Remarque"));
        JLabel note_label = new JLabel("");
        form_panel.add(note_label);
        
        JButton connect_btn = new JButton("Connecter");
        form_panel.add(connect_btn);
        
        JButton cancel_btn = new JButton("Annuler");
        form_panel.add(cancel_btn);
        
        connect_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.out.println(pass_txt.getPassword());
                System.out.println(repass_txt.getPassword());
                String pass ="" + pass_txt.getPassword();
                System.out.println((pass_txt.getPassword()).equals(repass_txt.getPassword()));


                if ((pass_txt.getText()).equals(repass_txt.getText()) ){
                    note_label.setText("Bonjour "+ nom_txt.getText() + "!");
                    new Calculator();
                }
                    
                else
                    note_label.setText("Mot de pass incorrect");
            }
            
        });
        
        cancel_btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                note_label.setText("");
                pass_txt.setText("");
                repass_txt.setText("");
                nom_txt.setText("");
            }
            
        });
        
        fenetre.add(form_panel);
        fenetre.setVisible(true);
    }
}
