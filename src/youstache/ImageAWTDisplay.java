package youstache;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

/**
 * Panel for displaying the selected image (right-hand side of the app window)
 * Is notified by the model when the image changes or when a moustache is added.
 * @author David
 *
 */
public class ImageAWTDisplay extends Canvas implements Observer {

	static Image moustachePNG = null;
	
	static Point moustachePNG_offset = new Point(85,15);
	
	Model modl;
	
	Image img = null;
	Point moustache = null;

	public ImageAWTDisplay(Model m) {
		super();
		this.modl = m;
		m.addObserver(this);
		this.setPreferredSize(new Dimension(450,600));
		try {
			moustachePNG = ImageIO.read(new File("moustache.png"));
		} catch (IOException e) {
			throw new RuntimeException("Couldn't find the moustage PNG");
		}
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
		
		if (this.moustache != null)
			g.drawImage(	moustachePNG, 
							this.moustache.x-moustachePNG_offset.x, 
							this.moustache.y-moustachePNG_offset.y, 
							null);
	}

	@Override
	public void update(Observable o, Object arg) {
		ImageModel im = this.modl.images.get(this.modl.indexOfSelected);
		try {
			this.img = ImageIO.read(new File("images/"+im.filename+".jpg"));
			this.moustache = im.moustacheLocation;
		} catch (IOException e) {
			throw new RuntimeException("The image images/"+im.filename+".jpg couldn't be found or loaded");
		}
		repaint();
	}
}
