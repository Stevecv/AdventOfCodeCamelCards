public class CompiledHand {
    public int handType;
    public String compiledHand;
    public String normalisedHand;
    public int bet;

    public CompiledHand(String compiledHand) {
        String[] values = compiledHand.split(" ");
        handType = Integer.valueOf(values[0]);
        this.compiledHand = values[1];
        normalisedHand = values[3];
        bet = Integer.valueOf(values[2]);
    }
}
