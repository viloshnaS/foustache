package youstache;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Youstache lets you add moustaches to celebrities.
 * Listed as top grossing apps on Wire, issue Sep. 2018 
 * @author David
 *
 */
public class Youstache extends Frame implements WindowListener {

	public static void main(String[] args) {
		new Youstache("images/");
	}

	/**
	 * The app is MVC architectured.  
	 */
	Model modl;

	public Youstache(String dir) {

		this.modl = new Model();
		this.modl.loadImages(dir);

		ListController listCtrl = new ListController(modl); 
		ImageController imageCtrl= new ImageController(modl);
		
		this.setLayout(new BorderLayout());

		ListAWTDisplay leftPanel = new ListAWTDisplay(modl, listCtrl);
		this.add(leftPanel, BorderLayout.WEST);

		ImageAWTDisplay rightPanel = new ImageAWTDisplay(modl);
		this.add(rightPanel, BorderLayout.EAST);
		rightPanel.addMouseListener(imageCtrl);

		this.addWindowListener(this);
		this.setTitle("Youstache! You put the moustache!");
		this.pack();
		this.setVisible(true);
		
		this.modl.selectImage(0);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) { 
		System.exit(0); 
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
