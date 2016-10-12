package klondike.utils;

import java.util.Map;

public interface LimitedStringDialogView {
	
	String readString(String title, Map<String, String> limitedWords);

	void error(String inputWordError);

}
