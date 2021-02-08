package com.hq.swingmaterialdesign.materialdesign;

import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.RenderingHints;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;

public class MGradientPanel extends JPanel
{
    private Color startColor;
    private Color endColor;
    private boolean transparentControl;
    private int gradientFocus;
    private int borderRadius;
    private boolean fillBackground;
    private String imagePath;
    private ImageIcon icon;
    private Image image;
    private boolean fillImage;
    private boolean drawBorder;
    private static Color backgroundColor;
    
    public String getImagePath() {
        return this.imagePath;
    }
    
    public void setImagePath(final String imagePath) {
        this.imagePath = imagePath;
        this.icon = new ImageIcon(this.getClass().getResource(this.imagePath));
        this.image = this.icon.getImage();
    }
    
    public ImageIcon getIcon() {
        return this.icon;
    }
    
    public void setIcon() {
        new ImageIcon(this.getClass().getResource(this.imagePath));
    }
    
    public Image getImage() {
        return this.image;
    }
    
    public void setImage(final Image image) {
        this.image = image;
    }
    
    public static Color getBackgroundColor() {
        return MGradientPanel.backgroundColor;
    }
    
    public void setBackgroundColor(final Color backgroundColor) {
        MGradientPanel.backgroundColor = backgroundColor;
    }
    
    public boolean isDrawBorder() {
        return this.drawBorder;
    }
    
    public void setDrawBorder(final boolean drawBorder) {
        this.drawBorder = drawBorder;
    }
    
    public boolean isFillImage() {
        return this.fillImage;
    }
    
    public void setFillImage(final boolean fillImage) {
        this.fillImage = fillImage;
    }
    
    public boolean isFillBackground() {
        return this.fillBackground;
    }
    
    public void setFillBackground(final boolean kFillBackground) {
        this.fillBackground = kFillBackground;
    }
    
    public int getBorderRadius() {
        return this.borderRadius;
    }
    
    public void setBorderRadius(final int kBorderRadius) {
        this.borderRadius = kBorderRadius;
    }
    
    public Color getStartColor() {
        return this.startColor;
    }
    
    public void setStartColor(final Color kStartColor) {
        this.startColor = kStartColor;
    }
    
    public Color getEndColor() {
        return this.endColor;
    }
    
    public void setEndColor(final Color kEndColor) {
        this.endColor = kEndColor;
    }
    
    public boolean isTransparentControls() {
        return this.transparentControl;
    }
    
    public void setTransparentControls(final boolean kTransparentControls) {
        this.transparentControl = kTransparentControls;
    }
    
    public int getGradientFocus() {
        return this.gradientFocus;
    }
    
    public void setGradientFocus(final int kGradientFocus) {
        this.gradientFocus = kGradientFocus;
    }
    
    public MGradientPanel() {
        this.startColor = Color.MAGENTA;
        this.endColor = Color.BLUE;
        this.transparentControl = true;
        this.gradientFocus = 500;
        this.borderRadius = 10;
        this.fillBackground = true;
        this.imagePath = "/com/hq/swingmaterialdesign/images/profile.jpg";
        this.icon = new ImageIcon(this.getClass().getResource(this.imagePath));
        this.image = this.icon.getImage();
        this.fillImage = false;
        this.drawBorder = false;
        this.setPreferredSize(new Dimension(50, 50));
        if (this.transparentControl) {
            this.setBg(true);
        }
        else {
            this.setBg(false);
        }
    }
    
    public static BufferedImage toBufferedImage(final Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage)img;
        }
        final BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), 2);
        final Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }
    
    public static BufferedImage makeRoundedCorner(final BufferedImage image, final int cornerRadius) {
        final int w = image.getWidth();
        final int h = image.getHeight();
        final BufferedImage output = new BufferedImage(w, h, 2);
        final Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackgroundColor());
        g2.fill(new RoundRectangle2D.Float(0.0f, 0.0f, (float)w, (float)h, (float)cornerRadius, (float)cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }
    
    @Override
    public synchronized void addMouseMotionListener(final MouseMotionListener l) {
        super.addMouseMotionListener(l);
    }
    
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        final int w = this.getWidth();
        final int h = this.getHeight();
        final Dimension arcs = new Dimension(this.borderRadius, this.borderRadius);
        if (this.isFillImage()) {
            g2d.setComposite(AlphaComposite.SrcAtop);
            g2d.drawImage(this.image = makeRoundedCorner(toBufferedImage(this.image), this.borderRadius * 100), 0, 0, this.getWidth(), this.getHeight(), this);
        }
        else {
            final GradientPaint gp = new GradientPaint(0.0f, 0.0f, this.startColor, (float)this.gradientFocus, (float)h, this.endColor);
            g2d.setPaint(gp);
        }
        if (this.fillBackground && !this.fillImage) {
            g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        }
        if (!this.fillImage) {
            g2d.drawRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
            g2d.fillRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        }
        else if (this.drawBorder) {
            g2d.drawRoundRect(0, 0, w - 1, h - 1, arcs.width, arcs.height);
        }
    }
    
    private void setBg(final boolean isOpaque) {
        final Component[] components2;
        final Component[] components = components2 = this.getComponents();
        for (final Component component : components2) {
            ((JLabel)component).setOpaque(isOpaque);
            ((JCheckBox)component).setOpaque(isOpaque);
            ((JTextField)component).setOpaque(isOpaque);
            ((JPasswordField)component).setOpaque(isOpaque);
            ((JFormattedTextField)component).setOpaque(isOpaque);
            ((JToolBar)component).setOpaque(isOpaque);
            ((JRadioButton)component).setOpaque(isOpaque);
        }
    }
    
    static {
        MGradientPanel.backgroundColor = Color.WHITE;
    }
}