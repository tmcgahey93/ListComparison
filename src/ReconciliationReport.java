import java.util.List;

public class ReconciliationReport {

    private List<Transaction> missingInExternal;
    private List<Transaction> missingInInternal;
    private List<String> mismatchedTransactions;

    // Getters and Setters
    public List<Transaction> getMissingInExternal() {
        return missingInExternal;
    }

    public void setMissingInExternal(List<Transaction> missingInExternal) {
        this.missingInExternal = missingInExternal;
    }

    public List<Transaction> getMissingInInternal() {
        return missingInInternal;
    }
    
    public void setMissingInInternal(List<Transaction> missingInInternal) {
        this.missingInInternal = missingInInternal;
    }
    public List<String> getMismatchedTransactions() {
        return mismatchedTransactions;
    }
    
    public void setMismatchedTransactions(List<String>mismatchedTransactions) {
        this.mismatchedTransactions = mismatchedTransactions;
    }

    @Override
    public String toString() {
        return "ReconciliationReport{" +
                "missingInExternal=" + missingInExternal +
                 ", missingInInternal=" + missingInInternal +
                ", mismatchedTransactions=" + mismatchedTransactions + '}';
    }

}