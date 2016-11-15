import java.util.Observable;

/**
 * 
 * @author Aaron Bungay
 *
 */
public class TicTacToeModel extends Observable
{
	private static final int GRID_SIZE = 3;
	
	private Player[][] plays;
	private Player currentTurn = Player.X;
	
	/**
	 * Constructor for the tic tac toe model.
	 */
	public TicTacToeModel()
	{
		plays = new Player[GRID_SIZE][GRID_SIZE];
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void play(int x, int y)
	{
		plays[x][y] = currentTurn;
		setChanged();
		notifyObservers(new TicTacToeEvent(this, currentTurn, isGameWon(x, y), x, y));
		switchTurns();
	}
	
	/**
	 * 
	 */
	private void switchTurns()
	{
		if (currentTurn.equals(Player.X))
		{
			currentTurn = Player.O;
		}
		else
		{
			currentTurn = Player.X;
		}
	}
	
	/**
	 * Determines if the game was won from a given x,y play.
	 * Works for any tic tac toe grid size.
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isGameWon(int x, int y)
	{
		boolean horizontalLine = true;
		
		for (int i = 0; i < GRID_SIZE; i++)
		{
			if (plays[i][y] != currentTurn)
			{
				horizontalLine = false;
				break;
			}
		}
		
		if (horizontalLine) return true;
		
		boolean verticalLine = true;
		
		for (int j = 0; j < GRID_SIZE; j++)
		{
			if (plays[x][j] != currentTurn)
			{
				verticalLine = false;
				break;
			}
		}
		
		if (verticalLine) return true;
		
		if (x == y)
		{
			boolean downwardDiagonalLine = true;
			
			for (int ij = 0; ij < GRID_SIZE; ij++)
			{
				if (plays[ij][ij] != currentTurn)
				{
					downwardDiagonalLine = false;
					break;
				}
			}
			
			if (downwardDiagonalLine) return true;
		}
		else if (x == GRID_SIZE - 1 - y)
		{
			boolean upwardDiagonalLine = true;
			
			for (int i = 0, j = GRID_SIZE - 1 ; i < GRID_SIZE; i++, j--)
			{
				if (plays[i][j] != currentTurn)
				{
					upwardDiagonalLine = false;
					break;
				}
			}
			
			return upwardDiagonalLine;
		}
		
		return false;
	}
}
