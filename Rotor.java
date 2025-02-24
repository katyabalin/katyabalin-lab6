public class Rotor {

    private String rotorValues;
    private char startChar;
    private int position;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startChar = c;
        this.position = rotorValues.indexOf(startChar);
    }

    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        return rotorValues.charAt(position) == startChar;
    }

    public int indexOf(char c) {
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1; 
        return (index - position + rotorValues.length()) % rotorValues.length();
    }

    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }
}
