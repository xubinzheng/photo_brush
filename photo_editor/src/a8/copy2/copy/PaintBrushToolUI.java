package a8.copy2.copy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.SliderUI;

public class PaintBrushToolUI extends JPanel implements ChangeListener{

	
	private JSlider red_slider;
	private JSlider green_slider;
	private JSlider blue_slider;
	private FrameView color_preview;

	private JSlider blur_slider;
	private int blur_value;
	private JSlider opacity_slider;
	private PaintBrushTool tool;
	
	public PaintBrushToolUI() {
		
		
		setLayout(new GridLayout(0,1));
		
		JPanel color_chooser_panel = new JPanel();
		color_chooser_panel.setLayout(new BorderLayout());
		
		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0,1));
		
		JPanel red_slider_panel = new JPanel();
		JLabel red_label = new JLabel("Red:");
		red_slider_panel.setLayout(new BorderLayout());
		red_slider_panel.add(red_label, BorderLayout.WEST);
		red_slider = new JSlider(0,100,50);
		red_slider.addChangeListener(this);
		red_slider_panel.add(red_slider, BorderLayout.CENTER);
	

		JPanel green_slider_panel = new JPanel();
		JLabel green_label = new JLabel("Green:");
		green_slider_panel.setLayout(new BorderLayout());
		green_slider_panel.add(green_label, BorderLayout.WEST);
		green_slider = new JSlider(0,100,50);
		green_slider.addChangeListener(this);
		green_slider_panel.add(green_slider, BorderLayout.CENTER);

		JPanel blue_slider_panel = new JPanel();
		JLabel blue_label = new JLabel("Blue: ");
		blue_slider_panel.setLayout(new BorderLayout());
		blue_slider_panel.add(blue_label, BorderLayout.WEST);
		blue_slider = new JSlider(0,100,50);
		blue_slider.addChangeListener(this);
		blue_slider_panel.add(blue_slider, BorderLayout.CENTER);
		
		JPanel blur_slider_panel = new JPanel();
		JLabel blur_label = new JLabel("Size: ");
		blur_slider_panel.setLayout(new BorderLayout());
		blur_slider_panel.add(blur_label, BorderLayout.WEST);
		blur_slider = new JSlider(0,25,5);
		blur_slider.setPaintTicks(true);
		//blur_slider.setSnapToTicks(true);
		blur_slider.setPaintLabels(true);
		blur_slider.setMajorTickSpacing(5);
		blur_slider.addChangeListener(this);
		blur_slider_panel.add(blur_slider, BorderLayout.CENTER);

		
		JPanel opacity_slider_panel = new JPanel();
		JLabel opacity_label = new JLabel("Opacity: ");
		opacity_slider_panel.setLayout(new BorderLayout());
		opacity_slider_panel.add(opacity_label, BorderLayout.WEST);
		opacity_slider = new JSlider(0,100,100);
		opacity_slider.setPaintTicks(true);
		//blur_slider.setSnapToTicks(true);
		opacity_slider.setPaintLabels(true);
		opacity_slider.setMajorTickSpacing(20);
		opacity_slider.addChangeListener(this);
		opacity_slider_panel.add(opacity_slider, BorderLayout.CENTER);
		
		// Assumes green label is widest and asks red and blue label
		// to be the same.
		Dimension d = green_label.getPreferredSize();
		red_label.setPreferredSize(d);
		blue_label.setPreferredSize(d);
		blur_label.setPreferredSize(d);
		opacity_label.setPreferredSize(d);
		
		slider_panel.add(red_slider_panel);
		slider_panel.add(green_slider_panel);
		slider_panel.add(blue_slider_panel);
		slider_panel.add(blur_slider_panel);
		slider_panel.add(opacity_slider_panel);

		color_chooser_panel.add(slider_panel, BorderLayout.CENTER);

		color_preview = new FrameView(new ColorFrame(50,50));
		color_chooser_panel.add(color_preview, BorderLayout.EAST);

		add(color_chooser_panel);
		
		stateChanged(null);
		
	}
	
	public JSlider getOpacitySlider(){
		return opacity_slider;
		
	}
	
	public int getOpacityValue(){
		return opacity_slider.getValue();
	}

	
	
	public Pixel getOpacity(){
		
		
		double red = red_slider.getValue()/100.0 * opacity_slider.getValue()/100.0+(current_red*(1-opacity_slider.getValue()/100.0));
		double green = green_slider.getValue()/100.0 * opacity_slider.getValue()/100.0+(current_green*(1-opacity_slider.getValue()/100.0));
		double blue = blue_slider.getValue()/100.0 * opacity_slider.getValue()/100.0+(current_blue*(1-opacity_slider.getValue()/100.0));
		
		
		
		Pixel p = new ColorPixel(red,green,blue);
		
		return p;
		
	}
	
	public void stateChanged(ChangeEvent e) {
		
		
		Pixel p = new ColorPixel(red_slider.getValue()/100.0,
				                 green_slider.getValue()/100.0,
				                 blue_slider.getValue()/100.0);
		Frame preview_frame = color_preview.getFrame();
		preview_frame.suspendNotifications();
		for (int x=0; x<preview_frame.getWidth(); x++) {
			for (int y=0; y<preview_frame.getHeight(); y++) {
				preview_frame.setPixel(x, y, p);
			}
		}
		preview_frame.resumeNotifications();
		
		blur_value = blur_slider.getValue();
		
		
	}


	public Pixel getBrushColor() {
		return this.getOpacity();
	}

	public int getBrushSize() {
		// TODO Auto-generated method stub
		return blur_slider.getValue();
	}

	public void setSlider(int red, int green, int blue) {
		red_slider.setValue(red);
		green_slider.setValue(green);
		blue_slider.setValue(blue);
		
	}
	double current_red;
	double current_blue;
	double current_green;

	public void getOpcityColor(double current_red, double current_blue, double current_green ) {
		// TODO Auto-generated method stub
		this.current_red= current_red;
		this.current_blue = current_blue;
		this.current_green =current_green;
	}


}
