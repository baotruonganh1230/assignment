package entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private long id;

    private BigDecimal balance;

    private List<Bill> billList;

    private List<Payment> payments;

    public Account(long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
        this.billList = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
