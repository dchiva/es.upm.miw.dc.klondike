package klondike.models;

public class Game {

	private Board board;
	private State state;
	private Options selectedOption;
	private static final int NUMBER_OF_DISCARDS=2;
	public Game(){
		this.state=State.INITIAL;
		this.board=new Board();
		this.selectedOption=null;
	}
	
	public State getState(){
		return this.state;
	}
	
	public void setState(State state){
		this.state=state;
	}
	
	public void setOption(Options option){
		this.selectedOption=option;
	}
	
	public Options getOption(){
		return this.selectedOption;
	}
	
	public void buildBoard(DeckFactory deckFactory){
		this.board.build(deckFactory);
	}

	public void discardToDeckMove() {
		this.board.discardToDeckMove();
	}
	
	public void deckToDiscardsMove(){
		this.board.deckToDiscardsMove(NUMBER_OF_DISCARDS);
	}

	public String boardToString() {
		return this.board.toString();
	}

	public boolean discardToStairMove(int stair) {
		return this.board.discardToStairMove(stair);
	}

	public boolean discardToSuitMove() {
		return this.board.discardToSuitMove();
	}

	public boolean stairToStairMove(int originStair, int destinationStair, int cardsNumber) {
		return this.board.stairToStairMove(originStair,destinationStair, cardsNumber);
	}

	public boolean stairToSuitMove(int stair) {
		return this.board.stairToSuitMove(stair);
	}

	public boolean flipStairCard(int stair) {
		return this.board.flipStairCard(stair);
	}

	public boolean suitToStairMove(String suit, int stair) {
		return this.board.suitToStairMove(suit, stair);
	}
}
