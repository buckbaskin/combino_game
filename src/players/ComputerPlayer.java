package players;

import engine.Game;
import engine.Player;
import engine.Tile;

public abstract class ComputerPlayer extends Player {

	public ComputerPlayer(Game g) {
		super(g);
	}

	@Override
	public abstract int[] seek_move(Tile t);
}
