package com.danix.code.smell.example001;

/**
 * @author  danix
 */
public class Company extends Customer {

    protected double companyOverdraftDiscount = 1;

    Company(final String name, final String email, final Account account, final double companyOverdraftDiscount) {
        super(name, email, account);
        this.companyOverdraftDiscount = companyOverdraftDiscount;
    }

    @Override
    public void withdraw(final Money money) {

        if (account.isOverdraft()) {
            double value = 0;
            if (account.getType().isPremium()) {
                value = money.getAmount() + money.getAmount() * account.overdraftFee() * companyOverdraftDiscount / 2;
            } else {
                value = money.getAmount() + money.getAmount() * account.overdraftFee() * companyOverdraftDiscount;
            }
            account.substract(Money.newInstance(value, money.getCurrency()));
        } else {
            account.substract(Money.newInstance(money.getAmount(), money.getCurrency()));
        }
    }

    @Override
    protected String getFullName() {
        return name;
    }
}
