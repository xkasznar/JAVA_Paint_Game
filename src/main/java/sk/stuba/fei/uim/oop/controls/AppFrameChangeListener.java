package sk.stuba.fei.uim.oop.controls;

import lombok.AllArgsConstructor;
import sk.stuba.fei.uim.oop.gui.AppFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@AllArgsConstructor
public class AppFrameChangeListener implements ChangeListener {
    private AppFrame appFrame;

    @Override
    public void stateChanged(ChangeEvent e){
        if(e.getSource() instanceof JSlider) {
            JSlider source = (JSlider) e.getSource();
            if (!source.getValueIsAdjusting()) {
                if(source.getName().equals(AppFrame.CHAIN_LENGTH_SLIDER_ID))
                    appFrame.setChainLength(source.getValue());
                if(source.getName().equals(AppFrame.SHAPE_RADIUS_SLIDER_ID))
                    appFrame.setShapeRadius(source.getValue());
                if(source.getName().equals(AppFrame.SHAPE_SPACING_SLIDER_ID))
                    appFrame.setShapeSpacing(source.getValue());
            }
        }
        appFrame.repaint();
    }
}
