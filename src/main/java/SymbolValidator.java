import java.util.stream.Stream;

public class SymbolValidator {
    public static boolean isValid(String element, String symbol) {
        element = element.toLowerCase(); // symbol's first letter can be different than element's first letter
        symbol = symbol.toLowerCase();
        return hasValidLength(symbol)
                && containsBothCharacters(element, symbol)
                && charactersAreInOrder(element, symbol);
    }

    private static boolean hasValidLength(String symbol) {
        return symbol.length() == 2;
    }

    private static boolean containsBothCharacters(String element, String symbol) {
        return (element.indexOf(symbol.charAt(0)) != -1)
                && (element.indexOf(symbol.charAt(1)) != -1);
    }

    private static boolean charactersAreInOrder(String element, String symbol) {
        return element.lastIndexOf(symbol.charAt(1)) > element.indexOf(symbol.charAt(0));
    }

    public static String firstValidSymbol(String element) {
        return allSymbols()
                .filter(symbol -> isValid(element, symbol))
                .sorted()
                .findFirst()
                .get();
    }

    public static long distinctValidSymbolsCount(String element) {
        return allSymbols()
                .filter(symbol -> isValid(element, symbol))
                .distinct()
                .count();
    }

    private static Stream<String> allSymbols() {
        Stream.Builder<String> symbols = Stream.builder();
        for (char first = 'A'; first <= 'Z'; ++first) {
            for (char second = 'a'; second <= 'z'; ++second) {
                symbols.accept(String.valueOf(new char[]{first, second}));
            }
        }
        return symbols.build();
    }
}
