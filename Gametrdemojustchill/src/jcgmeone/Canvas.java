package jcgmeone;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    private List<List<ColorPoint>> paths; // Stores all paths
    private List<ColorPoint> currentPath; // Stores the current path being drawn
    private final int STROKE_SIZE = 8;
    private Color color;
    private int CanvasWidth;
    private int CanvasHeight;

    public Canvas(int Width, int Height) {
        super();
        setPreferredSize(new Dimension(Width, Height));
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        CanvasWidth = Width;
        CanvasHeight = Height;

        paths = new ArrayList<>();
        color = Color.BLACK; // Default color

        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentPath = new ArrayList<>();
                currentPath.add(new ColorPoint(color, e.getX(), e.getY()));
                paths.add(currentPath); // Add the new path to the list of paths
                repaint(); // Trigger a repaint
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentPath != null) {
                    currentPath.add(new ColorPoint(color, e.getX(), e.getY()));
                    repaint(); // Trigger a repaint
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                currentPath = null; // End the current path
            }
        };

        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the canvas and paint the background

        Graphics2D g2d = (Graphics2D) g;

        // Draw all stored paths
        for (List<ColorPoint> path : paths) {
            if (path.size() < 2) continue; // Skip paths with fewer than 2 points

            g2d.setColor(path.get(0).getColor()); // Set the color of the path
            g2d.setStroke(new BasicStroke(STROKE_SIZE));

            // Draw lines between consecutive points in the path
            for (int i = 1; i < path.size(); i++) {
                ColorPoint prev = path.get(i - 1);
                ColorPoint curr = path.get(i);
                g2d.drawLine(prev.getX(), prev.getY(), curr.getX(), curr.getY());
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void resetCanvas() {
        paths.clear(); // Clear all paths
        repaint(); // Trigger a repaint
    }
}