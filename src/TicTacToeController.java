import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author Aaron Bungay
 *
 */
public class TicTacToeController implements ActionListener
{
	private TicTacToeModel model;
	
	/**
	 * Constructor for the tic tac toe controller.
	 */
	public TicTacToeController(TicTacToeModel model)
	{
		this.model = model;
	}

	/**
	 * Handler method for grid button press on view.
	 */
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		JButton srcButton = (JButton) ae.getSource();
		srcButton.setEnabled(false);
		
		String args[] = srcButton.getActionCommand().split(",");
		int x = Integer.parseInt(args[0]);
		int y = Integer.parseInt(args[1]);
		
		model.play(x, y);
	}
}
