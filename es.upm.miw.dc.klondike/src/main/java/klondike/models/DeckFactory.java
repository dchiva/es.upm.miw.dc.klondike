package klondike.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class DeckFactory {

	private Map<String,Card> cardsDeck=new HashMap<String, Card>();
	private Map<String,String> suits=new HashMap<String, String>();
	
	public void addCard(Card card){
		cardsDeck.put(card.getId(), card);
	}
	
	public Card getCard(String cardKey){
		if(this.cardsDeck.containsKey(cardKey)){
			return this.cardsDeck.get(cardKey);
		}
		return null;
	}
	
	public Collection<Card> getAllCards(){
		return this.cardsDeck.values();
	}
	
	public Collection<String> getAllKeys(){
		return this.cardsDeck.keySet();
	}
	
	public void addSuit(String briefName, String longName){
		this.suits.put(briefName, longName);
	}
	
	public Collection<String> getSuitsBriefName(){
		return this.suits.keySet();
	}
	
	public Collection<String> getSuitsLongName(){
		return this.suits.values();
	}

	public String getSuitLongName(String briefName){
		return this.suits.get(briefName);
	}
	
	public Map<String,String> getSuits(){
		return this.suits;
	}
}
