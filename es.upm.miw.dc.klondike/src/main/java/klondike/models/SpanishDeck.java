package klondike.models;

public class SpanishDeck extends DeckFactory{

	private static DeckFactory spanishDeck=new SpanishDeck();
	
	private SpanishDeck(){
		this.addSuit("o", "Oros");
		this.addSuit("c", "Copas");
		this.addSuit("e", "Espadas");
		this.addSuit("b", "Bastos");
		
		this.buildSuitIntervalCards("o",1,12);
		this.buildSuitIntervalCards("c",1,12);
		this.buildSuitIntervalCards("e",1,12);
		this.buildSuitIntervalCards("b",1,12);
	}
	
	public static DeckFactory getSpanishDeck(){
		return spanishDeck;
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
