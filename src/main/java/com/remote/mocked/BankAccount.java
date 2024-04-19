package com.remote.mocked;

import java.util.HashMap;

public class BankAccount
{
    public String accountNumber;
    private static HashMap<String, Integer> balance;
    public static BankAccount waterBillerAccNumber;
        static
        {
            waterBillerAccNumber = new BankAccount("Acc987");
            balance = new HashMap<>();
            balance.put(waterBillerAccNumber.accountNumber, 1000);
            balance.put("Acc1", 190);
            balance.put("Acc2", 1900);
            balance.put("Acc3", 40);

        }

    public BankAccount(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public int fetchBalance() {
        return balance.get(accountNumber);
    }

    public void payBill(int amount)
    {
        balance.put(accountNumber, balance.get(accountNumber) - amount);
        balance.put(waterBillerAccNumber.accountNumber, balance.get(waterBillerAccNumber.accountNumber) + amount);
    }
}