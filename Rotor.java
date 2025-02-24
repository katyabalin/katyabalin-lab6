public class Rotor {
    private String mapping;
    private int offset;

    /**
     * Constructs a rotor with the given mapping and starting position.
     * @param mapping The rotor's character mapping.
     * @param start The starting character.
     */
    public Rotor(String mapping, char start) {
        this.mapping = mapping;
        this.offset = mapping.indexOf(start);
    }

    /**
     * Finds the index of a character in the rotor's mapping.
     * @param c The character to look for.
     * @return The index of the character.
     */
    public int indexOf(char c) {
        int index = mapping.indexOf(c);
        if (index == -1) return 0;  // Default case if not found
        return (index + offset) % mapping.length();
    }

    /**
     * Gets the character at a given index in the rotor's mapping.
     * @param index The index.
     * @return The character at the index.
     */
    public char charAt(int index) {
        return mapping.charAt((index - offset + mapping.length()) % mapping.length());
    }

    /**
     * Rotates the rotor forward by one position.
     * @return True if a full rotation was completed.
     */
    public boolean rotate() {
        offset = (offset + 1) % mapping.length();
        return offset == 0; // Return true if full rotation happened
    }

    /**
     * Debugging method to print current rotor state.
     */
    public void printRotorState() {
        System.out.println("Rotor mapping: " + mapping);
        System.out.println("Rotor offset: " + offset);
    }
}
