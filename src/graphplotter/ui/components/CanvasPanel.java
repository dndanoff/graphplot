/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphplotter.ui.components;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Denis
 */
public final class CanvasPanel extends JPanel{
    
    private CoordinateSystem coordinateSystem;
    
    public CanvasPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.coordinateSystem = new CoordinateSystem();
        add(coordinateSystem);
    }
    
}
