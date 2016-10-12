package klondike.controllers.local;

import klondike.controllers.DiscardToSuitMoveController;
import klondike.controllers.OperationControllerVisitor;
import klondike.models.Game;

public class LocalDiscardToSuitMoveController extends LocalOptionsController 
											implements DiscardToSuitMoveController {

	protected LocalDiscardToSuitMoveController(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(OperationControllerVisitor operationControllerVisitor) {
		operationControllerVisitor.visit(this);
	}
	
	public void move(int stair){
		
	}

	@Override
	public boolean move() {
		return this.getGame().discardToSuitMove();
	}

}
