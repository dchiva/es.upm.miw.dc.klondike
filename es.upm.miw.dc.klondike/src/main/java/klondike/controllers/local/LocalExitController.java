package klondike.controllers.local;

import klondike.controllers.ExitController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;
import klondike.models.State;

public class LocalExitController extends LocalOptionsController implements ExitController{

	protected LocalExitController(Game game) {
		super(game);
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public void exit() {
		this.getGame().setState(State.EXIT);
	}

}
