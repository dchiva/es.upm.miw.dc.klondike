package klondike.models;

public class KlondikeCard {

	private Card card;
	private boolean hidden;
	
	public KlondikeCard(){
		this.card=new Card();
		this.hidden=true;
	}
	
	public KlondikeCard(Card card){
		this.card=card;
		this.hidden=true;
	}
	
	public KlondikeCard(String suit, int number){
		this.card=new Card(suit,number);
		this.hidden=true;
	}
	
	public void setHidden(boolean hidden){
		this.hidden=hidden;
	}
	
	public boolean isHidden(){
		return this.hidden;
	}
	
	private Card getCard(){
		return this.card;
	}
	
	public String getId(){
		return this.getCard().getId();
	}
	
	public String getSuit() {
		return this.getCard().getSuit();
	}
	public void setSuit(String suit) {
		this.getCard().setSuit(suit);
	}
	public int getNumber() {
		return this.getCard().getNumber();
	}
	public void setNumber(int number) {
		this.getCard().setNumber(number);
	}
	
	public int getNextAscendentCardNumber(){
		return this.getCard().getNextAscendentCard().getNumber();
	}
	
	public int getFirstCardNumber(){
		return this.getCard().getFirstCard().getNumber();
	}
	
	public int getLastCardNumber(){
		return this.getCard().getLastCard().getNumber();
	}
	
	public int getNextDescendentCardNumber(){
		return this.getCard().getNextDescendentCard().getNumber();
	}
	
	public boolean areSameSuit(KlondikeCard klondikeCard){
		return this.getCard().areSameSuit(klondikeCard.getCard());
	}
	
	public boolean areComplementarySuits(KlondikeCard klondikeCard){
		return this.getCard().areComplementarySuits(klondikeCard.getCard());
	}
	
}
