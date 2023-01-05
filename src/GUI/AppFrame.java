/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import compressor.compressor;
import compressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton; //create compress buttons
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cross button should close our application
        this.setLayout(null);
        
        compressButton = new JButton("Select file to compress");
        compressButton.addActionListener(this); 
        compressButton.setBounds(20, 100, 200, 30); // set boundary of our buttons
        
        decompressButton = new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 100, 200, 30);
        
        this.add(compressButton); // add buttons to our app frame
        this.add(decompressButton);
        this.setSize(500,200); // size of window 
        // getContentPane holds the objects of the frame 
        this.getContentPane().setBackground(Color.black);//setting background color as black 
        this.setVisible(true); // make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==compressButton){
           JFileChooser filechooser = new JFileChooser();
           int response = filechooser.showOpenDialog(null);
           
           if(response==JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               try{
                   compressor.method(file);
               }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null,excp.toString());
               }
           }
       }
       if(e.getSource()==decompressButton){
           JFileChooser filechooser = new JFileChooser();
           int response = filechooser.showOpenDialog(null);
           
           if(response==JFileChooser.APPROVE_OPTION){
               File file = new File(filechooser.getSelectedFile().getAbsolutePath());
               try{
                   decompressor.method(file);
               }
               catch(Exception excp){
                   JOptionPane.showMessageDialog(null,excp.toString());
               }
           }
       }
    }
}
