package klondike.utils;

import java.util.Iterator;
import java.util.Map;

public class LimitedStringDialogConsoleView implements LimitedStringDialogView{

	private IO io;
	
	public LimitedStringDialogConsoleView(){
		this.io=new IO();
	}

	@Override
	public String readString(String title, Map<String, String> limitedWords) {
		String message=title+"\n";
		Iterator<String> limitedWordsKeys=limitedWords.keySet().iterator();
		String limitedWordKey;
		while(limitedWordsKeys.hasNext()){
			limitedWordKey=limitedWordsKeys.next();
			io.writeln("\t["+limitedWordKey+"]-"+limitedWords.get(limitedWordKey));
		}
		return io.readString(message);
	}

	@Override
	public void error(String inputWordError) {
		io.writeln("\n La palabra introducida '"+inputWordError+"' no es válida.");
	}
}
