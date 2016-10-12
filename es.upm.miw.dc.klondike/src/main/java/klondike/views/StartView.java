package klondike.views;

import klondike.controllers.StartController;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;

public class StartView {

	void interact(StartController startController){
		int baraja = new LimitedIntDialog("¿Con que baraja quieres jugar?\n\t[0]-Española\n\t[1]-Francesa\n", 0, 1).read();	
		startController.start(baraja);
	}
}
