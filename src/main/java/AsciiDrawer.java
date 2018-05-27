class AsciiDrawer {

    private Input input;


    AsciiDrawer(Input input) {
        this.input = input;
    }

    String draw() {
        return drawLetter(input.getTextToTransform().charAt(0));
    }

    private String drawLetter(Character letter) {
        StringBuilder stringBuilder = new StringBuilder();
        int startingIndex = AsciiLettersHandler.getStartingIndex(letter, input.getLength());
        int endingIndex = AsciiLettersHandler.getEndingIndex(letter, input.getLength());

        for (String row : input.getAsciiRepresentationRows()) {
            stringBuilder.append(row, startingIndex, endingIndex).append("\n");
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
}