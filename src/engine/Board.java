package engine;

public class Board {
	int[][] map;
	boolean valid;
	public Board() {
		this(new int[5][5], null, 0, 0);
	}
	public Board(int[][] old_map, Tile tile, int x, int y) {
		this.map = old_map;
		this.valid = this.update_map(tile, x, y);
	}
	
	public boolean update_map(Tile tile, int x, int y) {
		if (tile == null)
			return true;
		if (tile instanceof SingleTile) {
			if (map[x][y] == 0) {
				map[x][y] = ((SingleTile) tile).sideA;
				return true;
			}
			return false;
		} else if (tile instanceof DoubleTile) {
			if (x < 0 || x >= 5 || y < 0 || y >= 5) {
				return false;
			}
			if (map[x][y] == 0) {
				if (((DoubleTile) tile).orientation == 0) { // right
					if (x+1 >= 5) {
						return false;
					}
					if (map[x+1][y] == 0) {
						map[x][y] = ((DoubleTile) tile).sideA;
						map[x+1][y] = ((DoubleTile) tile).sideB;
						return true;
					}
				} else if (((DoubleTile) tile).orientation == 1) { // top
					if (y+1 >= 5) {
						return false;
					}
					if (map[x][y+1] == 0) {
						map[x][y] = ((DoubleTile) tile).sideA;
						map[x][y+1] = ((DoubleTile) tile).sideB;
						return true;
					}
				} else if (((DoubleTile) tile).orientation == 2) { // left
					if (x-1 < 0) {
						return false;
					}
					if (map[x-1][y] == 0) {
						map[x][y] = ((DoubleTile) tile).sideA;
						map[x-1][y] = ((DoubleTile) tile).sideB;
						return true;
					}
				} else if (((DoubleTile) tile).orientation == 3) { // right
					if (y-1 < 0) {
						return false;
					}
					if (map[x][y-1] == 0) {
						map[x][y] = ((DoubleTile) tile).sideA;
						map[x][y-1] = ((DoubleTile) tile).sideB;
						return true;
					}
				}
			}
		}
		return false;
	}
}
