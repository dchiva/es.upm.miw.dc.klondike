package klondike.controllers.local;

import klondike.controllers.DiscardToStairMoveController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class LocalDiscardToStairMoveController extends LocalController 
												implements DiscardToStairMoveController{

	protected LocalDiscardToStairMoveController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public boolean move(int stair) {
		return this.getGame().discardToStairMove(stair);
	}

}
