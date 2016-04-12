package engine;

public abstract class Player {
	Game g;
	public Player(Game g) {
		this.g = g;
	}
	public abstract int[] seek_move(Tile t);
}
