package pl.waw.sgh.bank;

import pl.waw.sgh.bank.exceptions.InvalidAmountException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.waw.sgh.bank.exceptions.NonExistantAccountException;

public class Bank {

   public List<Customer> custList = new ArrayList<>();

   public List<Account> accList = new ArrayList<>();

    private Integer lastCustID = 0;

    private Integer lastAccID = 0;

    private int currentCustomerListIndex;

    public Customer createCustomer(int customerId,
                                    String firstName,
                                    String lastName,
                                    String email) {
        Customer customer = new Customer(customerId,firstName, lastName, email);
        custList.add(customer);
        currentCustomerListIndex = custList.size() - 1;
        return customer;
    }

    public Customer GetCurrentCustomer(){
        return custList.get(currentCustomerListIndex);
    }

    public void SetIndexAtPrevCustomer(){
        currentCustomerListIndex = Math.max(0, currentCustomerListIndex - 1);
        //unikamy wyjscia poza liste
    }

    public void SetIndexAtNextCustomer(){
        currentCustomerListIndex = Math.min(custList.size()-1, currentCustomerListIndex+1);
        //aby nie wyjsc poza liste - jezeli pointer jest gdzies w srodku, to po prostu dodaje +1
    }

    public void deleteCustomer(Integer custId) {
        Customer custToDel = findCustomerById(custId);
        // First find all accounts that belong to that customer and delete them
        custList.remove(custToDel);
    }

    public Account createAccount(Customer customer, boolean isSavings) {
        Account account = (isSavings ?
                new SavingsAccount(lastAccID++, new BigDecimal(0), customer)
                :
                new DebitAccount(lastAccID++, new BigDecimal(0), customer)
        );
        accList.add(account);
        return account;
    }

    public void transfer(Integer fromAccId, Integer toAccId, double amount)
            throws InvalidAmountException, NonExistantAccountException {
        Account fromAcc = findAccountById(fromAccId);
        Account toAcc = findAccountById(toAccId);
        fromAcc.charge(amount);
        toAcc.deposit(amount);
    }
/*
    public void transfer(Integer fromAccId, Integer toAccId, double amount) {
        Account fromAcc = findAccountById(fromAccId);
        Account toAcc = findAccountById(toAccId);
        int res = fromAcc.charge(amount);
        if (res<0) {
            System.out.println("Not enough money");
            System.exit(res);
        }
        toAcc.deposit(amount);
    }
*/

    public Account findAccountById(int id) throws NonExistantAccountException {
        // iterate through the account list and return the account with a given id
        for (Account acc : accList) {
            //if (id.equals(acc.getAccountID()))
            if (id==acc.getAccountID())
                return acc;
        }
        throw new NonExistantAccountException("Account id: " + id + " does not exist!");
        //return null;
    }

    public Customer findCustomerById(int id) {
        for (Customer cust : custList) {
            if (id==cust.getCustomerID())
                return cust;
        }
        return null;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "cust=" + custList +
                "\nacc=" + accList +
                '}';
    }

    public Integer getNewCustomerId() {
        int currentSize = custList.size();
        return currentSize;
    }
}