package klondike.controllers.local;

import java.util.Map;

import klondike.controllers.OperationControllerVisitor;
import klondike.controllers.SuitToStairMoveController;
import klondike.models.Game;

public class LocalSuitToStairMoveController extends LocalController implements SuitToStairMoveController{

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

	@Override
	public Map<String, String> getSuits() {
		return this.getGame().getSuits();
	}

}
