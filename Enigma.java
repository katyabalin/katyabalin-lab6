public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            char step1 = rotors[2].charAt(rotors[2].indexOf(c));
            char step2 = rotors[1].charAt(rotors[1].indexOf(step1));
            char step3 = rotors[0].charAt(rotors[0].indexOf(step2));
            result.append(step3);
            rotate();
        }
        return result.toString();
    }


    
    public String encrypt(String message){
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            char step1 = rotors[0].charAt(rotors[0].indexOf(c));
            char step2 = rotors[1].charAt(rotors[1].indexOf(step1));
            char step3 = rotors[2].charAt(rotors[2].indexOf(step2));
            result.append(step3);
            rotate();
        }
        return result.toString();
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
