/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import graphplotter.model.entity.Signal;
import graphplotter.model.vo.ComponentType;
import graphplotter.model.vo.Scale;
import graphplotter.service.CosineSignalFactory;
import graphplotter.service.SignalSubstractor;
import graphplotter.service.SineSignalFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Denis
 */
public final class CanvasPanel extends JPanel{
    
    private Dimension size;
    private Scale scale;
    
    private CoordinateSystem coordinateSystem;
    private Wave sine;
    private Wave cosine;
    private Wave diff;
    
    public CanvasPanel(Dimension size){
        this.size = size;
        this.scale = new Scale(1);
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        Signal sineSignal = new SineSignalFactory(size.width).build();
        Signal cosineSignal = new CosineSignalFactory(size.width).build();
        this.sine = new Wave(this, sineSignal, Color.RED);
        this.cosine = new Wave(this, cosineSignal, Color.BLUE);
        this.diff = new Wave(this, new SignalSubstractor().combine(sineSignal, cosineSignal), Color.ORANGE);
        this.coordinateSystem = new CoordinateSystem(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        coordinateSystem.paint(g);
        sine.paint(g, coordinateSystem.getCenter(), scale);
        cosine.paint(g, coordinateSystem.getCenter(), scale);
        diff.paint(g, coordinateSystem.getCenter(), scale);
    }
    
    public void setScale(Scale scale){
        this.scale = scale;
    }
    
    public void hideComponent(ComponentType componentType){
        if(ComponentType.SINE == componentType){
            sine.hideComponent();
        }else if(ComponentType.COSINE == componentType){
            cosine.hideComponent();
        }else if(ComponentType.DIFF == componentType){
            diff.hideComponent();
        }
        
        repaint();
    }
    
    public void showComponent(ComponentType componentType){
        if(ComponentType.SINE == componentType){
            sine.showComponent();
        }else if(ComponentType.COSINE == componentType){
            cosine.showComponent();
        }else if(ComponentType.DIFF == componentType){
            diff.showComponent();
        }
        
        repaint();
    }
    
    public void changeScale(int devident, int devisor){
        repaint();
    }
}
