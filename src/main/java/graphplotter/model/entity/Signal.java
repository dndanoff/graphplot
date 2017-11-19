/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.model.entity;

import graphplotter.model.vo.Frequency;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class Signal {
    
    private Frequency frequency;
    private List<Double> samples;

    public Signal(){
        this(new Frequency(500), null);
    }
    
    public Signal(Frequency frequency, List<Double> samples) {
        if(samples == null || samples.isEmpty()){
            throw new IllegalArgumentException("Signal values cannot be null or empty!");
        }
        this.frequency = frequency;
        this.samples = new ArrayList<>(samples);
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public List<Double> getSamples() {
        return new ArrayList<>(samples);
    }
}
