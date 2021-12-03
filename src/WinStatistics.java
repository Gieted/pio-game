import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public final class WinStatistics implements Statistics {
    private final Map<Player, Integer> winCounts = new HashMap<>();

    @Override
    public void notifyGameWonBy(Player player) {
        int currentWins = winCounts.getOrDefault(player, 0);
        winCounts.put(player, currentWins + 1);
    }

    @Override
    public void print() {
        winCounts.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry<Player, Integer>::getValue).reversed())
                .map(entry -> entry.getKey().getName() + ": " + entry.getValue())
                .forEach(System.out::println);
    }

    @Override
    public void clear() {
        winCounts.clear();
    }
}
