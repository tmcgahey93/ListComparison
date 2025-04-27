public class Transaction {

    private String id;
    private double amount;
    private String status;

    // Constructor
    public Transaction(String id, double amount, String status) {
    this.id = id;
    this.amount = amount;
    this.status = status;
    }
    
    // Getters
    public String getId() {
    return id;
    }
    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    // Override equals and hashCode for comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Transaction that = (Transaction) obj;

        return Double.compare(that.amount, amount) == 0 && id.equals(that.id) && status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, amount, status);
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + ", status='" + status + "'}";
    }
}