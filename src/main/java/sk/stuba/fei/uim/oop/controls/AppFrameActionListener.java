package sk.stuba.fei.uim.oop.controls;

import lombok.AllArgsConstructor;
import sk.stuba.fei.uim.oop.gui.AppFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@AllArgsConstructor
public class AppFrameActionListener implements ActionListener {
    private AppFrame appFrame;

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JComboBox){
            JComboBox source = (JComboBox) e.getSource();
            if(source.getName().equals(AppFrame.SHAPE_KIND_COMBO_BOX_ID)) {
                String si = (String) source.getSelectedItem();
                appFrame.setShapeKind(si);
            }
        }
        appFrame.repaint();
    }
}
