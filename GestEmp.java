/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soulution;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GestEmp extends JFrame implements ActionListener{
    JButton btnEnregistrer;
    private JTextField nom_input;
    private JTextField matricule_input;
    private JRadioButton op_retour;
    private JRadioButton op_emprunt;
    private JButton btnAnnuler;
    private JButton btnSupprimer;
    private JComboBox<String> livre_input;
    
    public GestEmp() {
        System.out.println("soulution.GestEmp.<init>()");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel form_panel = new JPanel();
        form_panel.setLayout(new GridLayout(4, 2, 5, 20));
        
        nom_input = new JTextField();
        matricule_input = new JTextField();
        
        String[] livres = {"Le Petit Prince", "1984", "L'Étranger", "Les Misérables"};
        livre_input = new JComboBox<>(livres);
        
        op_emprunt = new JRadioButton("Emprunt", true);
        op_retour = new JRadioButton("Retour");
        ButtonGroup groupOp = new ButtonGroup();
        groupOp.add(op_emprunt);
        groupOp.add(op_retour);
        
        JPanel op_panel = new JPanel();
        op_panel.add(op_emprunt);
        op_panel.add(op_retour);
        
        form_panel.add(new JLabel("Nom de l'étudiant :"));
        form_panel.add(nom_input);

        form_panel.add(new JLabel("Matricule :"));
        form_panel.add(matricule_input);

        form_panel.add(new JLabel("Livre :"));
        form_panel.add(livre_input);

        form_panel.add(new JLabel("Opération :"));
        form_panel.add(op_panel);
        
        JPanel btn_panel = new JPanel(new GridLayout(1, 3));
        btnEnregistrer = new JButton("Enregistrer");
        btnAnnuler = new JButton("Annuler");
        btnSupprimer = new JButton("Supprimer");
        
        btn_panel.add(btnEnregistrer);
        btn_panel.add(btnAnnuler);
        btn_panel.add(btnSupprimer);

        add(form_panel, BorderLayout.CENTER);
        add(btn_panel, BorderLayout.SOUTH);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEnregistrer){
            String nom = nom_input.getText();
                String matricule = matricule_input.getText();
                String livre = (String) livre_input.getSelectedItem();
                String operation = op_emprunt.isSelected() ? "Emprunt" : "Retour";
                
                System.out.println("Nom: " + nom);
                System.out.println("Matricule: " + matricule);
                System.out.println("Livre: " + livre);
                System.out.println("Operation: " + operation);
        }
        if (e.getSource() == btnAnnuler){
            nom_input.setText("");
            matricule_input.setText("");
            livre_input.setSelectedIndex(0);
            op_emprunt.setSelected(true);
        }
    }
    
   

    
}
