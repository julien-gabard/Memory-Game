package formation;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Program that listens to mouse events on a map.
 *
 * @author Gabard Julien
 * @version 1.0
 * @since 19-12-2021
 */
public class GameController extends MouseAdapter {

    private final GameView gameView = new GameView(this);
    private final ArrayList<JCard> cardArrayList = new ArrayList<>();
    private final Timer timer;
    private int score = 0;

    /**
     * The class constructor is used to make the view visible and to initiate a timer.
     */
    public GameController() {
        gameView.setVisible(true);

        timer = new Timer(1000, e1 -> {
            for (JCard cardStore: cardArrayList) {
                cardStore.setDisplayed(false);
            }
            cardArrayList.clear();
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        JCard currentCard = (JCard) e.getSource();

        if (cardArrayList.size() < 2 && !currentCard.isDisplayed()) {

            if (timer.isRunning()) {
                timer.stop();
            }

            currentCard.setDisplayed(true);
            cardArrayList.add(currentCard);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        if (cardArrayList.size() == 2 && !timer.isRunning()) {

            if (cardArrayList.get(0).getCardValue() == cardArrayList.get(1).getCardValue()) {

                score += 2;
                cardArrayList.clear();

            } else {

                score--;
                timer.start();
            }

            gameView.setScore(score);
        }
    }
}