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
        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3 - 1], start.charAt(2));
    }

    /** Encrypts the given message */
    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index1 = rotors[0].indexOf(c);
            if (index1 == -1) continue; // Skip unrecognized characters

            char step1 = rotors[1].charAt(index1);
            int index2 = rotors[1].indexOf(step1);
            char step2 = rotors[2].charAt(index2);

            result.append(step2);
            rotate();
        }
        return result.toString();
    }

    /** Decrypts the given message */
    public String decrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            int index2 = rotors[2].indexOf(c);
            if (index2 == -1) continue; // Skip unrecognized characters

            char step2 = rotors[1].charAt(index2);
            int index1 = rotors[1].indexOf(step2);
            char step1 = rotors[0].charAt(index1);

            result.append(step1);
            rotate();
        }
        return result.toString();
    }

    /** Rotates the rotors */
    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}
