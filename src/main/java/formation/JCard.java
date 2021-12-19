package formation;

import javax.swing.*;
import java.util.Objects;

/**
 * Allows you to display a card with its color and value and with its image.
 *
 * @author Gabard Julien
 * @version 1.0
 * @since 19-12-2021
 */
public class JCard extends JLabel {

    private final CardValue cardValue;
    private final CardColor cardColor;
    private boolean displayed = false;

    /**
     * Class constructor is used to create a card with its color and value.
     *
     * @param cardValue the value of the card as a string
     * @param cardColor the color of the card as a string
     */
    public JCard(CardValue cardValue, CardColor cardColor) {
        this.cardValue = cardValue;
        this.cardColor = cardColor;
    }

    /**
     * An enumeration that contains the values of the cards.
     */
    public enum CardValue {
        deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi, as
    }

    /**
     * An enumeration that contains the colors of the cards.
     */
    public enum CardColor {
        carreau, coeur, pique, trefle
    }

    /**
     * This method makes it possible to have the value of the card.
     *
     * @return The value of the card as a string.
     */
    public CardValue getCardValue() {
        return cardValue;
    }

    /**
     * This method makes it possible to have the color of the card.
     *
     * @return The color of the card as a string.
     */
    public CardColor getCardColor() {
        return cardColor;
    }

    /**
     * This method allows you to see if the card is shown or hidden.
     *
     * @return the boolean of the card
     */
    public boolean isDisplayed() {
        return displayed;
    }

    /**
     * This method displays the map image face up or face down.
     *
     * @param displayed boolean true show card or false hide card
     */
    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;

        String pictureName;

        if (displayed) {
            pictureName = this.getCardColor() + "-" + this.getCardValue() + ".png";
        } else {
            pictureName = "dos-rouge.png";
        }

        setIcon(new ImageIcon(Objects.requireNonNull(JCard.class.getResource("/pictureCard/" + pictureName))));
    }
}
