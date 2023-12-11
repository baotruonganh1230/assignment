package service;

import database.Database;
import entity.Account;
import entity.Bill;
import entity.Payment;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaymentService {

    private Account account;

    public PaymentService(Long accountId) {
        Optional<Account> accountOptional = Database.accounts.
                stream().
                filter(a -> a.getId() == accountId).
                findFirst();

        this.account = accountOptional.get();
    }

    public String addFund(BigDecimal amount) {

        this.account.setBalance(account.getBalance().add(amount));

        return "Your available balance: " + account.getBalance();
    }

    public String payBill(Long billNo) {
        Optional<Bill> billOptional = getBill(billNo);

        if (billOptional.isEmpty()) {
            return "Sorry! Not found a bill with such id";
        } else {
            Bill bill = billOptional.get();
            if (bill.getAmount().compareTo(this.account.getBalance()) < 0) {
                this.account.setBalance(account.getBalance().subtract(bill.getAmount()));
                this.account.getPayments().add(
                        new Payment(bill.getAmount(),
                                LocalDate.now(),
                                "SUCCESS",
                                billNo)
                );

                removeBill(billNo);


                return "Payment successful!";
            }

            return "Sorry! Not enough fund to proceed with payment.";
        }
    }

    public String payMultipleBill(List<Long> billsNos) {
        StringBuilder sb = new StringBuilder();
        for (Long billNo : billsNos) {
            sb.append(payBill(billNo));
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public String schedulePayment(Long billNo, LocalDate date) {
        Optional<Bill> billOptional = getBill(billNo);

        if (billOptional.isEmpty()) {
            return "Sorry! Not found a bill with such id";
        } else {
            Bill bill = billOptional.get();
            bill.setScheduledDate(date);

            return "Payment for bill id " + billNo + "is scheduled on" + date;
        }
    }

    public List<Payment> getPayments() {
        return this.account.getPayments();
    }

    public List<Bill> searchBillByType(String type) {
        return this.account.getBillList()
                .stream()
                .filter(a -> a.getType().equalsIgnoreCase(type))
                .toList();
    }

    public List<Bill> searchBillByProvider(String provider) {
        return this.account.getBillList()
                .stream()
                .filter(a -> a.getType().equalsIgnoreCase(provider))
                .toList();
    }

    public void removeBill(Long billNo) {
        this.account.getBillList().removeIf(a -> a.getBillNo() == billNo);
    }

    public List<Bill> getAllBills() {
        return this.account.getBillList();
    }

    private Optional<Bill> getBill(Long billNo) {
        return this.account.getBillList()
                .stream()
                .filter(a -> a.getBillNo() == billNo)
                .findFirst();
    }

}
