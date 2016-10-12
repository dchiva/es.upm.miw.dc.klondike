package klondike.views;

import klondike.controllers.AskOptionController;
import klondike.utils.IO;

public class BoardView {

	AskOptionController askOptionController;
	public BoardView(AskOptionController askOptionController) {
		this.askOptionController=askOptionController;
	}

	public void write(){
		IO io=new IO();
		io.write(this.askOptionController.boardToString());
	}
}
