/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author Denis
 */
public abstract class BaseComponent {

    protected CanvasPanel parent;
    protected Color color;

    public BaseComponent(CanvasPanel parent) {
        this.parent = parent;
        this.color = Color.BLACK;
    }

    public abstract void paintComponent(Graphics g);

    protected void paint(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(this.color);
        paintComponent(g);
        g.setColor(originalColor);
    }
    
    protected void hideComponent() {
        this.color = Color.WHITE;
    }
    
    protected void showComponent() {
        this.color = Color.BLACK;
    }

    protected Dimension getPanelSize() {
        return parent.getSize();
    }
}
