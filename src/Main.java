import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    //TODO: write a main method
    //Example Input:
    List<Transaction> internal = Arrays.asList(
        new Transaction("T1", 100.0, "SUCCESS"),
        new Transaction("T2", 200.0, "FAILED"),
        new Transaction("T3", 150.0, "PENDING")
    );

    List<Transaction> external = Arrays.asList(
        new Transaction("T1", 100.0, "SUCCESS"),
        new Transaction("T2", 250.0, "FAILED"),
        new Transaction("T4", 300.0, "SUCCESS")
    );

    // Example Output:
    // Missing in External: [T3]
    // Missing in Internal: [T4]
    // Mismatched Transactions: [T2 (Internal: 200.0, FAILED | External:

    System.out.println("Hello, world!");


    }

}