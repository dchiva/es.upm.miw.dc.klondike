package klondike.views;

import klondike.controllers.AskOptionController;
import klondike.controllers.OptionsController;
import klondike.models.Options;
import klondike.utils.LimitedIntDialog;

public class OptionsView {

	void interact(AskOptionController askOptionController){
		showBoard(askOptionController);
		System.out.println("---------------------------");
		askOptionController.setOption(this.getOption());
		System.out.println("===========================");
	}
	
	private void showBoard(AskOptionController askOptionController){
		new BoardView(askOptionController).write();
	}
	private Options getOption(){
		int numberOption = new LimitedIntDialog("Elige una opción:"
				+ "\n\t[1]-Mover de baraja a descarte"
				+ "\n\t[2]-Mover de descarte a baraja"
				+ "\n\t[3]-Mover de descarte a palo"
				+ "\n\t[4]-Mover de descarte a escalera"
				+ "\n\t[5]-Mover de escalera a palo"
				+ "\n\t[6]-Mover de escalera a escalera"
				+ "\n\t[7]-Mover de palo a escalera"
				+ "\n\t[8]-Voltear en escalera"
				+ "\n\t[9]-Salir\n", 1, 9).read();
		switch(numberOption){
			case 1:
				return Options.MOVE_DECK_TO_DISCARDS;
			case 2:
				return Options.MOVE_DISCARD_TO_DECK;
			case 3:
				return Options.MOVE_DISCARD_TO_SUIT;
			case 4:
				return Options.MOVE_DISCARD_TO_STAIR;
			case 5:
				return Options.MOVE_STAIR_TO_SUIT;
			case 6:
				return Options.MOVE_STAIR_TO_STAIR;
			case 7:
				return Options.MOVE_SUIT_TO_STAIR;
			case 8:
				return Options.SHOW_STAIR_CARD;
			case 9:
				return Options.EXIT;
		}
		assert false;
		
		return null;
	}
}
