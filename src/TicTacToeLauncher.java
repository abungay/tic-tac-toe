
/**
 * 
 * @author Aaron Bungay
 *
 */
public class TicTacToeLauncher
{

	/**
	 * Initialize the dependencies between Model, View, and Controller classes,
	 * and launch the tic tac toe game.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		TicTacToeModel model = new TicTacToeModel();
		TicTacToeController controller = new TicTacToeController(model);
		TicTacToeView view = new TicTacToeView(controller);
		model.addObserver(view);
	}

}
