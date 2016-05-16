/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 13
 * Class/Program: Life Game
 * File: Life.java
 * Description: This is a program that simulates the Life Game.
 * @author Rubén Labrador Páez
 * @version 1.0.0 14/05/2016
 **/

package life;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Life extends JApplet {
	private static final int PANEL_SIZE = 50;
	private static final int DRAW_PANEL_SIZE = 500;
	private static final int SL_MIN = 20;
	private static final int SL_DEF = 200;
	private static final int SL_MAX = 1000;
	private LifePanel lifePanel = new LifePanel();
	private JPanel buttonsArea = new JPanel();
	protected JButton startButton = new JButton("Start");
	protected JButton stopButton = new JButton("Stop");
	protected JButton pauseButton = new JButton("Pause");
	protected JButton stepButton = new JButton("Step");
	protected JButton infoButton = new JButton("Info");
	protected JSlider speedSlider;
	protected JLabel speedLabel = new JLabel();
	protected Timer timer;
	protected int delay = 100;

	// Class constructor
	public Life() {
		lifePanel.setBackground(Color.WHITE);
		add(lifePanel, BorderLayout.CENTER);
		buttonsArea.setPreferredSize(new Dimension(DRAW_PANEL_SIZE, PANEL_SIZE));
		buttonsArea.setLayout(new FlowLayout());
		buttonsArea.add(startButton);
    buttonsArea.add(pauseButton);
		buttonsArea.add(stopButton);
		buttonsArea.add(stepButton);
    speedSlider = new JSlider();
    speedSlider.setMinimum(SL_MIN);
    speedSlider.setMaximum(SL_MAX);
    speedSlider.setValue(SL_DEF);
    speedSlider.setInverted(true);
    speedLabel = new JLabel("Period: " + SL_DEF + " ms");
    buttonsArea.add(speedSlider);
    buttonsArea.add(speedLabel);
    buttonsArea.add(infoButton);
		add(buttonsArea, BorderLayout.SOUTH);
		
    // Creating and adding listeners
		timer = new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lifePanel.step();
				repaint();
			}
		});

		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});

		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});

		stepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				lifePanel.step();
				repaint();
			}
		});

		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				lifePanel.clear();
				repaint();
			}
		});
		
		infoButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        InfoWindow info = new InfoWindow();
        info.setVisible(true);
      }
    });

		speedSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int speed = speedSlider.getValue();
				timer.setDelay(speed);
				speedLabel.setText("Period: " + speed + " ms");
			}
		});

		lifePanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				lifePanel.addCell(x, y);
				repaint();

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	// Main method to start like an stand alone app
	 public static void main(String[] args) {
	    JFrame frame = new JFrame();
	    Life applet = new Life();
	    frame.add(applet);
	    frame.setTitle("Life Game");
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setExtendedState(6);
	  }
}
