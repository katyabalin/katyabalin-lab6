public class Rotor {
    
    private String rotorValues;
    private int position; // Tracks the rotor's current position
    
    public Rotor(String v, char c) {
        this.rotorValues = v; // Store the rotor mapping
        this.position = v.indexOf(c); // Find the starting position
        
        // Rotate the rotor until it reaches the correct starting character
        while (!this.rotate());
    }
    
    /**
     * Rotates the rotor by one step.
     * @return true if the rotor completes a full cycle (back to initial position).
     */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        boolean fullRotation = (position == 0);
        System.out.println("[Rotor Rotation] New Position: " + position + " (" + rotorValues.charAt(position) + ")");
        return fullRotation;
    }

    /**
     * Finds the index of a character in the rotor, adjusted for the rotor's current position.
     * @param c Character to find.
     * @return Adjusted index within the rotor.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) return -1; // Character not found
        
        // Adjust index to consider the rotor's current position
        int adjustedIndex = (originalIndex - position + rotorValues.length()) % rotorValues.length();
        
        System.out.println("[IndexOf] Character: " + c + " | Original Index: " + originalIndex + " | Adjusted Index: " + adjustedIndex);
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
        
        System.out.println("[CharAt] Input Index: " + idx + " | Mapped Char: " + mappedChar);
        return mappedChar;
    }
}
