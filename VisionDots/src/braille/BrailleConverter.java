package braille;

public interface BrailleConverter {
    String convert(char ch) throws InvalidSymbolException;
}
