import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lab1_Tester {

    @Test
    public void test1() {
        Enigma enigma = new Enigma("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   "ZYXWVUTSRQPONMLKJIHGFEDCBA",
                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   'A', 'A', 'A');
        String encrypted = enigma.encrypt("NDU");
        System.out.println("Encrypted: " + encrypted);
        assertEquals("Expected: NDU", "NDU", encrypted);
    }

    @Test
    public void test2() {
        Enigma enigma = new Enigma("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   "ZYXWVUTSRQPONMLKJIHGFEDCBA",
                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   'A', 'A', 'A');
        String encrypted = enigma.encrypt("ACAAFAEOZFWKBQKPXZOGIKXTNPEBDXWQCZ");
        System.out.println("Encrypted: " + encrypted);
        assertEquals("Expected: ACAAFAEOZFWKBQKPXZOGIKXTNPEBDXWQCZ", "ACAAFAEOZFWKBQKPXZOGIKXTNPEBDXWQCZ", encrypted);
    }

    @Test
    public void test3() {
        Enigma enigma = new Enigma("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   "ZYXWVUTSRQPONMLKJIHGFEDCBA",
                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   'A', 'A', 'A');
        String encrypted = enigma.encrypt("CSHIAWDFGDCOE#EZKJHRWAZDDCBCILON#PKUJEXEXSHINZ");
        System.out.println("Encrypted: " + encrypted);
        assertEquals("Expected: CSHIAWDFGDCOE#EZKJHRWAZDDCBCILON#PKUJEXEXSHINZ", 
                     "CSHIAWDFGDCOE#EZKJHRWAZDDCBCILON#PKUJEXEXSHINZ", encrypted);
    }

    @Test
    public void test4() {
        Enigma enigma = new Enigma("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   "ZYXWVUTSRQPONMLKJIHGFEDCBA",
                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                                   'A', 'A', 'A');
        String encrypted = enigma.encrypt("MUWWXBWRWVMAXBOD#OWYYZDYTYXQEAYVPDS");
        System.out.println("Encrypted: " + encrypted);
        assertEquals("Expected: MUWWXBWRWVMAXBOD#OWYYZDYTYXQEAYVPDS", "MUWWXBWRWVMAXBOD#OWYYZDYTYXQEAYVPDS", encrypted);
    }

}
