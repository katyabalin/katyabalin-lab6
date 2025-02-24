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
        return (rotorValues.charAt(position) == startChar);
    }

    /**
     * Returns the **positionally shifted** index of a given character.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) return -1;  

        // FIXED: Ensure index lookup is adjusted based on rotation
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Returns the character at a given index, **accounting for rotation**.
     */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }
}
