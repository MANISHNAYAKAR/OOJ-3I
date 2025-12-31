package braille;

public class TextToBraille extends BrailleMap {

    public String convertText(String text) throws InvalidSymbolException {

        StringBuilder r1 = new StringBuilder();
        StringBuilder r2 = new StringBuilder();
        StringBuilder r3 = new StringBuilder();

        boolean numberMode = false;

        for (char ch : text.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                add("000001", r1, r2, r3); // capital sign
            }

            if (Character.isDigit(ch) && !numberMode) {
                add(braille.get('#'), r1, r2, r3);
                numberMode = true;
            }

            if (!Character.isDigit(ch)) {
                numberMode = false;
            }

            add(convert(Character.toLowerCase(ch)), r1, r2, r3);
        }

        return r1 + "\n" + r2 + "\n" + r3;
    }

    private void add(String p, StringBuilder r1,
                     StringBuilder r2, StringBuilder r3) {

        r1.append(p.charAt(0)).append(" ")
          .append(p.charAt(3)).append("   ");

        r2.append(p.charAt(1)).append(" ")
          .append(p.charAt(4)).append("   ");

        r3.append(p.charAt(2)).append(" ")
          .append(p.charAt(5)).append("   ");
    }
}
