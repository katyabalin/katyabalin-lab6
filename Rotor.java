public class Rotor {

    private String rotorValues;
    private char startChar;
    private int position;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        this.position = rotorValues.indexOf(startChar);
    }

    public boolean rotate(){
        position = (position + 1) % rotorValues.length();
        return rotorValues.charAt(position) == startChar;
    }

    public int indexOf(char c){
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1;  // Handle case where character is not found
        return (index - position + rotorValues.length()) % rotorValues.length();
    }

    public char charAt(int idx){
        return rotorValues.charAt((idx + position) % rotorValues.length());
    }

    // ✅ Fix: Added this method to get the current top character
    public char currentChar() {
        return rotorValues.charAt(position);
    }
}
