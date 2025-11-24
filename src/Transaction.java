package bankmanagement.src;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction{
    private String transactionId;
    private String type;
    private double amount;
    private double balanceAfter;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount, double balanceAfter){
        this.transactionId = "TXN" +System.currentTimeMillis();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.timestamp = LocalDateTime.now();
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String sign = amount >+ 0 ? "+" : "";
        return String.format("%s | %s: %s%.2f | Balance: $%.2f",
                                    timestamp.format(formatter), type, sign, amount, balanceAfter);
    }
}
