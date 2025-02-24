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
     * This ensures the lookup is adjusted for the rotor’s rotation.
     */
    public int indexOf(char c) {
        int actualIndex = rotorValues.indexOf(c);
        if (actualIndex == -1) return -1;  // Character not found
        return (actualIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Returns the character at a given index, considering the rotor's rotation.
     */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }

    /**
     * Returns the character currently on top of the rotor.
     */
    public char currentChar() {
        return rotorValues.charAt(position);
    }
}
