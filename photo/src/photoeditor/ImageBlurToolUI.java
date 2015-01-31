package photoeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ImageBlurToolUI extends JPanel implements ChangeListener{
	
	private JSlider size_slider;
	private FrameView color_preview;
	
	
	public ImageBlurToolUI() {
		//ui = new PixelInspectorUI();
		setLayout(new GridLayout(0,1));
		
		JPanel color_chooser_panel = new JPanel();
		color_chooser_panel.setLayout(new BorderLayout());
		
		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0,1));
		
		JPanel size_slider_panel = new JPanel();
		JLabel red_label = new JLabel("Red:");
		size_slider_panel.setLayout(new BorderLayout());
		size_slider_panel.add(red_label, BorderLayout.WEST);
		size_slider = new JSlider(0,25);
		size_slider.setPaintTicks(true);
		//blur_slider.setSnapToTicks(true);
		size_slider.setPaintLabels(true);
		size_slider.setMajorTickSpacing(5);
		size_slider.addChangeListener(this);
		size_slider_panel.add(size_slider, BorderLayout.CENTER);
		
		
		Dimension slider_dim = new Dimension(140,45);
		red_label.setPreferredSize(slider_dim);
		slider_panel.add(size_slider_panel);
		
		color_chooser_panel.add(slider_panel, BorderLayout.CENTER);
		add(color_chooser_panel);
		
	}

	public int getBlurSize() {
		
		int size = size_slider.getValue();
		return size;
	}

	public Pixel getBlurColor() {
		return color_preview.getFrame().getPixel(0,0);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		
		
	}
	

}
