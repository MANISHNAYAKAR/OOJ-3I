package braille;

import java.util.HashMap;

public class BrailleMap implements BrailleConverter {

    protected HashMap<Character, String> braille = new HashMap<>();

    public BrailleMap() {
        loadBraille();
    }

    private void loadBraille() {

        // Letters
        braille.put('a',"100000"); braille.put('b',"110000");
        braille.put('c',"100100"); braille.put('d',"100110");
        braille.put('e',"100010"); braille.put('f',"110100");
        braille.put('g',"110110"); braille.put('h',"110010");
        braille.put('i',"010100"); braille.put('j',"010110");

        braille.put('k',"101000"); braille.put('l',"111000");
        braille.put('m',"101100"); braille.put('n',"101110");
        braille.put('o',"101010"); braille.put('p',"111100");
        braille.put('q',"111110"); braille.put('r',"111010");
        braille.put('s',"011100"); braille.put('t',"011110");

        braille.put('u',"101001"); braille.put('v',"111001");
        braille.put('w',"010111"); braille.put('x',"101101");
        braille.put('y',"101111"); braille.put('z',"101011");

        // Number sign
        braille.put('#',"001111");

        // Numbers
        braille.put('1',"100000"); braille.put('2',"110000");
        braille.put('3',"100100"); braille.put('4',"100110");
        braille.put('5',"100010"); braille.put('6',"110100");
        braille.put('7',"110110"); braille.put('8',"110010");
        braille.put('9',"010100"); braille.put('0',"010110");

        // Space
        braille.put(' ',"000000");

        // Punctuation
        braille.put('.', "010011");
        braille.put(',', "010000");
        braille.put('!', "011010");
        braille.put('?', "011001");
        braille.put('-', "001001");
        braille.put(':', "010010");
        braille.put(';', "011000");
        braille.put('(', "011001");
        braille.put(')', "001011");
        braille.put('"', "010001");
        braille.put('\'', "001000");
        braille.put('/', "001100");
        braille.put('@', "001110");
        braille.put('=', "011011");
        braille.put('+', "011010");
        braille.put('*', "001010");
    }

    @Override
    public String convert(char ch) throws InvalidSymbolException {
        ch = Character.toLowerCase(ch);
        if (!braille.containsKey(ch)) {
            throw new InvalidSymbolException("Invalid symbol: " + ch);
        }
        return braille.get(ch);
    }
}
