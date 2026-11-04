package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.AppPanelMouseMotionAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppPanel extends JPanel {
    private AppFrame appFrame;
    private ArrayList<Point> points;

    public AppPanel(AppFrame appFrame){
        this.appFrame = appFrame;
        this.points = new ArrayList<>();

        setBackground(Color.LIGHT_GRAY);
        addMouseMotionListener(new AppPanelMouseMotionAdapter(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        while (points.size() > appFrame.getChainLength())
            points.remove(points.size() - 1);

        for(int i = points.size()-2; i >= 0; i--){
            int x1 = points.get(i).getX();
            int y1 = points.get(i).getY();
            int x2 = points.get(i+1).getX();
            int y2 = points.get(i+1).getY();

            float ratio = (float)i/(float)(points.size()-2);
            Color pen = Color.getHSBColor(0,1,1-ratio);
            g.setColor(pen);
            if((i % appFrame.getShapeSpacing())==0)
                stampShape(x1, y1, g);
            else if(i==points.size()-2)
                stampShape(x2, y2, g);
            g.drawLine(x1,y1,x2,y2);
        }
    }
    public void prependPoints(Point p) {
        points.add(0, p);
    }
    private void stampShape(int x, int y, Graphics g){
        int radius = appFrame.getShapeRadius();
        String kind = appFrame.getShapeKind();

        if(kind.equals(AppFrame.CIRCLE_ID))
            g.fillOval(x-radius, y-radius, radius*2,radius*2);
        if(kind.equals(AppFrame.SQUARE_ID))
            g.fillRect(x-radius, y-radius, radius*2,radius*2);
        if(kind.equals(AppFrame.HOURGLASS_ID)){
            int[] xPoints = {x-radius, x+radius, x-radius, x+radius };
            int[] yPoints = {y-radius, y-radius, y+radius, y+radius};
            int nPoints = xPoints.length;
            g.fillPolygon(xPoints,yPoints,nPoints);
        }
    }
}
