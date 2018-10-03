package youstache;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

/**
 * The model is a list of images
 * @see ImageModel
 * @author David
  */
public class Model extends Observable { 

	/**
	 * The model is a list of images loaded from a directory
	 */
	public ArrayList<ImageModel> images;

	/**
	 * The index of the currently selected image
	 */
	int indexOfSelected = 0;

	public Model() {}

	/**
	 * Explores the 'images' directory and fill the model
	 * @param dir
	 */
	public void loadImages(String dir) {
		
		File imagesDir = new File(dir);
		File[] imagesList = imagesDir.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesList) {
			String imageName = file.getName().split("\\.")[0];
			this.images.add(new ImageModel(imageName));
		}
	}

	/**
	 * When an image is selected from the list, the model records the index 
	 * and notifies the view for display to change.
	 * @param item
	 */
	public void selectImage(int item) {
		this.indexOfSelected = item;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * When an image is clicked from the panel, the model acknowledges 
	 * the coordinates of the requested moustache, and notifies 
	 * the view for the display to change
	 * @param coords
	 */
	public void pinMoustache(Point coords) {
		this.images.get(this.indexOfSelected).moustacheLocation = coords;
		this.setChanged();
		this.notifyObservers();
	}

}
