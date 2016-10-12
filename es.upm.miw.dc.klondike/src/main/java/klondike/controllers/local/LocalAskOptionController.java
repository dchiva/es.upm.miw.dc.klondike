package klondike.controllers.local;

import klondike.controllers.AskOptionController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class LocalAskOptionController extends LocalOptionsController implements AskOptionController{

	protected LocalAskOptionController(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}

	@Override
	public String boardToString() {
		return this.getGame().boardToString();
	}


}
