import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class Game {
    private final ThreadLocalRandom random;
    private final Statistics statistics;
    private final List<Player> players = new ArrayList<>();
    private boolean isFinished = false;

    public Game(ThreadLocalRandom random, Statistics statistics) {
        this.random = random;
        this.statistics = statistics;
    }

    public void addPlayer(Player player) {
        if (hasUniqueName(player)) {
            players.add(player);
        } else {
            changeName(player);
            addPlayer(player);
        }
    }

    public void removePlayer(String name) {
        Player playerToRemove = players.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst().orElse(null);

        players.remove(playerToRemove);
    }

    private void changeName(Player player) {
        String currentName = player.getName();
        String newName = StringUtils.incrementPostfix(currentName);
        player.setName(newName);
    }

    private boolean hasUniqueName(Player player) {
        return players.stream().noneMatch(otherPlayer -> player.getName().equals(otherPlayer.getName()));
    }

    private void endGame(List<Player> winners) {
        isFinished = true;
        List<String> names = winners.stream().map(Player::getName).collect(Collectors.toList());
        System.out.println();
        System.out.println("Zwycięzcy: " + String.join(", ", names));
        winners.forEach(statistics::notifyGameWonBy);
    }

    private void nextTurn() {
        System.out.println("---------------------");
        int diceThrow = random.nextInt(1, 7);
        List<Integer> guesses = players.stream().map(Player::guess).collect(Collectors.toList());
        List<Player> winners = new ArrayList<>();

        System.out.println("Kostka: " + diceThrow);
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            int guess = guesses.get(i);
            System.out.printf("Gracz %s: %d\n", player.getName(), guess);

            if (guess == diceThrow) {
                winners.add(player);
            }
        }

        if (!winners.isEmpty()) {
            endGame(winners);
        }
    }

    public void play() {
        while (!isFinished) {
            nextTurn();
        }
    }

    public void printPlayers() {
        players.stream().map(Player::getName).forEach(System.out::println);
    }
}
