package engine;
import players.MyComputerPlayer;

public class Game {
	Board board;
	TileGenerator tg;
	Player p;
	
	public Game() {
		this.board = new Board();
		this.tg = new TileGenerator();
		this.p = new MyComputerPlayer(this);
	}

	public static void main(String[] args) {
		Game g = new Game();
		g.run();
	}
	
	public void run() {
		boolean full_board = false;
		boolean single_only = board.check_single_only();
		while(!full_board) {
			p.seek_move(tg.next_tile(board.max_value, single_only));
		}
	}
	
}
