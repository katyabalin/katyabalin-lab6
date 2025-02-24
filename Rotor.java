public class Rotor {

    private String rotorValues;
    private char startChar;
    private int position;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startChar = c;
        this.position = rotorValues.indexOf(startChar);
        System.out.println("Rotor initialized: " + rotorValues);
        System.out.println("Start position: " + startChar + " at index " + position);
    }

    /**
     * Rotates the rotor one step clockwise.
     * Returns true if the rotor completes a full cycle back to the start position.
     */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        boolean fullRotation = (rotorValues.charAt(position) == startChar);
        System.out.println("Rotor rotated: New position " + rotorValues.charAt(position) + " | Full rotation: " + fullRotation);
        return fullRotation;
    }

    /**
     * Finds the index of a given character in the rotated rotor.
     */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) {
            System.out.println("Error: Character " + c + " not found in rotor!");
            return -1;
        }
        int adjustedIndex = (originalIndex - position + rotorValues.length()) % rotorValues.length();
        System.out.println("indexOf: " + c + " is at " + originalIndex + ", adjusted for rotation: " + adjustedIndex);
        return adjustedIndex;
    }

    /**
     * Returns the character at a given index, considering the rotor's rotation.
     */
    public char charAt(int idx) {
        char result = rotorValues.charAt((idx + position) % rotorValues.length());
        System.out.println("charAt: Index " + idx + " maps to " + result);
        return result;
    }
}
