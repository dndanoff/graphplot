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

    private final int unit;
    private final int devisor;

    public Scale(int unit, int devisor) {
        this.unit = unit;
        this.devisor = devisor;
    }

    public int getUnit() {
        return unit;
    }

    public int getDevisor() {
        return devisor;
    }

}
