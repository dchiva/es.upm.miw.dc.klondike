package klondike.controllers.local;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.StartController;
import klondike.models.DeckFactory;
import klondike.models.FrenchDeck;
import klondike.models.Game;
import klondike.models.SpanishDeck;
import klondike.models.State;

public class LocalStartController extends LocalOperationController implements StartController {

	private final static int SPANISH_DECK=0;
	private final static int FRENCH_DECK=1;
	
	LocalStartController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
	@Override
	public void start(int deckType) {
		switch(deckType){
			case SPANISH_DECK:
				this.build(SpanishDeck.getSpanishDeck());
				break;
			case FRENCH_DECK:
				this.build(FrenchDeck.getFrenchDeck());
				break;
		}
		
		System.out.println("Empecemos a jugar");
		this.setState(State.IN_GAME);
	}

}
