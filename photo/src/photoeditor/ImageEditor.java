package photoeditor;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditor {
	/*I finished 
	1.Provide a button in the pixel inspector tool that copies the current pixel 
	information to the paint brush tool as the color chosen for painting. (5 points)
	2.Add a slider to the paint brush user interface to control the size of the brush. (5 points)
	3.Modify the paint brush tool to allow the "opacity" of the paint to be controlled. Let opacity 
	be determined as a percentage between 0 and 100 which controls the blending of the paint brush 
	color and the existing color of the pixels being painted. (10 points)
	4.Add a new "blur" tool that acts like a paint brush but instead of painting a color it blurs 
	an area of the picture. Include controls for determining the blur area size. (10 points)
	
	*/
	public static void main(String[] args) throws IOException {
		Frame f = ColorFrame.readFromURL("http://p.qpic.cn/carforum/0/carforum_forum_201402_17_000036f93jy9b9t511hz6z.jpg/0");
		f.setTitle("K to the M to the P");

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 8 Image Editor");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageEditorModel model = new ImageEditorModel(f);
		ImageEditorView view = new ImageEditorView(main_frame, model);
 		ImageEditorController controller = new ImageEditorController(view, model);
		

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(view, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}