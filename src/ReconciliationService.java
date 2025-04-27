
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconciliationService {

    public static ReconciliationReport Reconcile(List<Transaction>internal, List<Transaction> external) {

        Map<String, Transaction> internalMap = new HashMap<>();
        Map<String, Transaction> externalMap = new HashMap<>();

        for (Transaction t : internal) {
            internalMap.put(t.getId(), t);
        }

        for (Transaction t : external) {
            externalMap.put(t.getId(), t);
        }


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