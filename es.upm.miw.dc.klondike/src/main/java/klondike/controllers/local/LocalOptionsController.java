package klondike.controllers.local;

import klondike.controllers.OptionsController;
import klondike.models.Game;
import klondike.models.Options;

public abstract class LocalOptionsController extends LocalOperationController implements OptionsController{

	protected LocalOptionsController(Game game) {
		super(game);
	}
}
