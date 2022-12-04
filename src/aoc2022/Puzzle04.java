package aoc2022;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Puzzle04 extends AbstractPuzzle{

    public String lines[];
    public Puzzle04(String puzzleInput) {
        super(puzzleInput);
        lines = getPuzzleInput().toString().split("\\r?\\n");
    }

    @Override
    public int getDay() {
        return 4;
    }

    public boolean fullyOverlappedPair(String[] firstRange, String[] secondRange){
        if (Integer.parseInt(firstRange[0]) <= Integer.parseInt(secondRange[0]) &&
                Integer.parseInt(firstRange[1]) >= Integer.parseInt(secondRange[1])) {
            return TRUE;
        } else if (Integer.parseInt(firstRange[0]) >= Integer.parseInt(secondRange[0]) &&
                Integer.parseInt(firstRange[1]) <= Integer.parseInt(secondRange[1])){
            return TRUE;
        } else {
            return FALSE;
        }
    }

    public boolean OverlappedPair(String[] firstRange, String[] secondRange){
        if (Integer.parseInt(firstRange[0]) <= Integer.parseInt(secondRange[0]) &&
                Integer.parseInt(firstRange[1]) >= Integer.parseInt(secondRange[0])) {
            return TRUE;
        } else if (Integer.parseInt(firstRange[0]) >= Integer.parseInt(secondRange[0]) &&
                Integer.parseInt(firstRange[0]) <= Integer.parseInt(secondRange[1])){
            return TRUE;
        } else {
            return FALSE;
        }
    }

    @Override
    public String solvePart1() {
        int counter = 0;
        String assignments[];
        String firstRange[];
        String secondRange[];
        for (String pair : lines){
            assignments = pair.split(",");
            firstRange = assignments[0].split("-");
            secondRange = assignments[1].split("-");
            if (fullyOverlappedPair(firstRange, secondRange)){
                counter += 1;
            }
        }
        return String.valueOf(counter);
    }

    @Override
    public String solvePart2() {
        int counter = 0;
        String assignments[];
        String firstRange[];
        String secondRange[];
        for (String pair : lines){
            assignments = pair.split(",");
            firstRange = assignments[0].split("-");
            secondRange = assignments[1].split("-");
            if (OverlappedPair(firstRange, secondRange)){
                counter += 1;
            }
        }
        return String.valueOf(counter);
    }
}
