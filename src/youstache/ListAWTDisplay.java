package youstache;

import java.awt.List;
import java.awt.Panel;

/**
 * Displays the list of images from the model
 * @author David
 *
 */
public class ListAWTDisplay extends Panel {
	
	public ListAWTDisplay(Model modl, ListController ctrl) {
		
		List imagesList = new List(40);
		for (int i=0; i<modl.images.size(); i++) {
			String im = modl.images.get(i).filename;
			imagesList.add(im);
		}

		imagesList.addItemListener(ctrl);
		
		this.add(imagesList);
	}

}

