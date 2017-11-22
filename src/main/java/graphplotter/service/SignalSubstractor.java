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

public class SignalSubstractor {
    
    public Signal combine(Signal firstSignal, Signal secondSignal){
        if(firstSignal == null || secondSignal == null 
                || firstSignal.getSamples().isEmpty() 
                || secondSignal.getSamples().isEmpty()) {
            throw new IllegalArgumentException("Signal cannot be null or empty");
        }
        
        if(firstSignal.getSamples().size() != secondSignal.getSamples().size()){
            throw new IllegalArgumentException("Signals cannot be of different size");
        }
        
        List<Double> values = new ArrayList<>();
        for(int i = 0; i < firstSignal.getSamples().size(); i++){
            values.add(firstSignal.getSamples().get(i)-secondSignal.getSamples().get(i));
        }
        
        return new Signal(new Frequency(1) , values);
    }
}
