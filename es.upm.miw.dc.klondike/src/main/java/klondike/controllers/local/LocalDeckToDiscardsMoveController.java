package klondike.controllers.local;

import klondike.controllers.DeckToDiscardsMoveController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class LocalDeckToDiscardsMoveController extends LocalController implements DeckToDiscardsMoveController {

	protected LocalDeckToDiscardsMoveController(Game game) {
		super(game);
	}

	@Override
	public void move() {
		this.getGame().deckToDiscardsMove();
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

}
