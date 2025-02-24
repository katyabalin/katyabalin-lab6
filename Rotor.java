public class Rotor {

    private String rotorValues;
    private int position;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.position = rotorValues.indexOf(c);
    }

    public boolean rotate() {
        position = (position + 1) % rotorValues.length();
        return position == 0;
    }

    public int indexOf(char c) {
        int originalIndex = rotorValues.indexOf(c);
        if (originalIndex == -1) {
            throw new IllegalArgumentException("Character not found in rotor: " + c);
        }
        return (originalIndex - position + rotorValues.length()) % rotorValues.length();
    }

    public char charAt(int idx) {
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }

    public void printRotorState() {
        System.out.println("Rotor Position: " + position + " | Current Char: " + rotorValues.charAt(position));
    }
}
