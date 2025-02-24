public class Rotor {
    private String rotorValues;
    private int position; // Current rotor position

    public Rotor(String mapping, char startPosition) {
        this.rotorValues = mapping;
        this.position = rotorValues.indexOf(startPosition);
    }

    /**
     * Rotates the rotor by one position.
     * @return true if a full cycle is completed (i.e., it returns to the original position)
     */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        boolean fullRotation = (position == 0);
        System.out.println("Rotor rotated: New position " + rotorValues.charAt(position) + " | Full rotation: " + fullRotation);
        return fullRotation;
    }

    /**
     * Finds the index of a character in the rotor, adjusted for the rotor's current position.
     * @param c Character to look up.
     * @return Adjusted index within the rotor.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) return -1;  // Character not found
        int adjustedIndex = (originalIndex - position + rotorValues.length()) % rotorValues.length();
        
        System.out.println("indexOf: " + c + " is at " + originalIndex + ", adjusted for rotation: " + adjustedIndex);
        return adjustedIndex;
    }

    /**
     * Retrieves the character at the given adjusted index, considering the rotor's current position.
     * @param idx Index within the rotor.
     * @return Mapped character.
     */
    public char charAt(int idx) {
        int adjustedIndex = (idx + position) % rotorValues.length();
        char mappedChar = rotorValues.charAt(adjustedIndex);
        
        System.out.println("charAt: Index " + idx + " maps to " + mappedChar);
        return mappedChar;
    }

    /**
     * Prints the current rotor position for debugging.
     */
    public void printRotorState() {
        System.out.println("Rotor Position: " + position + " | Current Char: " + rotorValues.charAt(position));
    }
}
