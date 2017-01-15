package klondike.controllers.local;

import klondike.controllers.OperationController;
import klondike.main.Logic;
import klondike.models.Game;
import klondike.models.Options;

public class LocalLogic implements Logic{

	private Game game;
	private LocalOptionsControllerBuilder optionsControllerBuilder;
	
	public LocalLogic(){
		this.game=new Game();
		this.optionsControllerBuilder=new LocalOptionsControllerBuilder(game);
	}
	
	@Override
	public OperationController getOperationController() {
		switch (game.getState()){
		case INITIAL:
			this.game.setOption(Options.START);
			return optionsControllerBuilder.getOperationsController();
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
