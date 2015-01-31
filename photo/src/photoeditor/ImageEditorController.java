package photoeditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ImageEditorController implements ToolChoiceListener, MouseListener, MouseMotionListener,ActionListener{

	private ImageEditorView view;
	private ImageEditorModel model;
	private Tool current_tool;
	private PixelInspectorTool inspector_tool;
	private PaintBrushTool paint_brush_tool;
	private ImageBlurTool image_blur_tool;
	
	public ImageEditorController(ImageEditorView view, ImageEditorModel model) {
		this.view = view;
		this.model = model;

		inspector_tool = new PixelInspectorTool(model);
		paint_brush_tool = new PaintBrushTool(model);
		image_blur_tool = new ImageBlurTool(model);
		
		view.addToolChoiceListener(this);
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		
		PixelInspectorUI ui =(PixelInspectorUI) inspector_tool.getUI();
		//PaintBrushToolUI pui = (PaintBrushToolUI) paint_brush_tool.getUI();
		
		ui.getButton().addActionListener(this);
		
		//pui.getOpacitySlider().addChangeListener(this);
		
		this.toolChosen(view.getCurrentToolName());
	}

	@Override
	public void toolChosen(String tool_name) {
		if (tool_name.equals("Pixel Inspector")) {
			view.installToolUI(inspector_tool.getUI());
			current_tool = inspector_tool;
		} else if (tool_name.equals("Paint Brush")) {
			view.installToolUI(paint_brush_tool.getUI());
			current_tool = paint_brush_tool;
		}else if(tool_name.equals("Blur Brush")){
			view.installToolUI(image_blur_tool.getUI());
			current_tool = image_blur_tool;
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		current_tool.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		current_tool.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		current_tool.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		current_tool.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		current_tool.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		current_tool.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		current_tool.mouseMoved(e);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		double red = inspector_tool.getClickedPixel().getRed()*100;
		double green =  inspector_tool.getClickedPixel().getGreen()*100;
		double blue =  inspector_tool.getClickedPixel().getBlue()*100;
		int setred = (int)red;
		int setgreen =(int)green;
		int setblue = (int)blue;
		
		PaintBrushToolUI ui = (PaintBrushToolUI)paint_brush_tool.getUI();
		
		ui.setSlider(setred,setblue,setgreen);
		
		view.installToolUI(paint_brush_tool.getUI());
		current_tool = paint_brush_tool;
	}

	
	

}
