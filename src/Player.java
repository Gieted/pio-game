public abstract class Player {
    private final static String DEFAULT_NAME = "Anonim";
    private String name = DEFAULT_NAME;

    public Player() {}

    public Player(String name) {
        setName(name);
    }

    public abstract int guess();

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
