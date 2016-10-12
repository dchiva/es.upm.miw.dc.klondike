package klondike.controllers.local;

import java.util.HashMap;
import java.util.Map;

import klondike.controllers.OperationController;
import klondike.models.Game;
import klondike.models.Options;

public class LocalOptionsControllerBuilder {
	
	Map<Options,LocalOptionsController> optionsControllers;
	Game game;
	
	public LocalOptionsControllerBuilder(Game game){
		this.game=game;
		this.optionsControllers=new HashMap<Options,LocalOptionsController>();
		this.optionsControllers.put(Options.MOVE_DECK_TO_DISCARDS, new LocalDeckToDiscardsMoveController(this.game));
		this.optionsControllers.put(Options.MOVE_DISCARD_TO_DECK, new LocalDiscardToDeckMoveController(this.game));
		this.optionsControllers.put(Options.MOVE_DISCARD_TO_STAIR, new LocalDiscardToStairMoveController(this.game));
		this.optionsControllers.put(Options.MOVE_DISCARD_TO_SUIT, new LocalDiscardToSuitMoveController(this.game));
		this.optionsControllers.put(Options.MOVE_STAIR_TO_SUIT, new LocalStairToSuitMoveController(this.game));
		this.optionsControllers.put(Options.MOVE_STAIR_TO_STAIR, new LocalStairToStairMoveController(this.game));
		this.optionsControllers.put(Options.MOVE_SUIT_TO_STAIR, new LocalSuitToStairMoveController(this.game));
		this.optionsControllers.put(Options.SHOW_STAIR_CARD, new LocalFlipStairCardController(this.game));
		this.optionsControllers.put(Options.EXIT, new LocalExitController(this.game));
		
	}
	
	OperationController getOperationsController(){
		Options option=this.game.getOption();
		
		assert option==null || this.optionsControllers.containsKey(option);
		
		if(option==null){
			return new LocalAskOptionController(this.game);
		}else{
			this.game.setOption(null);
			return this.optionsControllers.get(option);
		}
	}

}
