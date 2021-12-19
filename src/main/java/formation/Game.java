package formation;

import java.util.ArrayList;

/**
 * Program that allows you to randomly create a deck of 52 cards.
 *
 * @author Gabard Julien
 * @version 1.0
 * @since 19-12-2021
 */
public class Game extends ArrayList<JCard> {

    /**
     * Class constructor to generate a card pack
     */
    public Game() {
        for (JCard.CardColor color: JCard.CardColor.values()) {

            for (JCard.CardValue value: JCard.CardValue.values()) {

                this.add(new JCard(value, color));
            }
        }
    }

    public RandomIterator randomIterator() {
        return new RandomIterator();
    }

    public static class RandomIterator {

        private final Game game = new Game();

        /**
         * Create a random index, which allows you to choose a card randomly in the card pack
         *
         * @return The next card : JCard
         */
        public JCard next() {
            int index = (int) (Math.random() * game.size());

            JCard jCard = game.get(index);
            game.remove(index);

            return jCard;
        }

        /**
         * See if the card deck still has cards
         *
         * @return true if the Game is contains elements. False if Game does not contain any more elements.
         */
        public boolean hasNext() {
            return game.size() > 0;
        }
    }
}
