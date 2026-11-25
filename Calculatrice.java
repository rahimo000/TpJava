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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author rahim
 */
public class Calculatrice extends JFrame implements ActionListener {
    private JTextField aff;
    private JButton[] buttonsNum = new JButton[12];
    private JButton[] buttonsOp = new JButton[4];
    private String[] textNum = {
        "1", "2", "3",
        "4", "5", "6",
        "7", "8", "9",
        "0", "C", "="};
    private String[] textOp = {
        "+", "-", "*", "/"
    };
    private JMenuItem itemNouveau, itemOuvrir, itemCopier, itemColler;

    private double num1 = 0, num2 = 0, result = 0;
    private String operator = "";
    
    public Calculatrice() {
        System.out.println("solution.Calculator.<init>()");
        setTitle("Calculatrice");
        setSize(300, 430); // Slightly increased height to accommodate the menu bar nicely
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JMenuBar menuBar = new JMenuBar();
     
        JMenu menuFichier = new JMenu("Fichier");
        itemNouveau = new JMenuItem("Nouveau");
        itemOuvrir = new JMenuItem("Ouvrir");
        menuFichier.add(itemNouveau);
        menuFichier.add(itemOuvrir);
        
        JMenu menuEdition = new JMenu("Édition");
        itemCopier = new JMenuItem("Copier");
        itemColler = new JMenuItem("Coller");
        menuEdition.add(itemCopier);
        menuEdition.add(itemColler);
        
        menuBar.add(menuFichier);
        menuBar.add(menuEdition);
        setJMenuBar(menuBar);
        
        aff = new JTextField();
        add(aff, BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 3, 5, 5));
        for (int i = 0; i < buttonsNum.length; i++) {
            buttonsNum[i] = new JButton(textNum[i]);
            buttonsNum[i].addActionListener(this);
            centerPanel.add(buttonsNum[i]);
        }
        
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4, 1, 5, 5));
        for (int i = 0; i < buttonsOp.length; i++) {
            buttonsOp[i] = new JButton(textOp[i]);
            buttonsOp[i].addActionListener(this);
            rightPanel.add(buttonsOp[i]);
        }
        
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
                if (e.getSource() == buttonsNum[i]) {
                    aff.setText(aff.getText() + textNum[i]);
                    break;
                }
            }
        if (e.getSource() == buttonsNum[10]) {
                    aff.setText("");
                    num1 = num2 = result = 0;
                } 
        else if (e.getSource() == buttonsNum[11]) {
                    if (!aff.getText().isEmpty()) {
                        num2 = Double.parseDouble(aff.getText());
                        switch (operator) {
                            case "+": result = num1 + num2; break;
                            case "-": result = num1 - num2; break;
                            case "*": result = num1 * num2; break;
                            case "/": 
                                if (num2 != 0) {
                                    result = num1 / num2;
                                } else {
                                    aff.setText("Erreur");
                                    return;
                                }
                                break;
                        }
                        aff.setText(result + "");
                    }
                } 
                else {
                    for (int i = 0; i < buttonsOp.length; i++) {
                        if (e.getSource() == buttonsOp[i]) {
                            if (!aff.getText().isEmpty()) {
                                num1 = Double.parseDouble(aff.getText());
                                operator = textOp[i];
                                aff.setText("");
                            }
                        }
                    }
                }
    }
    
    
    
}
