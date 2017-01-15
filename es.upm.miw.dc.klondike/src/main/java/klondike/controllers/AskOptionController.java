package klondike.controllers;

import klondike.models.Options;

public interface AskOptionController extends OperationController{

	String boardToString();
	
	void setOption(Options option);
	
}
