package aoc2022;

public class Puzzle01 extends AbstractPuzzle{
    public Puzzle01(String puzzleInput) {
        super(puzzleInput);
    }

    @Override
    public int getDay() {
        return 1;
    }

    @Override
    public String solvePart1() {
        String lines[] = getPuzzleInput().toString().split("\\r?\\n");
        int maxFood = 0;
        int deer = 0;
        for(String line: lines){
            if (line == ""){
                if (deer > maxFood){
                    maxFood = deer;
                }
                deer = 0;
            } else {
                deer += Integer.parseInt(line);
            }
        }
        if (deer > maxFood){
            maxFood = deer;
        }
        return String.valueOf(maxFood);
    }

    @Override
    public String solvePart2() {
        String lines[] = getPuzzleInput().toString().split("\\r?\\n");
        int maxFood = 0;
        int maxFood2 = 0;
        int maxFood3 = 0;
        int deer = 0;
        for(String line: lines){
            if (line == ""){
                if (deer > maxFood3){
                    if (deer > maxFood2){
                        if (deer > maxFood) {
                            maxFood = deer;
                        } else {
                            maxFood2 = deer;
                        }
                    } else {
                        maxFood3 = deer;
                    }
                }
                deer = 0;
            } else {
                deer += Integer.parseInt(line);
            }
        }
        if (deer > maxFood3){
            if (deer > maxFood2){
                if (deer > maxFood) {
                    maxFood = deer;
                } else {
                    maxFood2 = deer;
                }
            } else {
                maxFood3 = deer;
            }
        }
        return String.valueOf(maxFood + maxFood2 + maxFood3);
    }
}
