/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import graphplotter.model.entity.Signal;
import graphplotter.model.vo.ComponentType;
import graphplotter.model.vo.Frequency;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Denis
 */
public final class CanvasPanel extends JPanel{
    
    private CoordinateSystem coordinateSystem;
    private Wave sine;
    private Wave cosine;
    private Wave diff;
    
    public CanvasPanel(){
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.coordinateSystem = new CoordinateSystem(this);
        List<Double> values = Arrays.asList(new Double[]{123d,186d,230d,432d});
        Signal signal = new Signal(new Frequency(500),values);
        this.sine = new Wave(this, signal);
        this.cosine = new Wave(this, new Signal());
        this.diff = new Wave(this, new Signal());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        coordinateSystem.paint(g);
        sine.paint(g);
//        cosine.paint(g);
//        diff.paint(g);
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
