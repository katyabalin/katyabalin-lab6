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
        return currentPosition == 0;  // Returns true if the rotor completes a full cycle
    }

    // Find the current index of a given character within the rotor, accounting for shifts
    public int indexOf(char c){
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1;
        return (index - currentPosition + rotorValues.length()) % rotorValues.length();
    }

    // Get the character at a specific index in the rotor, considering rotation shifts
    public char charAt(int idx){
        return rotorValues.charAt((idx + currentPosition) % rotorValues.length());
    }
}
