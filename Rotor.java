public class Rotor {
    private String rotorValues;
    private int position;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.position = rotorValues.indexOf(c);
    }

    /** Rotate rotor by one step */
    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        return (position == 0);  // Full rotation
    }

    /** Returns the adjusted index of a given character */
    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) return -1;
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    /** Returns the character at a given index, considering rotation */
    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }
}
