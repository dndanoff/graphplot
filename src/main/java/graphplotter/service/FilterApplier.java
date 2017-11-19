/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.service;

import graphplotter.model.entity.Signal;
import graphplotter.model.vo.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public class FilterApplier {

    public Signal apply(Filter filter, Signal original) {
        if (filter == null || original == null) {
            throw new IllegalArgumentException("Filter and Signal values cannot be null!");
        }

        int filterMid = findFilterMiddle(filter);
        List<Double> originalValues = original.getSamples();
        List<Double> values = new ArrayList<>(originalValues);
        for (int i = 0; i < originalValues.size()-filter.getValues().size(); i++) {
            double value = 0;
            for (int j = 0; j < filter.getValues().size(); j++) {
                value += filter.getValues().get(j)*originalValues.get(i+j);
            }
            values.add(filterMid+i,value);
        }

        return new Signal(original.getFrequency(), values);
    }

    private int findFilterMiddle(Filter filter) {
        return filter.getValues().size() % 2;
    }
}
