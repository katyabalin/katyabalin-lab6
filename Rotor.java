public class Rotor {

    private String rotorValues;
    private char startChar;
    private int position;

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
     * Finds the index of a given character in the rotor, adjusted for rotation.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) return -1;  // Character not found
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Returns the character at a given index, considering the rotor's rotation.
     */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }
}
