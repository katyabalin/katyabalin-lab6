public class Enigma {

    private final String[] rotorInit = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor[] rotors;

    public Enigma(int id1, int id2, int id3, String start) {
        System.out.println("\n[Initializing Enigma]");
        System.out.println("Selected Rotors: " + id1 + ", " + id2 + ", " + id3);
        System.out.println("Start Positions: " + start);

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));
    }

    /** Encrypts the given message */
    public String encrypt(String message) {
        System.out.println("\n[Encrypting Message] Input: " + message);
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            System.out.println("\nEncrypting: " + c);

            int index1 = rotors[0].indexOf(c);
            if (index1 == -1) {
                System.out.println("Error: Character '" + c + "' not found in rotor.");
                continue;
            }
            char step1 = rotors[1].charAt(index1);
            int index2 = rotors[1].indexOf(step1);
            char step2 = rotors[2].charAt(index2);

            System.out.println("Step 1: " + c + " -> "
