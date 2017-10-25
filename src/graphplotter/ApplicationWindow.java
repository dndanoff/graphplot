/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Denis
 */
public class ApplicationWindow {

    private final Dimension size;
    
    public ApplicationWindow(int width, int height) {
        this.size = new Dimension(width, height);
    }

    public void display() {
        JFrame frame = new JFrame();
        frame.setTitle("Simple Plot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size);
        frame.setResizable(false);
        frame.setContentPane(new WindowWrapper());
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        ApplicationWindow window = new ApplicationWindow(800, 400);
        window.display();
    }

}
