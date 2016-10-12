package klondike.controllers.local;

import klondike.controllers.OperationController;
import klondike.main.Logic;
import klondike.models.Game;

public class LocalLogic implements Logic{

	private Game game;
	private LocalStartController startController;
	private LocalOptionsControllerBuilder optionsControllerBuilder;
	
	public LocalLogic(){
		this.game=new Game();
		this.startController=new LocalStartController(game);
		this.optionsControllerBuilder=new LocalOptionsControllerBuilder(game);
	}
	
	@Override
	public OperationController getOperationController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return optionsControllerBuilder.getOperationsController();
		case FINAL:
			//return continueController;
		case EXIT:
		default:
			return null;
		}
	}

}
