package klondike.controllers.local;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.StairToSuitMoveController;
import klondike.models.Game;

public class LocalStairToSuitMoveController extends LocalOptionsController implements StairToSuitMoveController{

	protected LocalStairToSuitMoveController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public boolean move(int stair) {
		return this.getGame().stairToSuitMove(stair);
	}

}
