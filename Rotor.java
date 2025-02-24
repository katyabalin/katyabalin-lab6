public class Rotor {
    
    private String rotorValues;
    private int position;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.position = rotorValues.indexOf(c);
    }

    /**
     * Rotates the rotor one step forward.
     * @return true if a full rotation happened (for cascading effect).
     */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        return position == 0;
    }

    /**
     * Finds the index of a given character in the rotor's mapping.
     * Adjusts for rotation.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) {
            throw new IllegalArgumentException("Character not found in rotor: " + c);
        }
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Gets the character at a given index, adjusted for rotation.
     */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }

    /**
     * Debug: Prints rotor state.
     */
    public void printRotorState() {
        System.out.println("Rotor Position: " + position + " | Current Char: " + rotorValues.charAt(position));
    }
}
