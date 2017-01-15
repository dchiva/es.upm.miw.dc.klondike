package klondike.controllers;

public interface StairToStairMoveController extends OperationController{

	boolean move(int originStair, int destinationStair, int cardsNumber);

}
