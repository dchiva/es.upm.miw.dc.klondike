package klondike.models;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class CardsGroup {
	
	private LinkedList<KlondikeCard> cards=new LinkedList<KlondikeCard>();
	
	
	public abstract boolean add(KlondikeCard c);
	
	public abstract boolean forceAdd(KlondikeCard c);
	
	public abstract boolean canPutCard(KlondikeCard c);
	
	public abstract CardsGroup initializeCardsGroup();

	public boolean add(CardsGroup cardsGroup) {
		int addedCards=0;
		boolean successAdding=true;
		Iterator<KlondikeCard> cardsToAdd=cardsGroup.getCards().iterator();
		while(successAdding && cardsToAdd.hasNext()){
			successAdding=this.add(cardsToAdd.next());
			if(successAdding){
				addedCards++;
			}
		}
		if(!successAdding){
			this.removeNextsCards(addedCards);
			return false;
		}
		return true;
	}
	
	public KlondikeCard getNextCard(){
		return this.getCards().peekFirst();
	}
	
	public KlondikeCard getLastCard(){
		return this.getCards().peekLast();
	}
	
	public CardsGroup getNextsCards(int numberOfCards){
		Iterator<KlondikeCard> iter=this.getCards().iterator();
		CardsGroup subCardsGroup=this.initializeCardsGroup();
		int i=0;
		while(i<numberOfCards && iter.hasNext()){
			subCardsGroup.forceAdd(iter.next());
			i++;
		}
		return subCardsGroup;
	}
	
	public KlondikeCard removeNextCard(){
		return this.getCards().removeFirst();
	}
	
	public CardsGroup removeNextsCards(int numberOfCards){
		CardsGroup subCardsGroup=this.initializeCardsGroup();
		//to do : Eliminar este if por un assert
		if(this.getCards().size()>=numberOfCards){
			for(int i=0;i<numberOfCards;i++){
				subCardsGroup.add(this.getCards().removeFirst());
			}
		}
		return subCardsGroup;
	}
	
	public boolean hasNext(){
		return this.getCards().size()>0;
	}
	
	public int size(){
		return this.getCards().size();
	}
	
	LinkedList<KlondikeCard> getCards(){
		return this.cards;
	}
	
	public String toString(){
		String stringCards="";
		Iterator<KlondikeCard> iter=this.cards.iterator();
		KlondikeCard klondikeCard;
		while(iter.hasNext()){
			klondikeCard=iter.next();
			if(klondikeCard.isHidden()){
				stringCards="["+stringCards;
			}else{
				stringCards="["+klondikeCard.getId()+"]"+stringCards;
			}
		}
		return stringCards;
	}
	
}
