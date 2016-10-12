package klondike.models;

public class CardsSuit extends CardsGroupStack{
	
	@Override
	public boolean canPutCard(KlondikeCard cardToPut) {
		
		if(this.size()==0){
			if(cardToPut.getNumber()==cardToPut.getFirstCardNumber()){
				return true;
			}
		}else{
			KlondikeCard actualCard = this.getNextCard();
			if(actualCard.areSameSuit(cardToPut) && cardToPut.getNumber()==actualCard.getNextAscendentCardNumber()){
				return true;
			}
		}
		return false;
		
	}

	@Override
	public CardsGroup initializeCardsGroup() {
		return new CardsSuit();
	}

}
