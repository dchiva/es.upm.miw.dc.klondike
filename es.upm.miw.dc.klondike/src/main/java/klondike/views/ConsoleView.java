package klondike.views;

import klondike.controllers.AskOptionController;
import klondike.controllers.DeckToDiscardsMoveController;
import klondike.controllers.DiscardToDeckMoveController;
import klondike.controllers.DiscardToStairMoveController;
import klondike.controllers.DiscardToSuitMoveController;
import klondike.controllers.ExitController;
import klondike.controllers.FlipStairCardController;
import klondike.controllers.OperationController;
import klondike.controllers.OptionsController;
import klondike.controllers.StairToStairMoveController;
import klondike.controllers.StairToSuitMoveController;
import klondike.controllers.StartController;
import klondike.controllers.SuitToStairMoveController;
import klondike.controllers.local.LocalStairToStairMoveController;
import klondike.main.View;

public class ConsoleView implements View{

	private StartView startView;
	private GameView gameView;
	private OptionsView optionsView;
	public ConsoleView(){
		this.startView=new StartView();
		this.gameView=new GameView();
		this.optionsView=new OptionsView();
	}
	
	@Override
	public void interact(OperationController operationController) {
		assert operationController != null;
		operationController.accept(this);
	}

	@Override
	public void visit(StartController startController) {
		startView.interact(startController);
	}
	
	@Override
	public void visit(AskOptionController askOptionController) {
		optionsView.interact(askOptionController);
	}

	@Override
	public void visit(DiscardToDeckMoveController discardToDeckMoveController) {
		this.gameView.interact(discardToDeckMoveController);
	}
	
	@Override
	public void visit(DeckToDiscardsMoveController deckToDiscardMoveController) {
		this.gameView.interact(deckToDiscardMoveController);
	}

	@Override
	public void visit(DiscardToStairMoveController discardToStairMoveController) {
		this.gameView.interact(discardToStairMoveController);
	}

	@Override
	public void visit(DiscardToSuitMoveController discardToSuitMoveController) {
		this.gameView.interact(discardToSuitMoveController);
	}

	@Override
	public void visit(StairToStairMoveController stairToStairMoveController) {
		this.gameView.interact(stairToStairMoveController);
	}

	@Override
	public void visit(StairToSuitMoveController stairToSuitMoveController) {
		this.gameView.interact(stairToSuitMoveController);
	}

	@Override
	public void visit(FlipStairCardController flipStairCardController) {
		this.gameView.interact(flipStairCardController);
	}

	@Override
	public void visit(ExitController exitController) {
		this.gameView.interact(exitController);
	}

	@Override
	public void visit(SuitToStairMoveController suitToStairMoveController) {
		this.gameView.interact(suitToStairMoveController);
	}

	
}
