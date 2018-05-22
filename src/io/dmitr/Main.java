package io.dmitr;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    private String brackets = "][}{)(";
    private Map<Character, Character> bracketsMap = new HashMap<>();

    public static void main(String[] args) {

        String string = "{fsdfsdf}}[fsfsfs]";

        Main main = new Main();
        main.initBracketMap();

        System.out.println(String.format("Brackets are%s balanced.", !main.checkBracketBalance(string) ? " not"
                : ""));
    }

    private boolean checkBracketBalance(String bracketString) {
        Stack<Character> bracketsStack = new Stack<>();
        Character bracket = 'x';

        for (int x = 0; x < bracketString.length(); x++) {
            Character ch = bracketString.charAt(x);
            if (isBracket(ch)) {
                if (!bracketsStack.empty()) {
                    bracket = bracketsStack.peek();
                } else {
                    bracketsStack.push(ch);
                    continue;
                }

                Character oppositeCharacter = getOppositeBracket(ch);

                if (bracket.equals(oppositeCharacter)) {
                    bracketsStack.pop();
                } else {
                    bracketsStack.push(ch);
                }
            }
        }
        return bracketsStack.empty();
    }

    private boolean isBracket(Character ch) {

        return brackets.indexOf(ch) != -1;
    }

    private void initBracketMap() {
        for (int x = 0; x < (brackets.length()); x++) {
            bracketsMap.put(brackets.charAt(x), brackets.charAt(++x));
        }
    }

    private Character getOppositeBracket(Character character) {

        return bracketsMap.get(character);
    }
}
