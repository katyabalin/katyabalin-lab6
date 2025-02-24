public class Rotor {
    private String mapping;
    private int offset;

    public Rotor(String mapping, char start) {
        this.mapping = mapping;
        this.offset = mapping.indexOf(start);
    }

    public int indexOf(char c) {
        int index = mapping.indexOf(c);
        return (index == -1) ? 0 : (index + offset) % mapping.length();
    }

    public char charAt(int index) {
        return mapping.charAt((index - offset + mapping.length()) % mapping.length());
    }

    public boolean rotate() {
        System.out.println("🔄 Rotating rotor from offset: " + offset);
        offset = (offset + 1) % mapping.length();
        System.out.println("   New offset: " + offset);
        return offset == 0;
    }
}
