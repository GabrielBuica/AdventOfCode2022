package aoc2022;

import java.util.HashMap;

public class Puzzle02 extends AbstractPuzzle{

    public String lines[];
    int score;
    public Puzzle02(String puzzleInput) {
        super(puzzleInput);
        lines = getPuzzleInput().toString().split("\\r?\\n");
    }

    // Loss = 0;
    // Draw = 3;
    // Win = 6;

    // Rock = 1
    // Paper = 2
    // Scissors = 3
    public static HashMap<String, Integer> results = new HashMap<String, Integer>();
    public static HashMap<String, String> strategy = new HashMap<String, String>();

    private static void initMaps() {
        // for when they pick rock
        results.put("A X", 4);
        results.put("A Y", 8);
        results.put("A Z", 3);

        // for when they pick paper
        results.put("B X", 1);
        results.put("B Y", 5);
        results.put("B Z", 9);

        // for when they pick scissors
        results.put("C X", 7);
        results.put("C Y", 2);
        results.put("C Z", 6);

        // for when they pick Rock
        strategy.put("A X", "A Z");
        strategy.put("A Y", "A X");
        strategy.put("A Z", "A Y");

        // for when they pick paper
        strategy.put("B X", "B X");
        strategy.put("B Y", "B Y");
        strategy.put("B Z", "B Z");

        // for when they pick scissors
        strategy.put("C X", "C Y");
        strategy.put("C Y", "C Z");
        strategy.put("C Z", "C X");
    }

    @Override
    public int getDay() {
        return 2;
    }

    @Override
    public String solvePart1() {
        score = 0;
        initMaps();
        for(String round :lines){
            score += results.get(round);
        }
        return String.valueOf(score);
    }

    @Override
    public String solvePart2() {
        score = 0;
        initMaps();
        for(String round :lines){
            score += results.get(strategy.get(round));
        }
        return String.valueOf(score);
    }
}
