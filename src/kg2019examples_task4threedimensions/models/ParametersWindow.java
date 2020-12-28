package kg2019examples_task4threedimensions.models;

import kg2019examples_task4threedimensions.models.models.NewModel;
import kg2019examples_task4threedimensions.models.geometry.Plane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static kg2019examples_task4threedimensions.models.Figures.*;

public class ParametersWindow extends JFrame {
    private JPanel contentPane;
    private JTextField firstParameter;
    private JTextField secondParameter;
    private JTextField thirdParameter;
    private JTextField fourthParameter;
    private JButton sectionBtn;
    private JButton buildPlaneBtn;
    private JButton icosahedronBtn;
    private JButton cubeBtn;
    private JButton dodecahedronBtn;
    private JButton octahedronBtn;
    private JButton tetrahedronBtn;
    private JButton firstPartBtn;
    private JButton secondPartBtn;
    private JButton fullBtn;

    private FigureReader reader;
    private NewModel figure;
    private Parts part = Parts.fullFigure;
    private DrawPanel dp = DrawPanel.getDrawPanel();

    private final Plane plane = new Plane();

    public ParametersWindow() {
        firstParameter.setText("1");
        secondParameter.setText("1");
        thirdParameter.setText("2");
        fourthParameter.setText("1");
        setSize(400, 400);
        setLocation(585, 0);
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        reader = new FigureReader(plane);
        revalidate();

        tetrahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figure =  FigureFactory.createFigure(TETRAHEDRON, 1);
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        cubeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figure = FigureFactory.createFigure(CUBE, 1);
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        octahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figure = FigureFactory.createFigure(OCTAHEDRON, 1);
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        dodecahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figure = FigureFactory.createFigure(DODECAHEDRON, 1);
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        icosahedronBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                figure = FigureFactory.createFigure(ICOSAHEDRON, 1);
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        sectionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                part = Parts.section;
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        firstPartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                part = Parts.partOne;
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        secondPartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                part = Parts.partTwo;
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        fullBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                part = Parts.fullFigure;
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
        buildPlaneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plane.setNewValue(1, Float.parseFloat(firstParameter.getText()));
                plane.setNewValue(2, Float.parseFloat(secondParameter.getText()));
                plane.setNewValue(3, Float.parseFloat(thirdParameter.getText()));
                plane.setNewValue(4, Float.parseFloat(fourthParameter.getText()));
                try {
                    repaintAll();
                } catch (CloneNotSupportedException cloneNotSupportedException) {
                    cloneNotSupportedException.printStackTrace();
                }
            }
        });
    }

    private void repaintAll() throws CloneNotSupportedException {
        NewModel model = reader.getCurrentPart(figure, part);
        dp.clear();
        dp.add(new Plane3D(plane));
        dp.add(model);
    }


    public void setDrawPanel(DrawPanel drawPanel) {
        this.dp = drawPanel;
    }
}
