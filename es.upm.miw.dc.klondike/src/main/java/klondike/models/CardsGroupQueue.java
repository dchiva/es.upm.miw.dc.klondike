package klondike.models;

public abstract class CardsGroupQueue extends CardsGroup{
	
	@Override
	public boolean add(KlondikeCard c) {
		if(this.canPutCard(c)){
			this.getCards().addLast(c);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean forceAdd(KlondikeCard c) {
		this.getCards().addLast(c);
		return true;
	}

}
