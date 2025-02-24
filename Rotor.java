public class Rotor {
    private String rotorConfig;
    private final char initialPosition;
    
    public Rotor(String rotorConfig, char initialPosition) {
        this.rotorConfig = rotorConfig;
        this.initialPosition = initialPosition;
        rotateTo(initialPosition);
    }

    /**
     * Rotates the rotor to its initial position.
     */
    private void rotateTo(char position) {
        while (rotorConfig.charAt(0) != position) {
            rotate();
        }
    }

    /**
     * Rotates the rotor one step clockwise.
     */
    public void rotate() {
        rotorConfig = rotorConfig.substring(1) + rotorConfig.charAt(0);
    }

    /**
     * Returns the index of a given character in the rotor.
     */
    public int getIndex(char c) {
        return rotorConfig.indexOf(c);
    }

    /**
     * Returns the character at a given index in the rotor.
     */
    public char getCharAt(int index) {
        return rotorConfig.charAt(index);
    }

    /**
     * Checks if the rotor has completed a full rotation.
     */
    public boolean hasCompletedFullRotation() {
        return rotorConfig.charAt(0) == initialPosition;
    }
}
