package klondike.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {

	CardsGroup deck;
	CardsGroup discards;
	Map<String,CardsGroup> cardsSuits;
	List<CardsGroup> cardsStairs;
	DeckFactory deckFactory;
	
	public Board(){
		deck=new Deck();
		discards=new Discard();
		cardsSuits=new HashMap<String,CardsGroup>();
		cardsStairs=new ArrayList<CardsGroup>();
	}
	
	public void discardToDeckMove(){
		KlondikeCard cardToMove;
		while(discards.size()>0){
			cardToMove=discards.getNextCard();
			cardToMove.setHidden(true);
			deck.add(cardToMove);
			discards.removeNextCard();
		}
	}
	
	public void build(DeckFactory deckFactory){
		this.deckFactory=deckFactory;
		this.randomShuffleDeck(deckFactory.getAllCards());
		
		KlondikeCard cardToInsert;
		CardsGroup cardsGroupToAdd;
		
		for(int i=6;i>=0;i--){
			cardsGroupToAdd=new CardsStair();
			cardsStairs.add(cardsGroupToAdd);
			for(int j=0;j<=i;j++){
				cardsGroupToAdd.forceAdd(deck.removeNextCard());
			}
			cardsGroupToAdd.getNextCard().setHidden(false);
		}
		
		Iterator<String> suits =this.deckFactory.getSuitsBriefName().iterator();
		while(suits.hasNext()){
			this.cardsSuits.put(suits.next(), new CardsSuit());
		}
	}
	
	private void randomShuffleDeck(Collection<Card> cards){
		ArrayList<Card> orderedCards=new ArrayList<Card>();
		Iterator<Card> iter=cards.iterator();
		
		while(iter.hasNext()){
			orderedCards.add(iter.next());
		}
		int addedCards=0;
		int randomIndex;
		Card cardToAdd;
		Random random=new Random();
		while(addedCards<cards.size()){
			randomIndex=random.nextInt(cards.size());
			cardToAdd=orderedCards.get(randomIndex);
			if(cardToAdd!=null){
				deck.add(new KlondikeCard(cardToAdd));
				orderedCards.set(randomIndex, null);
				addedCards++;
			}
		}
	}

	public void deckToDiscardsMove(int numberOfDiscards) {
		int realNumberOfDiscards=Math.min(numberOfDiscards, this.deck.size());
		this.discardToDeckMove();
		discards.add(deck.removeNextsCards(realNumberOfDiscards));
	}
	
	public String toString(){
		String stringBoard="";
		String var="<vacio>";
		if(deck.size()>0){
			var="[X,X]";
		}
		stringBoard+="Baraja: "+var+"\n";
		var="<vacio>";
		if(this.discards.size()>0){
			var="";
			CardsGroup cg=this.discards.getNextsCards(this.discards.size());
			while(cg.hasNext()){
				var+="["+cg.removeNextCard().getId()+"] ";
			}
		}
		stringBoard+="Descarte: "+var+"\n";
		
		Iterator<String> suitsKey=this.cardsSuits.keySet().iterator();
		CardsGroup suit;
		String suitCards;
		String suitKey;
		while(suitsKey.hasNext()){
			suitKey=suitsKey.next();
			suit=this.cardsSuits.get(suitKey);
			if(suit.size()==0){
				suitCards="<vacio>";
			}else{
				suitCards=suit.toString();
			}
			stringBoard+="Palo "+this.deckFactory.getSuitLongName(suitKey)+" : "+suitCards+"\n";
		}
		
		for(int i=0;i<this.cardsStairs.size();i++){
			stringBoard+="Escalera "+(i+1)+": ";
			if(this.cardsStairs.get(i).size()>0){
				stringBoard+=this.cardsStairs.get(i).toString()+"\n";
			}else{
				stringBoard+="<vacio>\n";
			}
		}
		return stringBoard;
	}

	public boolean discardToStairMove(int stair) {
		if(this.discards.size()>0){
			if(this.cardsStairs.get(stair).add(this.discards.getNextCard())){
				this.flipStairCard(stair);
				this.discards.removeNextCard();
				return true;
			}
		}
		return false;
	}

	public boolean discardToSuitMove() {
		if(this.discards.size()>0){
			KlondikeCard discardCard=this.discards.getNextCard();
			assert !this.cardsSuits.containsKey(discardCard.getSuit());
			if(this.cardsSuits.get(discardCard.getSuit()).add(discardCard)){
				this.cardsSuits.get(discardCard.getSuit()).getNextCard().setHidden(false);
				this.discards.removeNextCard();
				return true;
			}
		}
		return false;
	}

	public boolean stairToStairMove(int originStairIndex, int destinationStairIndex, int cardsNumber) {
		cardsNumber=Math.min(cardsNumber,this.cardsStairs.get(originStairIndex).size());
		CardsGroup originSubStair=this.cardsStairs.get(originStairIndex).getNextsCards(cardsNumber);
		CardsGroup destinationStair=this.cardsStairs.get(destinationStairIndex);
		if(!originSubStair.getLastCard().isHidden() && destinationStair.add(originSubStair)){
			this.cardsStairs.get(originStairIndex).removeNextsCards(cardsNumber);
			return true;
		}
		return false;
	}

	public boolean stairToSuitMove(int stair) {
		KlondikeCard cardToSuit=this.cardsStairs.get(stair).getNextCard();
		if(this.cardsSuits.get(cardToSuit.getSuit()).add(cardToSuit)){
			this.cardsStairs.get(stair).removeNextCard();
			return true;
		}
		return false;
	}

	public boolean flipStairCard(int stair) {
		KlondikeCard stairNextCard=this.cardsStairs.get(stair).getNextCard();
		if(stairNextCard!=null&&stairNextCard.isHidden()){
			stairNextCard.setHidden(false);
			return true;
		}
		return false;
	}

	public boolean suitToStairMove(String suit, int stair) {
		KlondikeCard suitNextCard=this.cardsSuits.get(suit).getNextCard();
		if(this.cardsStairs.get(stair).add(suitNextCard)){
			this.cardsSuits.get(suit).removeNextCard();
			return true;
		}
		return false;
	}
	
	public Map<String,String> getSuits(){
		return this.deckFactory.getSuits();
	}
}
