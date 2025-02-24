public class Rotor {

    private String rotorValues;
    private int position; // Tracks the rotor's position within `rotorValues`
    
    public Rotor(String v, char c) {
        this.rotorValues = v; 
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
        return position == 0; // Return true if full rotation is completed
    }

    /**
     * Finds the index of a character in the rotor, adjusted for the rotor's current position.
     * @param c Character to find.
     * @return Adjusted index within the rotor.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) return -1; // Character not found
        
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /**
     * Retrieves the character at the given adjusted index, considering the rotor's current position.
     * @param idx Index within the rotor.
     * @return Mapped character.
     */
    public char charAt(int idx) {
        int adjustedIndex = (idx + position) % rotorValues.length();
        return rotorValues.charAt(adjustedIndex);
    }

    /**
     * Prints the current state of the rotor for debugging.
     */
    public void printRotorState() {
        System.out.println("Rotor Position: " + position + " | Current Char: " + rotorValues.charAt(position));
    }
}
