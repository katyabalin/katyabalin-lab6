public class Rotor {

    private String rotorValues;  // The rotor character sequence
    private char startChar;  // The initial starting character
    private int position;  // Current rotation position

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startChar = c;
        this.position = rotorValues.indexOf(startChar);
    }

    /**
     * Rotates the rotor one step clockwise.
     * Returns true if the rotor completes a full cycle back to the start position.
     */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        return rotorValues.charAt(position) == startChar;
    }

    /**
     * Finds the index of a given character in the rotated rotor.
     */
    public int indexOf(char c) {
        int adjustedIndex = rotorValues.indexOf(c);
        if (adjustedIndex == -1) return -1;
        return (adjustedIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Returns the character at a given index, considering the rotor's rotation.
     */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }
}
