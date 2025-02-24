public class Rotor {

    private String rotorValues;
    private int currentPosition;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.currentPosition = rotorValues.indexOf(c);
        System.out.printf("🚀 Rotor Initialized: '%s' Start Position: '%c' (Index: %d)\n", v, c, currentPosition);
    }

    public boolean rotate() {
        currentPosition = (currentPosition + 1) % rotorValues.length();
        System.out.printf("🔄 Rotor Stepped to Position: %d\n", currentPosition);
        return currentPosition == 0;
    }

    public int indexOf(char c) {
        int index = rotorValues.indexOf(c);
        if (index == -1) {
            System.out.println("❌ Character '" + c + "' not found in rotor.");
            return -1;
        }
        int adjustedIndex = (index - currentPosition + rotorValues.length()) % rotorValues.length();
        return adjustedIndex;
    }

    public char charAt(int idx) {
        char result = rotorValues.charAt((idx + currentPosition) % rotorValues.length());
        return result;
    }
}
