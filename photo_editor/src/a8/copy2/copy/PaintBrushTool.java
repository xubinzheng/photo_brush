package a8.copy2.copy;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;

public class PaintBrushTool implements Tool{

	private PaintBrushToolUI ui;
	private ImageEditorModel model;

	
	public PaintBrushTool(ImageEditorModel model) {
		this.model = model;
		ui = new PaintBrushToolUI();
		
	}
	@Override
	
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Pixel p =model.getPixel(e.getX(), e.getY());
		ui.getOpcityColor(p.getRed(),p.getGreen(),p.getBlue());
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), ui.getBrushSize());
		
//		for(int i =- ui.getBrushSize();i<=- ui.getBrushSize();i++){
//			for(int j =-ui.getBrushSize();j<=- ui.getBrushSize();j++){
//				Pixel p = model.getPixel(e.getX()+i, e.getY()+j);
//				double red = p.getRed();
//				double green = p.getGreen();
//				double blue = p.getBlue();
//				ui.getOpcityColor(red,green,blue);
//				model.paintAt(e.getX()+i, e.getY()+j, ui.getBrushColor(), 1);
//			}
//		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
		Pixel p =model.getPixel(e.getX(), e.getY());
		ui.getOpcityColor(p.getRed(),p.getGreen(),p.getBlue());
		model.paintAt(e.getX(), e.getY(), ui.getBrushColor(), ui.getBrushSize());
		
		
//		for(int i =- ui.getBrushSize();i<=- ui.getBrushSize();i++){
//			for(int j =-ui.getBrushSize();j<=- ui.getBrushSize();j++){
//				Pixel p = model.getPixel(e.getX()+i, e.getY()+j);
//				
//				ui.getOpcityColor(p.getRed(),p.getGreen(),p.getBlue());
//				model.paintAt(e.getX()+i, e.getY()+j, ui.getBrushColor(), 1);
//			}
//		}
		
	}
	
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Paint Brush";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}
	
	

}
