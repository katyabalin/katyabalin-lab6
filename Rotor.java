public class Rotor {

    private String rotorValues;
    private int currentPosition;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.currentPosition = rotorValues.indexOf(c);
    }

    public boolean rotate() {
        currentPosition = (currentPosition + 1) % rotorValues.length();
        return currentPosition == 0; // Returns true if it completes a full cycle
    }

    public int indexOf(char c) {
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1;
        return (index - currentPosition + rotorValues.length()) % rotorValues.length();
    }

    public char charAt(int idx) {
        return rotorValues.charAt((idx + currentPosition) % rotorValues.length());
    }
}
