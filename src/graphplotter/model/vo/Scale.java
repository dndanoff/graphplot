/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.model.vo;

/**
 *
 * @author Denis
 */
public final class Scale {

    private final int multiplier;

    public Scale(int multiplier) {
        if(multiplier <= 0){
            throw new IllegalArgumentException("Scaling factor cannot be less than 0");
        }
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
