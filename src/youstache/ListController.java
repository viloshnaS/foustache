package youstache;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Controls the list of images on the left of the app
 * @author David
 *
 */
public class ListController implements ItemListener {

	Model modl;
	
	public ListController(Model m) {
		this.modl = m;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		this.modl.selectImage((Integer)e.getItem());
	}

}
