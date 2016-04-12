package engine;

import java.util.Random;

public class TileGenerator {
	Random r;
	public TileGenerator() {
		r = new Random();
	}
	public Tile next_tile(int max_value, boolean oneOnly) {
		// TODO(buckbaskin): make it randomly choose from all viable pieces
		// viable = up to and including the maximum value seen on the board
		return new SingleTile(1);
	}
}
