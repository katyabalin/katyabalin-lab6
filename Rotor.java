public class Rotor {
    
    private String rotorValues; // Stores the rotor sequence
    private final char startChar; // Tracks the initial character for full rotation detection

    /**
     * Constructor: Initializes a rotor with given sequence and starting character.
     * Rotates until the correct start character is at the top.
     */
    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startChar = c;

        // Rotate until the start character is at the top
        while (rotorValues.charAt(0) != startChar) {
            rotate();
        }
    }
    
    /**
     * Rotates the rotor one step clockwise.
     * Returns true if the rotor completes a full cycle back to its starting position.
     */
    public boolean rotate() {
        rotorValues = rotorValues.substring(1) + rotorValues.charAt(0);
        return rotorValues.charAt(0) == startChar; // Check if we reached the starting position
    }

    /**
     * Returns the index of a given character in the rotor sequence.
     */
    public int indexOf(char c) {
        return rotorValues.indexOf(c);
    }

    /**
     * Returns the character at the given index in the rotor sequence.
     */
    public char charAt(int idx) {
        return rotorValues.charAt(idx);
    }
}
