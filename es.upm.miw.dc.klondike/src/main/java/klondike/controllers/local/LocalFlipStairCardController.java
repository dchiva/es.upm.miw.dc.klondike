package klondike.controllers.local;

import klondike.controllers.FlipStairCardController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class LocalFlipStairCardController extends LocalOptionsController implements FlipStairCardController{

	protected LocalFlipStairCardController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public boolean flipStairCard(int stair) {
		return this.getGame().flipStairCard(stair);
	}

}
