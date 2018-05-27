class AsciiDrawer {

    private Input input;


    AsciiDrawer(Input input) {
        this.input = input;
    }

    String draw() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String asciiRepresentationRow : input.getAsciiRepresentationRows()) {
            for(Character letter : input.getTextToTransform().toCharArray()){
                AsciiLettersHandler.drawRowPartOfLetter(stringBuilder, asciiRepresentationRow, letter, input.getLength());
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }
}

class AsciiLettersHandler {

    private static final int NUMBER_OF_ALPHABET_LETTERS = ('Z' - 'A' + 1);

    static int getStartingIndex(Character letter, int length) {
        if('A' <= letter && letter<='Z'){
            return (letter - 'A') * length;
        }else
            return NUMBER_OF_ALPHABET_LETTERS * length;

    }

    static int getEndingIndex(Character letter, int length) {
        return getStartingIndex(letter,length)+length;
    }

    static void drawRowPartOfLetter(StringBuilder stringBuilder, String asciiRepresentationRow, Character letter, Integer length) {
        int startingIndex = getStartingIndex(letter, length);
        int endingIndex = getEndingIndex(letter, length);
        stringBuilder.append(asciiRepresentationRow, startingIndex, endingIndex);
    }
}