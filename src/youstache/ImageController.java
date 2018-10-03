package youstache;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Controller for the image display.
 * Basically detects click + click coordinates
 * @author David
 *
 */
public class ImageController implements MouseListener {

	Model modl;
	
	public ImageController(Model m) {
		this.modl = m;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		this.modl.pinMoustache(e.getPoint());
	}
	
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
