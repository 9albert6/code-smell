package com.danix.code.smell.example001;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

/**
 * @author  danix
 */
public class CustomerReport {

    private final Customer customer;
    private final Account account;
    private static final String accountString = "Account: IBAN: ";

    public CustomerReport(@Nonnull final Customer customer, @Nonnull final Account account) {
        this.customer = checkNotNull(customer);
        this.account = checkNotNull(account);
    }

    public String printCustomerDaysOverdrawn() {
        String fullName = customer.getFullName();

        String accountDescription = accountString + account.getIban() + ", Days Overdrawn: "
                + account.getDaysOverdrawn();
        return fullName + accountDescription;
    }

    public String printCustomerMoney() {
        String fullName = customer.getFullName();
        String accountDescription = "";
        accountDescription += accountString + account.getIban() + ", Money: " + account.getMoneyAmount();
        return fullName + accountDescription;
    }

    public String printCustomerAccount() {
        return accountString + account.getIban() + ", Money: " + account.getMoneyAmount() + ", Account type: "
                + account.getType();
    }

    public String printCustomer() {
        return customer.getName() + " " + customer.getEmail();
    }
}
