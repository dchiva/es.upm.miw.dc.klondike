package klondike.utils;

import java.util.HashMap;
import java.util.Map;

public class LimitedStringDialog {

	private String title;
	private Map<String, String> limitedWords;
	private LimitedStringDialogView limitedStringDialogView;
	
	public LimitedStringDialog(String title){
		this.title=title;
		this.limitedWords=new HashMap<String, String>();
		this.limitedStringDialogView=new LimitedStringDialogConsoleView();
	}
	
	public LimitedStringDialog(String title, LimitedStringDialogView limitedStringDialogView){
		this.title=title;
		this.limitedWords=new HashMap<String, String>();
		this.limitedStringDialogView=limitedStringDialogView;
	}
	
	public void setLimitedStringDialogView(LimitedStringDialogView limitedStringDialogView){
		this.limitedStringDialogView=limitedStringDialogView;
	}
	
	public void addWord(String word){
		this.addWord(word, word);
	}
	
	public void addWord(String keyWord, String titleWord){
		this.limitedWords.put(keyWord, titleWord);
	}
	
	public String read(){
		String inputWord;
		boolean ok;
		do {
			inputWord = this.limitedStringDialogView.readString(this.title, this.limitedWords);
			ok = this.limitedWords.containsKey(inputWord);
			if (!ok) {
				this.limitedStringDialogView.error(inputWord);
			}
		} while (!ok);
		return inputWord;
	}
	
}
