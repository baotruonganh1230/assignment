package entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {
    private BigDecimal amount;

    private LocalDate paymentDate;

    private String state;

    private long billId;

    public Payment(BigDecimal amount, LocalDate paymentDate, String state, long billId) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.state = state;
        this.billId = billId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }
}
