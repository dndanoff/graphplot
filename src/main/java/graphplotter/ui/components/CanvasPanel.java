/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import graphplotter.model.entity.Signal;
import graphplotter.model.vo.ComponentType;
import graphplotter.model.vo.Filter;
import graphplotter.model.vo.Scale;
import graphplotter.service.CosineSignalFactory;
import graphplotter.service.FilterApplier;
import graphplotter.service.SignalSubstractor;
import graphplotter.service.SineSignalFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public final class CanvasPanel extends JPanel{
    
    private Dimension size;
    private Scale scale;
    
    private CoordinateSystem coordinateSystem;
    private Wave sine;
    private Wave cosine;
    private Wave diff;
    
    //Needed to be visualized in Netbeans
    public CanvasPanel(){
        this(new Dimension(800,400));
    }
    
    public CanvasPanel(Dimension size){
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.size = size;
        this.scale = new Scale(1);
        this.coordinateSystem = new CoordinateSystem(this);
        Signal sineSignal = new SineSignalFactory(size.width).build();
        Signal cosineSignal = new CosineSignalFactory(size.width).build();
        this.sine = new Wave(this, sineSignal, Color.RED);
        this.cosine = new Wave(this, cosineSignal, Color.BLUE);
        this.diff = new Wave(this, new SignalSubstractor().combine(sineSignal, cosineSignal), Color.ORANGE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        coordinateSystem.paint(g);
        sine.paint(g, coordinateSystem.getCenter(), scale);
        cosine.paint(g, coordinateSystem.getCenter(), scale);
        diff.paint(g, coordinateSystem.getCenter(), scale);
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
    
    public void changeScale(Scale scale){
        this.scale = scale;
        repaint();
    }
    
    public void applyFilter(Filter filter){
        FilterApplier filterApplier = new FilterApplier();
        sine.setSignal(filterApplier.apply(filter, sine.getSignal()));
        cosine.setSignal(filterApplier.apply(filter, cosine.getSignal()));
        repaint();
    }
}
