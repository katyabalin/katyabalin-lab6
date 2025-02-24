public class Rotor {
    
    private String rotorValues;
    private int position;
    private char startChar;

    /**
     * Constructs a Rotor with a given substitution pattern and starting character.
     * @param v The string representing the rotor mapping (length 27: A-Z + #).
     * @param c The starting character for the rotor.
     */
    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.position = rotorValues.indexOf(c); // Set initial position to where 'c' appears in the rotor
        this.startChar = c;
    }

    /**
     * Rotates the rotor one step forward (like an odometer).
     * @return true if a full rotation occurred (i.e., returned to original position).
     */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        return rotorValues.charAt(position) == startChar; // Returns true if full rotation happens
    }

    /**
     * Finds the index of a given character in the rotor's current configuration.
     * @param c The character to find.
     * @return The adjusted index based on the current rotor position.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) {
            throw new IllegalArgumentException("Character not found in rotor: " + c);
        }
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Gets the character at a given index, adjusted for rotor rotation.
     * @param idx The index to fetch from the rotor.
     * @return The corresponding character.
     */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }

    /**
     * Prints the current rotor state (for debugging).
     */
    public void printRotorState() {
        System.out.println("Rotor Position: " + position + " | Current Char: " + rotorValues.charAt(position));
    }
}
