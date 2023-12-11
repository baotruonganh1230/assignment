package database;

import entity.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Database {
    //Some data the DB contains
    public static List<Account> accounts = new ArrayList<>();

    static {
        accounts.add(new Account(1, new BigDecimal(0)));
    }
}
