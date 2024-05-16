package com.sample.demo.entity;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "AccountDetails")
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long account_number; //accountNumber

    private  String  account_holder_name;

    private Double  account_balance;


    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", account_holder_name='" + account_holder_name + '\'' +
                ", account_balance=" + account_balance +
                '}';
    }

    public Account() {
    }

    public Account(String account_holder_name, Double account_balance) {
        this.account_holder_name = account_holder_name;
        this.account_balance = account_balance;
    }
}

