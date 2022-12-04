package aoc2022;

import java.util.HashMap;

public class Puzzle03 extends AbstractPuzzle{

    public String[] lines;
    public Puzzle03(String puzzleInput) {
        super(puzzleInput);
         lines = getPuzzleInput().toString().split("\\r?\\n");
    }

    private int getCommonItem(String rucksack){
        final int l = rucksack.length();
        char commonItem = 0;
        int value;

        String[] components = {rucksack.substring(0,l/2), rucksack.substring(l/2)};

        HashMap<Character, Boolean> items = new HashMap<>();

        for (int i =0; i<l/2; i++){
                items.putIfAbsent(components[0].charAt(i), Boolean.TRUE);
        }

        for (int i =0; i<l/2; i++){
            if (items.containsKey(components[1].charAt(i))) {
                commonItem = components[1].charAt(i);
                break;
            }
        }

        if ('a' <= commonItem && commonItem <= 'z'){
            value = commonItem - 'a' + 1;
        } else {
            value = commonItem - 'A' + 27;
        }
        return value;
    }

    private int getBadge(String rucksack1, String rucksack2, String rucksack3){
        int value;
        char commonItem = 0;

        HashMap<Character, Boolean> items = new HashMap<>();

        int l = rucksack1.length();

        for (int i =0; i<l; i++){
            items.putIfAbsent(rucksack1.charAt(i), Boolean.TRUE);
        }

        for (Character key: items.keySet()){
            if (rucksack2.contains(String.valueOf(key)) && rucksack3.contains(String.valueOf(key))){
                commonItem = key;
            }
        }

        if ('a' <= commonItem && commonItem <= 'z'){
            value = commonItem - 'a' + 1;
        } else {
            value = commonItem - 'A' + 27;
        }

        return value;
    }
    @Override
    public int getDay() {
        return 3;
    }

    @Override
    public String solvePart1() {
        int sum = 0;
        for (String rucksack : lines){
            sum += getCommonItem(rucksack);
        }
        return String.valueOf(sum);
    }

    @Override
    public String solvePart2() {
        int sum = 0;
        int l = lines.length;

        for (int i = 0; i < l; i = i+3){
            sum += getBadge(lines[i], lines[i+1], lines[i+2]);
        }

        return String.valueOf(sum);
    }
}