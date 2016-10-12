package klondike.models;

public class Card{

	private String suit;
	private int number;
	private String id;
	private Card nextAscendentCard=null;
	private Card nextDescendentCard=null;
	
	public Card(){}
	
	public Card(String suit, int number){
		this.suit=suit;
		this.number=number;
		this.id=this.number+"-"+this.suit;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Card getNextAscendentCard(){
		return this.nextAscendentCard;
	}
	
	public Card getFirstCard(){
		if(this.nextDescendentCard==null){
			return this;
		}else{
			return this.nextDescendentCard.getFirstCard();
		}
	}
	
	public Card getLastCard(){
		if(this.nextAscendentCard==null){
			return this;
		}else{
			return this.nextAscendentCard.getLastCard();
		}
	}
	
	public void setNextAscendentCard(Card nextAscendentCard){
		this.nextAscendentCard=nextAscendentCard;
	}
	
	public void setNextDescendentCard(Card nextDescendentCard){
		this.nextDescendentCard=nextDescendentCard;
	}
	
	public Card getNextDescendentCard(){
		return this.nextDescendentCard;
	}
	
	public boolean areSameSuit(Card c){
		return this.getSuit().equals(c.getSuit());
	}
	
	public boolean areComplementarySuits(Card c){
		return true;
	}
}
