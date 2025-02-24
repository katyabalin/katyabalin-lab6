public class Rotor {
    private String rotorValues;
    private char startChar;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startChar = c;

        while (!this.rotate());
    }

    public boolean rotate() {
        boolean temp = false;
        if (charAt(0) == startChar) {
            temp = true;
        }
        this.rotorValues = rotorValues.substring(rotorValues.length() - 1) + rotorValues.substring(0, rotorValues.length() - 1);
        return temp;
    }

    public int indexOf(char c) {
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx) {
        return rotorValues.charAt(idx);
    }
}
