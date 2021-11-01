import java.util.concurrent.ThreadLocalRandom;

public final class PlayerComp extends Player {
    private final ThreadLocalRandom random;

    public PlayerComp(ThreadLocalRandom random) {
        this.random = random;
    }

    public PlayerComp(String name, ThreadLocalRandom random) {
        super(name);
        this.random = random;
    }

    @Override
    public int guess() {
        return random.nextInt(1, 7);
    }
}
