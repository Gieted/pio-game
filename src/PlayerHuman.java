import java.util.InputMismatchException;
import java.util.Scanner;

public final class PlayerHuman extends Player {
    private final Scanner scanner;

    public PlayerHuman(Scanner scanner) {
        this.scanner = scanner;
    }

    public PlayerHuman(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public int guess() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            scanner.next();
            return guess();
        }
    }
}
