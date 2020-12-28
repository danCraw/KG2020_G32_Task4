/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.draw.IDrawer;
import kg2019examples_task4threedimensions.models.draw.SimpleEdgeDrawer;
import kg2019examples_task4threedimensions.models.screen.ScreenConverter;
import kg2019examples_task4threedimensions.models.third.Camera;
import kg2019examples_task4threedimensions.models.third.IModel;
import kg2019examples_task4threedimensions.models.third.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author Alexey
 */
public class DrawPanel extends JPanel
        implements CameraController.RepaintListener {
    private Scene scene;
    private ScreenConverter sc;
    private Camera cam;
    private CameraController camController;
    private static DrawPanel drawPanel;

    public DrawPanel() {
        super();
        drawPanel = this;
        sc = new ScreenConverter(-1, 1, 2, 2, 1, 1);
        cam = new Camera();
        camController = new CameraController(cam, sc);
        scene = new Scene(Color.white.getRGB());
        scene.hideAxes();

        camController.addRepaintListener(this);
        addMouseListener(camController);
        addMouseMotionListener(camController);
        addMouseWheelListener(camController);
    }
    
    @Override
    public void paint(Graphics g) {
        sc.setScreenSize(getWidth(), getHeight());
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D)bi.getGraphics();
        IDrawer dr = new SimpleEdgeDrawer(sc, graphics);
        scene.drawScene(dr, cam);
        g.drawImage(bi, 0, 0, null);
        graphics.dispose();
    }

    @Override
    public void shouldRepaint() {
        repaint();
    }

    public void add(IModel model) {
        List<IModel> list = scene.getModelsList();
        if(model == null)
            return;
        list.add(model);
        shouldRepaint();
    }

    public void clear(){
        List<IModel> list = scene.getModelsList();
        list.clear();
    }

    public static DrawPanel getDrawPanel() {
        return drawPanel;
    }
}
