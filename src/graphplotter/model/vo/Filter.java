/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.model.vo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denis
 */
public final class Filter {
    
    private final List<Integer> values;

    public Filter(List<Integer> values) {
        this.values = new ArrayList<>();
        if(values != null && !values.isEmpty()){
            this.values.addAll(values);
        }
    }

    public List<Integer> getValues() {
        return new ArrayList<>(values);
    }
}
