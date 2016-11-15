import java.util.EventObject;

/**
 * 
 * @author Aaron Bungay
 *
 */
public class TicTacToeEvent extends EventObject
{
	private Player currentPlayer;
	private boolean isGameWon;

	private int x;
	private int y;
	
	/**
	 * 
	 * 
	 * @param source
	 * @param currentPlayer
	 * @param x
	 * @param y
	 */
	public TicTacToeEvent(Object source, Player currentPlayer, boolean gameWon, int x, int y)
	{
		super(source);
		this.currentPlayer = currentPlayer;
		this.isGameWon = gameWon;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @return
	 */
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isGameWon()
	{
		return isGameWon;
	}

	/**
	 * 
	 * @return
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * 
	 * @return
	 */
	public int getY()
	{
		return y;
	}

}
