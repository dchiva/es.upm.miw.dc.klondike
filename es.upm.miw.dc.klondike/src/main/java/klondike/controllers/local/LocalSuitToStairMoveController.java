package klondike.controllers.local;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.SuitToStairMoveController;
import klondike.models.Game;

public class LocalSuitToStairMoveController extends LocalOptionsController implements SuitToStairMoveController{

	protected LocalSuitToStairMoveController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public boolean move(String suit, int stair) {
		return this.getGame().suitToStairMove(suit,stair);
	}

}
