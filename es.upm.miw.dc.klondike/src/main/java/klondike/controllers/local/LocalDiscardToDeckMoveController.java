package klondike.controllers.local;

import klondike.controllers.DiscardToDeckMoveController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class LocalDiscardToDeckMoveController extends LocalController implements DiscardToDeckMoveController {

	protected LocalDiscardToDeckMoveController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);	
	}

	@Override
	public void move() {
		this.discardToDeckMove();
	}

}
