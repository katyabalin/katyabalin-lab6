public class Rotor {

    private String rotorValues;
    private int currentPosition;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.currentPosition = rotorValues.indexOf(c);
        System.out.printf("🚀 Rotor Initialized: '%s' Start Position: '%c' (Index: %d)\n", v, c, currentPosition);
    }

    public boolean rotate() {
        currentPosition = (currentPosition + 1) % rotorValues.length();
        System.out.printf("🔄 Rotor Stepped to Position: %d (%c)\n", currentPosition, rotorValues.charAt(currentPosition));
        return currentPosition == 0;
    }

    public int indexOf(char c) {
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1;
        int adjustedIndex = (index - currentPosition + rotorValues.length()) % rotorValues.length();
        return adjustedIndex;
    }

    public char charAt(int idx) {
        return rotorValues.charAt((idx + currentPosition) % rotorValues.length());
    }
}
