import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    
        List<Transaction> internal = Arrays.asList(
            new Transaction("T1", 100.00, "SUCCESS"),
            new Transaction("T2", 200.00, "FAILED"),
            new Transaction("T3", 150.00, "PENDING")
        );

        List<Transaction> external = Arrays.asList(
            new Transaction("T1", 100.00, "SUCCESS"),
            new Transaction("T2", 250.00, "FAILED"),
            new Transaction("T4", 300.00, "SUCCESS")
        );


        ReconciliationReport report = ReconciliationService.Reconcile(internal, external);

        System.out.println("Missing in Internal:");
        System.out.println(report.getMissingInInternal());

        System.out.println("Missing in External:");
        System.out.println(report.getMissingInExternal());

        System.out.println("Mismatched Transactions:");
        System.out.println(report.getMismatchedTransactions());

    }

}