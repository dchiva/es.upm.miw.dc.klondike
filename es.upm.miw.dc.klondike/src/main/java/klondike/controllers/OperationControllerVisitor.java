package klondike.controllers;

import klondike.controllers.local.LocalDeckToDiscardsMoveController;
import klondike.controllers.local.LocalStairToStairMoveController;

public interface OperationControllerVisitor {

	void visit(StartController startController);
	
	void visit(AskOptionController askOptionController);
	
	void visit(DiscardToDeckMoveController discardToDeckMoveController);

	void visit(DeckToDiscardsMoveController deckToDiscardMoveController);
	
	void visit(DiscardToStairMoveController discardToStairMoveController);
	
	void visit(DiscardToSuitMoveController discardToSuitMoveController);

	void visit(StairToStairMoveController stairToStairMoveController);

	void visit(StairToSuitMoveController stairToSuitMoveController);

	void visit(FlipStairCardController flipStairCardController);

	void visit(ExitController exitController);

	void visit(SuitToStairMoveController suitToStairMoveController);
}
