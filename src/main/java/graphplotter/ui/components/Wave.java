/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import graphplotter.model.entity.Signal;
import graphplotter.model.vo.Scale;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class Wave extends BaseComponent {

    private Signal signal;

    public Wave(CanvasPanel parent, Signal signal, Color color) {
        super(parent, color);
        this.signal = signal;
    }

    public void setSignal(Signal signal){
        this.signal = signal;
    }

    public Signal getSignal() {
        return signal;
    }
    
    public void paintComponent(Graphics g, Point center, Scale scale) {
         Polygon p = new Polygon();
        
        for (int i = 0; i < signal.getSamples().size(); i++) {
            p.addPoint(center.x+scale.getMultiplier()*i, center.y - (int)(50*signal.getSamples().get(i)));
        }
        
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
    }
}
