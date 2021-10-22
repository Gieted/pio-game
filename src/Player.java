import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private final ThreadLocalRandom random;
    private final static String DEFAULT_NAME = "Anonim";
    private String name = DEFAULT_NAME;

    public Player(ThreadLocalRandom random) {
        this.random = random;
    }

    public Player(String name, ThreadLocalRandom random) {
        this.random = random;
        setName(name);
    }

    public int guess() {
        return random.nextInt(1, 7);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("'name' cannot be null");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("'name' cannot be empty");
        }
        
        this.name = name;
    }
}
