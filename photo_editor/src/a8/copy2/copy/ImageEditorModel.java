package a8.copy2.copy;

public class ImageEditorModel {

	private Frame original;
	private Frame current;
	
	public ImageEditorModel(Frame f) {
		original = f;
		current = original.copy();
	}
	
	public Pixel getOriPixel(int x, int y){
		return original.getPixel(x, y);
	}

	public Frame getCurrent() {
		return current;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size) {
		current.suspendNotifications();
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					current.setPixel(xpos, ypos, brushColor);
				}
			}
		}
		current.resumeNotifications();
	}
}
