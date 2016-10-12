package klondike.models;

public class CardsStair extends CardsGroupStack{

	@Override
	public boolean canPutCard(KlondikeCard card) {
		
		if(this.size()==0){
			if(card.getNumber()==card.getLastCardNumber()){
				return true;
			}
		}else{
			KlondikeCard actualCard = this.getNextCard();
			if(!actualCard.isHidden()&&actualCard.areComplementarySuits(card) && card.getNumber()==actualCard.getNextDescendentCardNumber()){
				return true;
			}
		}
		return false;
	}

	@Override
	public CardsGroup initializeCardsGroup() {
		return new CardsStair();
	}

}
