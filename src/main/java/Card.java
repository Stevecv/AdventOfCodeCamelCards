public class Card {
    public Character card;
    public int value;
    public char alphaValue;

    public Card(Character card) {
        this.card = card;
        this.value = getValue();
        this.alphaValue = getValueAlpha();
    }

    private Integer getValue() {
        switch (card) {
            case '2', '3', '4', '5', '6', '7', '8', '9':
                return Integer.valueOf(card);
            case 'T':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            default:
                return 0;
        }
    }

    private char getValueAlpha() {
        switch (card) {
            case '2':
                return 'A';
            case '3':
                return 'B';
            case '4':
                return 'C';
            case '5':
                return 'D';
            case '6':
                return 'E';
            case '7':
                return 'F';
            case '8':
                return 'G';
            case '9':
                return 'H';
            case 'T':
                return 'I';
            case 'J':
                return 'J';
            case 'Q':
                return 'K';
            case 'K':
                return 'L';
            case 'A':
                return 'M';
            default:
                return 0;
        }
    }
}
