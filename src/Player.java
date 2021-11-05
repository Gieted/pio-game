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
    
    private static boolean isValidName(String name) {
        return name.matches("^[\\p{L}\\d_-]{3,}$");
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name was provided");
        }
    }
}
