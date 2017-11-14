package Application;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class DrawingBoard extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private final int BRUSH_SIZE = 10;
	private final int WINDOW_SIZE = 280;
	
	private int x = 1, y = -1;
	private static DrawingBoard self = new DrawingBoard();

	private DrawingBoard() {
		super("Digit Drawing Board");
		init();
	}

	public static DrawingBoard getDrawingBoard() {
		return self;
	}

	private void init() {
		addWindowListener(
				new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent event) {
						System.exit(0);
					}
				});
		getContentPane().add(new Label("Drag mouse to draw digit"), 
				BorderLayout.SOUTH);
		addMouseMotionListener(
				new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent event) {
						x = event.getX();
						y = event.getY();
						repaint();
					}
				});
		setSize(WINDOW_SIZE, WINDOW_SIZE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		g.fillOval(x, y, BRUSH_SIZE, BRUSH_SIZE);
	}
}
