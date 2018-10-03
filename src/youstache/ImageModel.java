package youstache;

import java.awt.Point;

/**
 * An image model : a file and the location of moustache
 * @author David
 */
public class ImageModel {

	/**
	 * Image filename (without dir, without extension)
	 */
	String filename;

	/**
	 * Location of the moustache within the image
	 * null if no moustache
	 */
	Point moustacheLocation; 
	
	public ImageModel(String f) {
		this.filename = f;
		this.moustacheLocation = null;
	}

}
