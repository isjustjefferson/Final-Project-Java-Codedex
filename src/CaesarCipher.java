import java.util.Arrays;

public class CaesarCipher {
    
    private static final char[] alphabet = {
        'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 
        'Y', 'Z'
    };
    private char[] alphabetDisplaced;

    public void startCodify(String message, int displacement) {
        displaceAlphabet(displacement);
        applyCaesarCipher(message);
    }

    private void displaceAlphabet(int displacement) {
        int modDisplacement = displacement % 26;

        char[] alphabetAfterDislpacedLetter = Arrays.copyOfRange(alphabet, modDisplacement, alphabet.length);
        char[] alphabetBeforeDisplacedLetter = Arrays.copyOfRange(alphabet, 0, modDisplacement);

        char[] tempAlphabetDisplaced = new char[alphabet.length];

        System.arraycopy(alphabetAfterDislpacedLetter, 0, tempAlphabetDisplaced, 0, alphabetAfterDislpacedLetter.length);
        System.arraycopy(alphabetBeforeDisplacedLetter, 0, tempAlphabetDisplaced, alphabetAfterDislpacedLetter.length, alphabetBeforeDisplacedLetter.length);
        
        setAlphabetDisplaced(tempAlphabetDisplaced);
    }

    private void applyCaesarCipher(String message) {
        StringBuilder newMessage = new StringBuilder();
        message = message.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            char currentLetter = message.charAt(i);

            if (currentLetter == ' ') {
                newMessage.append(' ');
            } else {
                int indexLetter = findIndex(currentLetter);
                
                if (indexLetter != -1) {
                    char newLetter = this.alphabetDisplaced[indexLetter];
                    newMessage.append(newLetter);
                } else {
                    newMessage.append(currentLetter);
                }
            }
        }
        System.out.println("Mensagem Codificada: " + newMessage.toString());
    }

    private int findIndex(char target) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == target) {
                return i;
            }
        }
        return -1; 
    }

    private void setAlphabetDisplaced(char[] alphabetDisplaced) {
        this.alphabetDisplaced = alphabetDisplaced;
    }
}