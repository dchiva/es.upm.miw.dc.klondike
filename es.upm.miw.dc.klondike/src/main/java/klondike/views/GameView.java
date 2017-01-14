package klondike.views;

import java.util.Map;

import klondike.controllers.DeckToDiscardsMoveController;
import klondike.controllers.DiscardToDeckMoveController;
import klondike.controllers.DiscardToStairMoveController;
import klondike.controllers.DiscardToSuitMoveController;
import klondike.controllers.ExitController;
import klondike.controllers.FlipStairCardController;
import klondike.controllers.StairToStairMoveController;
import klondike.controllers.StairToSuitMoveController;
import klondike.controllers.SuitToStairMoveController;
import klondike.utils.IO;
import klondike.utils.LimitedIntDialog;
import klondike.utils.LimitedStringDialog;

public class GameView {

	public void interact(DiscardToDeckMoveController discardToDeckMoveController) {
		discardToDeckMoveController.move();
	}

	public void interact(DeckToDiscardsMoveController deckToDiscardMoveController) {
		deckToDiscardMoveController.move();
	}

	public void interact(DiscardToStairMoveController discardToStairMoveController) {
		int stair = new LimitedIntDialog("¿A que escalera?", 1, 7).read();
		discardToStairMoveController.move(stair-1);
	}

	public void interact(DiscardToSuitMoveController discardToSuitMoveController) {
		if(!discardToSuitMoveController.move()){
			IO io=new IO();
			io.write("\nNo se pueden mover la carta de descartes a ninguna escalera\n");
		}
	}

	public void interact(StairToStairMoveController stairToStairMoveController) {
		int originStair = new LimitedIntDialog("¿De que escalera?", 1, 7).read();
		int destinationStair = new LimitedIntDialog("¿A que escalera?", 1, 7).read();
		IO io=new IO();
		int cardsNumber=io.readInt("¿Cuantas cartas? ");
		if(!stairToStairMoveController.move(originStair-1, destinationStair-1, cardsNumber)){
			io.write("\nNo se pueden mover "+cardsNumber+" cartas de la escalera "+originStair+" a la escalera "
					+ destinationStair+"\n");
		}
	}

	public void interact(StairToSuitMoveController stairToSuitMoveController) {
		int stair = new LimitedIntDialog("¿De que escalera?", 1, 7).read();
		if(!stairToSuitMoveController.move(stair-1)){
			IO io=new IO();
			io.write("\nNo se puede mover de la escalera "+stair+" a ningún palo \n\n");
		}
	}

	public void interact(FlipStairCardController flipStairCardController) {
		int stair = new LimitedIntDialog("¿De que escalera?", 1, 7).read();
		
		if(!flipStairCardController.flipStairCard(stair-1)){
			IO io=new IO();
			io.write("\nNo se puede voltear una carta descubierta \n\n");
		}
	}

	public void interact(ExitController exitController) {
		IO io=new IO();
		io.write("\n Adiós !! Vuelve pronto !!!\n\n");
		exitController.exit();
	}

	public void interact(SuitToStairMoveController suitToStairMoveController) {
		LimitedStringDialog limitedStrindDialog=new LimitedStringDialog("¿De que palo?");
		Map<String,String> suits=suitToStairMoveController.getSuits();
		for(String suitKey:suits.keySet()){
			limitedStrindDialog.addWord(suitKey, suits.get(suitKey));
		}
		String suit=limitedStrindDialog.read();
		int stair = new LimitedIntDialog("¿A que escalera?", 1, 7).read();
		
		if(suitToStairMoveController.move(suit,stair-1)){
			IO io=new IO();
			io.write("\nNo se puede mover del palo "+suit+" a la escalera "+stair+" \n\n");
		}
	}

}
