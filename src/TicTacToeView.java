import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A view with buttons for the tic tac toe game.
 * 
 * @author Aaron Bungay
 *
 */
public class TicTacToeView extends JFrame implements Observer
{	
	private static final String GAME_WIN_MSG = " won the tic tac toe game!";

	private static final long serialVersionUID = 4283567925948886520L;
	
	private static final int GRID_SIZE = 3;
	private static final int FRAME_HEIGHT = 400;
	private static final int FRAME_WIDTH = 400;
	private static final String FRAME_TITLE = "Tic Tac Toe";
	private static final Font BUTTON_GRID_FONT = new Font("Arial", Font.BOLD, 60);
	
	private TicTacToeController controller;
	private JButton[][] buttonGrid;

	/**
	 * Constructor for the tic tac toe view.
	 */
	public TicTacToeView(TicTacToeController controller)
	{
		super(FRAME_TITLE);
		this.controller = controller;
		this.buttonGrid = new JButton[GRID_SIZE][GRID_SIZE];
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setLocationRelativeTo(null);
		
		// fill grid with buttons
		for (int i = 0; i < GRID_SIZE; i++)
		{
			for (int j = 0; j < GRID_SIZE; j++)
			{
				JButton button = new JButton();
				button.setActionCommand(i + "," + j);
				button.addActionListener(controller);
				button.setFont(BUTTON_GRID_FONT);
				button.setFocusPainted(false);
				buttonGrid[i][j] = button;
				add(button);
			}
		}
		
		setVisible(true);
	}

	/**
	 * 
	 */
	@Override
	public void update(Observable obs, Object arg)
	{
		TicTacToeEvent ttte = (TicTacToeEvent) arg;
		buttonGrid[ttte.getX()][ttte.getY()].setText(ttte.getCurrentPlayer().name());
		
		if (ttte.isGameWon())
		{
			JOptionPane.showMessageDialog(this, ttte.getCurrentPlayer().name() + GAME_WIN_MSG);
			
			// disable all buttons after a win
			for (JButton[] b1 : buttonGrid)
			{
				for (JButton b2 : b1)
				{
					b2.setEnabled(false);
				}
			}
		}
	}
}
