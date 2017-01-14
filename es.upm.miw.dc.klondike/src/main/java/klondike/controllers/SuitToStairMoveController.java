package klondike.controllers;

import java.util.Map;

public interface SuitToStairMoveController {

	boolean move(String suit, int stair);
	
	Map<String,String> getSuits();

}
