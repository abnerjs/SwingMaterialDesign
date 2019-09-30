/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hq.swingmaterialdesign.materialdesign;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author oXCToo
 */
public class MGradientPanel extends JPanel {

    private Color startColor = Color.MAGENTA;
    private Color endColor = Color.BLUE;
    private boolean transparentControl = true;
    private int gradientFocus = 500;
    private int borderRadius = 10;
    private boolean fillBackground = true;
    private ImageIcon icon = new ImageIcon(getClass().getResource("/com/hq/swingmaterialdesign/images/profile.jpg"));
    private Image image = icon.getImage();
    private boolean fillImage = true;

    public boolean isFillImage() {
        return fillImage;
    }

    public void setFillImage(boolean fillImage) {
        this.fillImage = fillImage;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    
    
    public boolean isFillBackground() {
        return fillBackground;
    }

    public void setFillBackground(boolean kFillBackground) {
        this.fillBackground = kFillBackground;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setBorderRadius(int kBorderRadius) {
        this.borderRadius = kBorderRadius;
    }

    public Color getStartColor() {
        return startColor;
    }

    public void setStartColor(Color kStartColor) {
        this.startColor = kStartColor;
    }

    public Color getEndColor() {
        return endColor;
    }

    public void setEndColor(Color kEndColor) {
        this.endColor = kEndColor;
    }

    public boolean isTransparentControls() {
        return transparentControl;
    }

    public void setTransparentControls(boolean kTransparentControls) {
        this.transparentControl = kTransparentControls;
    }

    public int getGradientFocus() {
        return gradientFocus;
    }

    public void setGradientFocus(int kGradientFocus) {
        this.gradientFocus = kGradientFocus;
    }

    public MGradientPanel() {

        this.setPreferredSize(new Dimension(50, 50));

        if (transparentControl) {
            setBg(true);
        } else {
            setBg(false);
        }

    }

    @Override
    public synchronized void addMouseMotionListener(MouseMotionListener l) {
        super.addMouseMotionListener(l); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        Dimension arcs = new Dimension(borderRadius, borderRadius);

        
        
        if(isFillImage()) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } else {
            GradientPaint gp = new GradientPaint(0, 0, startColor, gradientFocus, h, endColor);;

            // g2d.fillRect(0, 0, w, h);
            g2d.setPaint(gp);
        }
        
        if (fillBackground && !fillImage) {
            g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        }
        
        if(!fillImage)
            g2d.drawRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        else
            g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        //g2d.dispose();
    }

    private void setBg(boolean isOpaque) {
        Component[] components = this.getComponents();
        for (Component component : components) {

            ((JLabel) component).setOpaque(isOpaque);
            ((JCheckBox) component).setOpaque(isOpaque);
            ((JTextField) component).setOpaque(isOpaque);
            ((JPasswordField) component).setOpaque(isOpaque);
            ((JFormattedTextField) component).setOpaque(isOpaque);
            ((JToolBar) component).setOpaque(isOpaque);
            ((JRadioButton) component).setOpaque(isOpaque);

        }
    }

}
