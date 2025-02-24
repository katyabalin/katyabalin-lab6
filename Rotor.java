public class Rotor {

    private String rotorValues;
    private char startChar;
    private int currentPosition;

    public Rotor(String v, char c){
        this.rotorValues = v;
        this.startChar = c;
        this.currentPosition = rotorValues.indexOf(c);
    }

    // Rotate the rotor one position clockwise
    public boolean rotate(){
        currentPosition = (currentPosition + 1) % rotorValues.length();
        return rotorValues.charAt(currentPosition) == startChar;
    }

    // Get the index of a given character in the rotor
    public int indexOf(char c){
        return rotorValues.indexOf(c);
    }

    // Get the character at a specific index in the rotor
    public char charAt(int idx){
        return rotorValues.charAt((idx + currentPosition) % rotorValues.length());
    }
}
