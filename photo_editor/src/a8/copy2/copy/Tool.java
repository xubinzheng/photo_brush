package a8.copy2.copy;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public interface Tool extends MouseListener, MouseMotionListener {
	String getName();
	JPanel getUI();
}
