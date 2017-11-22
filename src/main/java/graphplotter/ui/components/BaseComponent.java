/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import graphplotter.model.vo.Scale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public abstract class BaseComponent {

    protected CanvasPanel parent;
    protected Color color;
    
    protected Color tempColor;

    public BaseComponent(CanvasPanel parent, Color color) {
        this.parent = parent;
        this.color = color;
        this.tempColor = color;
    }

    public abstract void paintComponent(Graphics g, Point center, Scale scale);

    protected void paint(Graphics g, Point center, Scale scale) {
        Color originalColor = g.getColor();
        g.setColor(this.color);
        paintComponent(g, center, scale);
        g.setColor(originalColor);
    }
    
    protected void hideComponent() {
        this.tempColor = this.color;
        this.color = Color.WHITE;
    }
    
    protected void showComponent() {
        this.color = this.tempColor;
    }

    protected Dimension getPanelSize() {
        return parent.getSize();
    }
}
