/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javaapplication1.windows.AcilisWindow;

/**
 *
 * @author ASUS
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
               
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AcilisWindow().setVisible(true);
            }
        });
        
    }
    
}
