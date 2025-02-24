public class Rotor {
    private String rotorValues;
    private int currentPosition;
    private int startPosition;

    public Rotor(String v, char c) {
        this.rotorValues = v;
        this.startPosition = v.indexOf(c);
        this.currentPosition = this.startPosition;

        System.out.println("🚀 Rotor Initialized: " + rotorValues + " Start Position: " + c + " (Index: " + this.startPosition + ")");
    }

    public boolean rotate() {
        currentPosition = (currentPosition + 1) % rotorValues.length();
        boolean completedCycle = (currentPosition == startPosition); // Returns true if full cycle completed
        System.out.println("🔄 Rotor Stepped to Position: " + currentPosition + " (Completed Cycle: " + completedCycle + ")");
        return completedCycle;
    }

    public int indexOf(char c) {
        int index = rotorValues.indexOf(c);
        if (index == -1) return -1; // If character is not found, return -1
        return (index - currentPosition + rotorValues.length()) % rotorValues.length();
    }

    public char charAt(int idx) {
        return rotorValues.charAt((idx + currentPosition) % rotorValues.length());
    }
}
