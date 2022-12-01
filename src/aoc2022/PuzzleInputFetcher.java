package aoc2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class PuzzleInputFetcher {
    private static final Logger LOG = Logger.getLogger(String.valueOf(PuzzleInputFetcher.class));
    private final Map<Integer, String> _cache = new ConcurrentHashMap<>();
    private final Path _puzzleStorePath;

    public PuzzleInputFetcher() {
        this(Path.of("puzzle"));
    }

    PuzzleInputFetcher(Path puzzleStorePath) {
        _puzzleStorePath = puzzleStorePath;
    }

    /**
     * Fetches the given day's puzzle input. It will try to fetch first from the in-memory cache, then the local disk,
     * and finally the Advent of Code site (storing the input to the local disk to avoid further fetches).
     *
     * @param day the puzzle's day
     * @return the puzzle input
     * @throws RuntimeException if the puzzle cannot be fetched
     */
    public String getPuzzleInput(int day) {
        return _cache.computeIfAbsent(day, s -> {
            try {
                return fetchLocalPuzzleInput(day);
            } catch (IOException e) {
                LOG.warning("Unable to fetch puzzle input from local store for today");
            }
            return null;
        });
    }

    String fetchLocalPuzzleInput(int day) throws IOException {
        LOG.info("Fetching puzzle input from disk for today");
        return Files.readString(_puzzleStorePath.resolve(String.valueOf(day)));
    }
}
