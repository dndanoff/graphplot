/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class ApplicationWindow {

    private final Dimension size;
    
    public ApplicationWindow(int width, int height) {
        this.size = new Dimension(width, height);
    }

    public void display() {
        JFrame frame = new JFrame();
        frame.setTitle("Visual Signals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(size);
        frame.setResizable(false);
        frame.setContentPane(new WindowWrapper(size));
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        ApplicationWindow window = new ApplicationWindow(width, height);
        window.display();
    }

}
