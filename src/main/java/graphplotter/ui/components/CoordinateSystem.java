/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

public class CoordinateSystem{

    private CanvasPanel parent;
    private Font textFont;
    private Point center;
    
    public CoordinateSystem(CanvasPanel parent) {
        this.parent = parent;
        this.textFont = new Font(Font.MONOSPACED, Font.BOLD, 16);
    }
    
    public void paint(Graphics g) {
        Color originalColor = g.getColor();
        g.setColor(Color.BLACK);
        g.setFont(textFont);
        this.center = calculateCenter();
        drawX(g);
        drawY(g);
        g.setColor(originalColor);
    }
    
    public Point getCenter(){
        return new Point(center.x, center.y);
    }
    
    private Point calculateCenter(){
        Dimension size = getPanelSize();
        int x = 10;
        int y = size.height/2;
        
       return new Point(x,y);
    }
    
    private void drawX(Graphics g) {
        Dimension size = getPanelSize();
        int yCoordinate = center.y;
        g.drawLine(center.x, yCoordinate, size.width, yCoordinate);
        g.drawLine(size.width, yCoordinate, size.width - 10, yCoordinate - 5);
        g.drawLine(size.width, yCoordinate, size.width - 10, yCoordinate + 5);
        
        g.drawString("AMPLITUDE", 20, 20); 
    }

    private void drawY(Graphics g) {
        Dimension size = getPanelSize();
        int xCoordinate = center.x;
        g.drawLine(xCoordinate, 0, xCoordinate, size.height);
        g.drawLine(xCoordinate, 0, xCoordinate - 5, 10);
        g.drawLine(xCoordinate, 0, xCoordinate + 5, 10);
        
        g.drawString("TIME", size.width-50, size.height/2+20);
    }
    
    private Dimension getPanelSize() {
        return parent.getSize();
    }

}
