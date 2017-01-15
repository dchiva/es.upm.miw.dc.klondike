package klondike.models;

public class FrenchDeck extends DeckFactory{

	private static DeckFactory frenchDeck=new FrenchDeck();
	
	private FrenchDeck(){

		this.addSuit("p", "Picas");
		this.addSuit("r", "Rombos");
		this.addSuit("c", "Corazones");
		this.addSuit("t", "Treboles");
		
		this.buildSuitIntervalCards("p",1,12);
		this.buildSuitIntervalCards("r",1,12);
		this.buildSuitIntervalCards("c",1,12);
		this.buildSuitIntervalCards("t",1,12);
	}
	
	public static DeckFactory getDeck(){
		return frenchDeck;
	}
	
	private void buildSuitIntervalCards(String suit,int firstNumber, int lastNumber){
		this.buildCard(suit, firstNumber, null, lastNumber);
	}
	
	private Card buildCard(String suit, int number, Card nextDescendentCard, int maxCardsNumber){
		Card actualCard=new Card(suit, number);
		this.addCard(actualCard);
		actualCard.setNextDescendentCard(nextDescendentCard);
		if(number<maxCardsNumber){
			actualCard.setNextAscendentCard(this.buildCard(suit, number+1, actualCard, maxCardsNumber));
		}else{
			actualCard.setNextAscendentCard(null);
		}
		return actualCard;
	}
}
