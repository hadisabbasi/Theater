package com.github.hadisabbasi.theater;

public class AccountArray {
    private Account[] accounts;

    public AccountArray() {
        this(10);
    }

    public AccountArray(int length) {
        accounts = new Account[length];
    }

    public void add(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null)
                accounts[i] = account;
        }
    }

    public Account getAccount(String userName, int pass) {
        boolean isExist = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getUserName() == userName && accounts[i].getPass() == pass) {
                return accounts[i];
            }
        }

        // throw exception
        return null;
    }

}


