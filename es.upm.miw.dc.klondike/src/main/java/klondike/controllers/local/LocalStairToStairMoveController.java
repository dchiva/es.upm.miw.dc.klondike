package klondike.controllers.local;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.StairToStairMoveController;
import klondike.models.Game;

public class LocalStairToStairMoveController extends LocalOptionsController implements StairToStairMoveController{

	protected LocalStairToStairMoveController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public boolean move(int originStair, int destinationStair, int cardsNumber) {
		return this.getGame().stairToStairMove(originStair, destinationStair, cardsNumber);
	}

}
