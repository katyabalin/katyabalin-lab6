public class Rotor {

    private String rotorValues;
    private int currentPosition;

    public Rotor(String v, char c){
        this.rotorValues = v;
        this.currentPosition = rotorValues.indexOf(c);
    }

    // Rotate the rotor one position clockwise
    public boolean rotate(){
        currentPosition = (currentPosition + 1) % rotorValues.length();
        return currentPosition == 0;  // Returns true if full rotation completed
    }

    // Get the index of a given character in the rotor
    public int indexOf(char c){
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1;  // Handle characters not found
        return (index - currentPosition + rotorValues.length()) % rotorValues.length();
    }

    // Get the character at a specific index in the rotor
    public char charAt(int idx){
        return rotorValues.charAt((idx + currentPosition) % rotorValues.length());
    }
}
