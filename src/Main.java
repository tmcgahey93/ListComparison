import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    
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


        ReconciliationReport report = ReconciliationService.Reconcile(internal, external);

        System.out.println("Missing in Internal:");
        System.out.println(report.getMissingInInternal());

        System.out.println("Missing in External:");
        System.out.println(report.getMissingInExternal());

        System.out.println("Mismatched Transactions:");
        System.out.println(report.getMismatchedTransactions());

        // Example Output:
        // Missing in External: [T3]
        // Missing in Internal: [T4]
        // Mismatched Transactions: [T2 (Internal: 200.0, FAILED | External:

        System.out.println("Exiting App");


    }

}