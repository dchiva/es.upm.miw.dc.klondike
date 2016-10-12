package klondike.controllers.local;

import klondike.models.DeckFactory;
import klondike.models.Game;
import klondike.models.Options;
import klondike.models.State;

public abstract class LocalController {

	private Game game;
	
	protected LocalController(Game game){
		this.game=game;
	}
	
	protected Game getGame(){
		return this.game;
	}
	
	public void discardToDeckMove(){
		this.game.discardToDeckMove();
	}
	
	public void setState(State state){
		game.setState(state);
	}
	
	public void setOption(Options option){
		this.game.setOption(option);
	}
	
	public void build(DeckFactory deckFactory){
		this.game.buildBoard(deckFactory);
	}
}
