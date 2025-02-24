public class Enigma {
    private static final String[] ROTOR_PATTERNS = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor[] rotors;

    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3];
        rotors[0] = new Rotor(ROTOR_PATTERNS[id1 - 1], start.charAt(0));
        rotors[1] = new Rotor(ROTOR_PATTERNS[id2 - 1], start.charAt(1));
        rotors[2] = new Rotor(ROTOR_PATTERNS[id3 - 1], start.charAt(2));
    }

    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c != '#' && (c < 'A' || c > 'Z')) {
                result.append(c); 
                continue;
            }
            int index = rotors[0].indexOf(c);
            char step1 = rotors[1].charAt(index);
            int index2 = rotors[1].indexOf(step1);
            char step2 = rotors[2].charAt(index2);
            int index3 = rotors[2].indexOf(step2);
            char step3 = rotors[2].charAt(index3);
            result.append(step3);
            rotate();
        }
        return result.toString();
    }

    public String decrypt(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c != '#' && (c < 'A' || c > 'Z')) {
                result.append(c); 
                continue;
            }
            int index3 = rotors[2].indexOf(c);
            char step3 = rotors[2].charAt(index3);
            int index2 = rotors[1].indexOf(step3);
            char step2 = rotors[1].charAt(index2);
            int index1 = rotors[0].indexOf(step2);
            char step1 = rotors[0].charAt(index1);
            result.append(step1);
            rotate();
        }
        return result.toString();
    }

    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}
