public class Card {
    public Character card;
    public int value;
    public char hexValue;

    public Card(Character card) {
        this.card = card;
        this.value = getValue();
        this.hexValue = getValueHex();
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

        private char getValueHex() {
            switch (card) {
                case '2', '3', '4', '5', '6', '7', '8', '9':
                    return card;
                case 'T':
                    return 'A';
                case 'J':
                    return 'B';
                case 'Q':
                    return 'C';
                case 'K':
                    return 'D';
                default:
                    return 0;
            }
    }
}
