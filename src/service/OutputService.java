package service;

import entity.Bill;
import entity.Payment;

import java.util.List;

public class OutputService {

    public void outputBillList(List<Bill> billList) {
        System.out.println("BillNo.  Type  Amount  DueDate  State  PROVIDER");
        for (Bill bill : billList) {
            System.out.println(bill.getBillNo() + "  "
                    + bill.getType() + "  "
                    + bill.getAmount() + "  "
                    + bill.getDueDate() + "  "
                    + bill.getState() + "  "
                    + bill.getProvider());
        }
    }

    public void outputPaymentList(List<Payment> paymentList) {
        int id = 1;
        System.out.println("No.  Amount  PaymentDate  State  BillId");
        for (Payment payment : paymentList) {
            System.out.println(id++ + "  "
                    + payment.getAmount() + "  "
                    + payment.getPaymentDate() + "  "
                    + payment.getState() + "  "
                    + payment.getBillId());
        }
    }
}
