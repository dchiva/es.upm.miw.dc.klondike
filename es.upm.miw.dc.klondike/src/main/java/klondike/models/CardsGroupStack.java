package klondike.models;

public abstract class CardsGroupStack extends CardsGroup{

	@Override
	public boolean add(KlondikeCard c) {
		if(this.canPutCard(c)){
			this.getCards().addFirst(c);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean forceAdd(KlondikeCard c) {
		this.getCards().addFirst(c);
		return true;
	}
	
}
