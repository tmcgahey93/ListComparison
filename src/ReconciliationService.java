import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReconciliationService {

    public static ReconciliationReport Reconcile(List<Transaction>internal, List<Transaction> external) {

        Map<String, Transaction> internalMap = internal.stream().collect(Collectors.toMap(Transaction::getId, t -> t));
        Map<String, Transaction> externalMap = external.stream().collect(Collectors.toMap(Transaction::getId, t -> t));

        ReconciliationReport report = new ReconciliationReport();

        // Check internal transactions
        for (String id : internalMap.keySet()) {
            if (!externalMap.containsKey(id)) {
                report.addMissingInExternal(internalMap.get(id));
            } else {
                // Exists in both: check for mismatch
                Transaction internalT = internalMap.get(id);
                Transaction externalT = externalMap.get(id);

                if (internalT.getAmount() != externalT.getAmount() ||
                    !internalT.getStatus().equals(externalT.getStatus())) {
                    report.addMismatchedTransaction("Mismatch for ID " + id + ":\n  Internal: " + internalT + "\n  External: " + externalT);
                }
            }
        }

        // Check external transactions
        for (String id : externalMap.keySet()) {
            if (!internalMap.containsKey(id)) {
                report.addMissingInInternal(externalMap.get(id));
            }
        }

        return report;
    }
}