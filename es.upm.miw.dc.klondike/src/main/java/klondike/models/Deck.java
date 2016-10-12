package klondike.models;

public class Deck extends CardsGroupQueue{
	
	@Override
	public boolean canPutCard(KlondikeCard c) {
		return true;
	}

	@Override
	public CardsGroup initializeCardsGroup() {
		return new Deck();
	}

}
