package klondike.models;

public class Discard extends CardsGroupQueue{

	@Override
	public boolean canPutCard(KlondikeCard c) {
		if(this.size()<3){
			return true;
		}
		return false;
	}

	@Override
	public CardsGroup initializeCardsGroup() {
		return new Discard();
	}

}
