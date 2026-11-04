package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.controls.AppFrameActionListener;
import sk.stuba.fei.uim.oop.controls.AppFrameChangeListener;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    private static final int APP_PANEL_SIDE = 600;
    private static final int LEFT_PANEL_WIDTH = 150;
    public static final String CHAIN_LENGTH_SLIDER_ID = "Length";
    public static final String SHAPE_RADIUS_SLIDER_ID = "Radius";
    public static final String SHAPE_SPACING_SLIDER_ID = "Spacing";
    public static final String SHAPE_KIND_COMBO_BOX_ID = "SHAPE_KIND_COMBO_BOX";
    static final String CIRCLE_ID = "CIRCLE";
    static final String SQUARE_ID = "SQUARE";
    static final String HOURGLASS_ID = "HOURGLASS";
    @Getter
    @Setter
    private int chainLength;
    @Getter
    @Setter
    private int shapeRadius;
    @Getter
    @Setter
    private int shapeSpacing;
    @Getter
    @Setter
    private String shapeKind;

    public AppFrame(){
        setTitle("ExamRT2023");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(LEFT_PANEL_WIDTH + APP_PANEL_SIDE, APP_PANEL_SIDE);
        setResizable(false);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(LEFT_PANEL_WIDTH, APP_PANEL_SIDE));
        JPanel leftsTopPanel = new JPanel(new GridLayout(1,3));
        JLabel chainLengthLabel = new JLabel(CHAIN_LENGTH_SLIDER_ID);
        JLabel shapeRadiusLabel = new JLabel(SHAPE_RADIUS_SLIDER_ID);
        JLabel shapeSpacingLabel = new JLabel(SHAPE_SPACING_SLIDER_ID);

        JSlider chainLengthSlider = new JSlider(SwingConstants.VERTICAL,20, 200, 50);
        chainLengthSlider.setName(CHAIN_LENGTH_SLIDER_ID);
        chainLengthSlider.setMajorTickSpacing(10);
        chainLengthSlider.setSnapToTicks(true);
        chainLengthSlider.setPaintLabels(true);
        chainLengthSlider.addChangeListener(new AppFrameChangeListener(this));
        JSlider shapeRadiusSlider = new JSlider(SwingConstants.VERTICAL,1, 20, 5);
        shapeRadiusSlider.setName(SHAPE_RADIUS_SLIDER_ID);
        shapeRadiusSlider.setMajorTickSpacing(1);
        shapeRadiusSlider.setSnapToTicks(true);
        shapeRadiusSlider.setPaintLabels(true);
        shapeRadiusSlider.addChangeListener(new AppFrameChangeListener(this));
        JSlider shapeSpacingSlider = new JSlider(SwingConstants.VERTICAL,1, 20, 5);
        shapeSpacingSlider.setName(SHAPE_SPACING_SLIDER_ID);
        shapeSpacingSlider.setMajorTickSpacing(1);
        shapeSpacingSlider.setSnapToTicks(true);
        shapeSpacingSlider.setPaintLabels(true);
        shapeSpacingSlider.addChangeListener(new AppFrameChangeListener(this));

        JComboBox shapeKindComboBox = new JComboBox(new String[]{CIRCLE_ID, SQUARE_ID, HOURGLASS_ID});
        shapeKindComboBox.setName(SHAPE_KIND_COMBO_BOX_ID);
        shapeKindComboBox.addActionListener(new AppFrameActionListener(this));

        AppPanel appPanel = new AppPanel(this);
        appPanel.setPreferredSize(new Dimension(APP_PANEL_SIDE, APP_PANEL_SIDE));

        leftsTopPanel.add(chainLengthLabel);
        leftsTopPanel.add(shapeRadiusLabel);
        leftsTopPanel.add(shapeSpacingLabel);
        leftPanel.add(leftsTopPanel,BorderLayout.NORTH);

        leftPanel.add(chainLengthSlider,BorderLayout.WEST);
        leftPanel.add(shapeRadiusSlider,BorderLayout.CENTER);
        leftPanel.add(shapeSpacingSlider,BorderLayout.EAST);
        leftPanel.add(shapeKindComboBox,BorderLayout.SOUTH);

        add(leftPanel, BorderLayout.LINE_START);
        add(appPanel, BorderLayout.CENTER);
        setVisible(true);

        chainLength = chainLengthSlider.getValue();
        shapeRadius = shapeRadiusSlider.getValue();
        shapeSpacing = shapeSpacingSlider.getValue();
        shapeKind = (String) shapeKindComboBox.getSelectedItem();
    }
}
