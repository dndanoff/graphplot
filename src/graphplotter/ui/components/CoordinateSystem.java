/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Denis
 */
public class CoordinateSystem extends BaseComponent{

    private Point center;
    
    public CoordinateSystem(CanvasPanel parent) {
        super(parent);
    }
    
    public void paintComponent(Graphics g) {
        this.center = calculateCenter();
        drawX(g);
        drawY(g);
    }
    
    private Point calculateCenter(){
        Dimension size = getPanelSize();
        int x = 20*size.width/100;
        int y = size.height/2;
        
       return new Point(x,y);
    }
    
    private void drawX(Graphics g) {
        Dimension size = getPanelSize();
        int yCoordinate = center.y;
        g.drawLine(0, yCoordinate, size.width, yCoordinate);
        g.drawLine(size.width, yCoordinate, size.width - 10, yCoordinate - 10);
        g.drawLine(size.width, yCoordinate, size.width - 10, yCoordinate + 10);
    }

    private void drawY(Graphics g) {
        Dimension size = getPanelSize();
        int xCoordinate = center.x;
        g.drawLine(xCoordinate, 0, xCoordinate, size.height);
        g.drawLine(xCoordinate, 0, xCoordinate - 10, 10);
        g.drawLine(xCoordinate, 0, xCoordinate + 10, 10);
    }

}
