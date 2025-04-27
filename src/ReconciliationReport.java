import java.util.ArrayList;
import java.util.List;

public class ReconciliationReport {

    private List<Transaction> missingInExternal;
    private List<Transaction> missingInInternal;
    private List<String> mismatchedTransactions;

    ReconciliationReport() {
        this.missingInExternal = new ArrayList<>();
        this.missingInInternal = new ArrayList<>();
        this.mismatchedTransactions = new ArrayList<>();
    }

    // Getters and Setters
    public List<Transaction> getMissingInExternal() {
        return missingInExternal;
    }

    public void addMissingInExternal(Transaction t) {
        missingInExternal.add(t);
    }

    public List<Transaction> getMissingInInternal() {
        return missingInInternal;
    }
    
    public void addMissingInInternal(Transaction t) {
        missingInInternal.add(t);
    }

    public List<String> getMismatchedTransactions() {
        return mismatchedTransactions;
    }
    
    public void addMismatchedTransaction(String s) {
        mismatchedTransactions.add(s);
    }

    @Override
    public String toString() {
        return "ReconciliationReport{" +
                "missingInExternal=" + missingInExternal +
                 ", missingInInternal=" + missingInInternal +
                ", mismatchedTransactions=" + mismatchedTransactions + '}';
    }

}