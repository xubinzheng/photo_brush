package photoeditor;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;



public class ImageBlurTool implements Tool{
	private ImageBlurToolUI ui;
	private ImageEditorModel model;


	public ImageBlurTool(ImageEditorModel model) {
		this.model = model;
		ui = new ImageBlurToolUI();
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent e) {
		int x =e.getX();
		int y = e.getY();
		double redvalue,greenvalue,bluevalue;
		double redaverage = 0,greenaverage = 0,blueaverage = 0;
		redaverage = 0;
		greenaverage = 0;
	 	blueaverage = 0;
	 	int n=0;
	
		for(int horvalue = -ui.getBlurSize(); horvalue <= ui.getBlurSize(); horvalue++){
			for(int vervalue = -ui.getBlurSize(); vervalue <= ui.getBlurSize(); vervalue++){
						
				if(x+horvalue >= 0 && y+vervalue >= 0 && x+horvalue<=model.getCurrent().getWidth()-1 && y+vervalue<=model.getCurrent().getHeight()-1){
					redaverage=redaverage + model.getOriPixel(x+horvalue, y+vervalue).getRed();
					blueaverage=blueaverage +model.getOriPixel(x+horvalue, y+vervalue).getBlue();
					greenaverage=greenaverage + model.getOriPixel(x+horvalue, y+vervalue).getGreen();
				}
				else{
					redaverage=redaverage + 0;
					blueaverage=blueaverage + 0;
					greenaverage=greenaverage + 0;
					n=n+1;
					}
				}
			}
				redvalue=redaverage/((ui.getBlurSize()*2+1)*(ui.getBlurSize()*2+1)-n);
				bluevalue=blueaverage/((ui.getBlurSize()*2+1)*(ui.getBlurSize()*2+1)-n);
				greenvalue=greenaverage/((ui.getBlurSize()*2+1)*(ui.getBlurSize()*2+1)-n);
				
				ColorPixel cp = new ColorPixel(redvalue, greenvalue, bluevalue);
				
				model.paintAt(e.getX(), e.getY(), cp, ui.getBlurSize());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x =e.getX();
		int y = e.getY();
		double redvalue,greenvalue,bluevalue;
		double redaverage = 0,greenaverage = 0,blueaverage = 0;
		redaverage = 0;
		greenaverage = 0;
	 	blueaverage = 0;
	 	int n=0;
	
		for(int horvalue = -ui.getBlurSize(); horvalue <= ui.getBlurSize(); horvalue++){
			for(int vervalue = -ui.getBlurSize(); vervalue <= ui.getBlurSize(); vervalue++){
						
				if(x+horvalue >= 0 && y+vervalue >= 0&& x+horvalue<=model.getCurrent().getWidth()-1 && y+vervalue<=model.getCurrent().getHeight()-1){
					redaverage=redaverage + model.getOriPixel(x+horvalue, y+vervalue).getRed();
					blueaverage=blueaverage +model.getOriPixel(x+horvalue, y+vervalue).getBlue();
					greenaverage=greenaverage + model.getOriPixel(x+horvalue, y+vervalue).getGreen();
				}
				else{
					redaverage=redaverage + 0;
					blueaverage=blueaverage + 0;
					greenaverage=greenaverage + 0;
					n=n+1;
					}
				}
			}
				redvalue=redaverage/((ui.getBlurSize()*2+1)*(ui.getBlurSize()*2+1)-n);
				bluevalue=blueaverage/((ui.getBlurSize()*2+1)*(ui.getBlurSize()*2+1)-n);
				greenvalue=greenaverage/((ui.getBlurSize()*2+1)*(ui.getBlurSize()*2+1)-n);
				
				ColorPixel cp = new ColorPixel(redvalue, greenvalue, bluevalue);
				
				model.paintAt(e.getX(), e.getY(), cp, ui.getBlurSize());
	}
	

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Image Blur";
	}

	@Override
	public JPanel getUI() {
		// TODO Auto-generated method stub
		return ui;
	}

}
