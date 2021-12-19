package formation;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * Program that creates the view of the game board.
 *
 * @author Gabard julien
 * @version 1.0
 * @since 19-12-2021
 */
public class GameView extends JFrame {

    private JPanel panelMain;
    private JLabel labelScore;
    private JPanel panelCards;

    public GameView(GameController gameController) {
        super();

        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelMain);
        setResizable(false);
        pack();

        centerWindow(this);

        /*
        This part is used to create the card list in the view
         */
        Game game = new Game();
        Game.RandomIterator randomIterator = game.randomIterator();

        while (randomIterator.hasNext()) {

            JCard card = randomIterator.next();

            card.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/pictureCard/dos-rouge.png"))));

            card.addMouseListener(gameController);

            panelCards.add(card);
        }
    }

    /**
     * Modified the label that displays the score
     *
     * @param score The integer number score
     */
    public void setScore(int score) {
        String scoreText;

        if (score > 1 || score < -1) {
            scoreText = " Points";
        } else {
            scoreText = " Point";
        }

        labelScore.setText(score + scoreText);
    }

    /**
     * Center the application in the middle of the screen
     *
     * @param frame A frame is a top-level
     */
    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); // Get the screen size
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

        frame.setLocation(x, y);
    }
}
