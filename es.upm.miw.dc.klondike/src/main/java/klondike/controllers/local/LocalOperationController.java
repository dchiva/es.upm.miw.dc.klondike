package klondike.controllers.local;

import klondike.controllers.OperationController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public abstract class LocalOperationController extends LocalController implements OperationController {

	protected LocalOperationController(Game game){
		super(game);
	}
	@Override
	public abstract void accept(OperationControllerVisitor operationControllerVisitor);

}
