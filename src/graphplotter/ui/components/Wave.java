/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import graphplotter.model.entity.Signal;
import java.awt.Graphics;

/**
 *
 * @author Denis
 */
public class Wave extends BaseComponent {

    private Signal signal;

    public Wave(CanvasPanel parent, Signal signal) {
        super(parent);
        this.signal = signal;
    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < signal.getSamples().size(); i++) {
            g.fillOval(i*10, signal.getSamples().get(i).intValue(), 2, 2);
        }
    }
}
