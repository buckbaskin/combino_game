package engine;

public class Board {
	int[][] map;
	int max_value = -1;
	boolean valid;
	public Board() {
		this(new int[5][5], null, 0, 0);
	}
	public Board(int[][] old_map, Tile tile, int x, int y) {
		this.map = old_map;
		this.valid = this.update_map(tile, x, y);
		if (tile == null) {
			if (max_value == -1) {
				max_value = 2;
			}
		} else if (tile instanceof DoubleTile) {
			if (((DoubleTile) tile).sideA > max_value) {
				max_value = ((DoubleTile) tile).sideA;
			}
			if (((DoubleTile) tile).sideB > max_value) {
				max_value = ((DoubleTile) tile).sideB;
			}
		} else if (tile instanceof SingleTile) {
			if (((SingleTile) tile).sideA > max_value) {
				max_value = ((SingleTile) tile).sideA;
			}
		}
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
	public boolean check_single_only() {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (x < 4 && map[x][y] == 0 && map[x+1][y] == 0) {
					return false;
				} else if (y < 4 && map[x][y] == 0 && map[x][y+1] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public void simplify_map_single(int last_x, int last_y) {
		// combine pieces from low to high in value
		// start from the most recently placed x, y, do a BFS, looking for connected pieces
		// call recursively if there is a piece created
		int check_value = map[last_x][last_y];
	}
	public void simplify_map_double(int x1, int y1, int x2, int y2) {
		// if a double piece was placed, call it twice, starting with the lower value
		// need to separately track the next most valuable piece
	}
}
