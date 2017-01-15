package klondike.controllers;

import java.util.Map;

public interface SuitToStairMoveController extends OperationController{

	boolean move(String suit, int stair);
	
	Map<String,String> getSuits();

}
