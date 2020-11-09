import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {
  JTextField userGuess;
  JButton guessButton;
  JButton playAgainButton;
  JLabel enterGuess;
  JLabel highLow;
  JLabel lastGuess;
  Random r = new Random();
  int randomNum = r.nextInt(100)+1;


GuessingGame() {
  
  JFrame frame = new JFrame("Guessing Game");
  frame.setLayout(new FlowLayout());
  frame.setSize(240, 120);

  userGuess = new JTextField(10);
  userGuess.setActionCommand("myTF");

  guessButton = new JButton("Guess");
  playAgainButton = new JButton("Play Again");

  guessButton.addActionListener(this);
  playAgainButton.addActionListener(this);

  enterGuess = new JLabel("Enter your guess: ");
  highLow = new JLabel("");
  lastGuess = new JLabel("");

  frame.add(enterGuess);
  frame.add(userGuess);
  frame.add(guessButton);
  frame.add(highLow);
  frame.add(lastGuess);
  frame.add(playAgainButton);

  frame.setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
  if(ae.getActionCommand().equals("Guess")) {
    int guess = Integer.parseInt(userGuess.getText());
    lastGuess.setText("Last Guess: "+guess);

    if(guess == randomNum) {
      highLow.setText("You got it! ");
    }
    else if(guess > randomNum) {
      highLow.setText("Too high! ");
    }
    else {
      highLow.setText("Too low! ");
    }
  }
    
  else if(ae.getActionCommand().equals("Play Again")) {
    randomNum = r.nextInt(100)+1;
  
    enterGuess.setText("Enter your guess: ");
    highLow.setText("");
    lastGuess.setText("");
    userGuess.setText("");
    }

  else {
    highLow.setText("Your pressed Enter. Please press the Guess Button");
    }
}
}