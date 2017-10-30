/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.service;

import graphplotter.model.entity.Signal;
import graphplotter.model.vo.Frequency;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class SineSignalFactory implements SignalFactory{

    private int size;
    
    public SineSignalFactory(int size){
        this.size = size;
    }
    
    @Override
    public Signal build() {
        Frequency freq = new Frequency(500);
        List<Double> values = new ArrayList<Double>();
        
        for(int x=0; x<=size; x++){
            values.add(Math.sin(x*Math.PI/180));
        }
        
        return new Signal(freq, values);
    }
    
}
