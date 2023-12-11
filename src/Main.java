import entity.Account;
import entity.Bill;
import entity.Payment;
import service.OutputService;
import service.PaymentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(1L);
        OutputService outputService = new OutputService();

        if (args[0].equals( "CASH_IN" )) {
            System.out.println(paymentService.addFund(new BigDecimal(args[1])));
        } else if (args[0].equals( "LIST_BILL" )) {
            outputService.outputBillList(paymentService.getAllBills());
        } else if (args[0].equals( "PAY" )) {
            if (args.length > 2) {
                List<Long> billNos = new ArrayList<>();

                for (int i = 1; i < args.length; i++) {
                    billNos.add(Long.valueOf(args[i]));
                }

                System.out.println(paymentService.payMultipleBill(billNos));
            } else {
                System.out.println(paymentService.payBill(Long.valueOf(args[1])));
            }

        } else if (args[0].equals( "SCHEDULE" )) {
            System.out.println(paymentService.schedulePayment(Long.valueOf(args[1]), LocalDate.parse(args[2])));
        } else if (args[0].equals( "LIST_PAYMENT")) {
            outputService.outputPaymentList(paymentService.getPayments());
        } else if (args[0].equals( "SEARCH_BILL_BY_PROVIDER")) {
            outputService.outputBillList(paymentService.searchBillByProvider(args[1]));
        } else if (args[0].equals( "SEARCH_BILL_BY_TYPE")) {
            outputService.outputBillList(paymentService.searchBillByType(args[1]));
        } else if (args[0].equals( "EXIT")) {
            System.exit(0);
        } else {
            System.out.println("Usage");
        }
    }
}