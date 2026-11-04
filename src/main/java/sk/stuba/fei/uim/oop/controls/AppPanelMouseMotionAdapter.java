package sk.stuba.fei.uim.oop.controls;

import lombok.AllArgsConstructor;
import sk.stuba.fei.uim.oop.gui.AppPanel;
import sk.stuba.fei.uim.oop.gui.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
@AllArgsConstructor
public class AppPanelMouseMotionAdapter extends MouseMotionAdapter {
    private AppPanel appPanel;

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        appPanel.prependPoints(new Point(x, y));
        appPanel.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e){
        mouseMoved(e);
    }
}
