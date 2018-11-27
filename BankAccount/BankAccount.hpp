//
//  BankAccount.hpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#ifndef BankAccount_hpp
#define BankAccount_hpp
#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;

class BankAccount{
    public:
        BankAccount();
        BankAccount(string n, double b);
    
        string getName();
        double getBalance();
        void to_string();
    
        virtual void deposit(double a);
        virtual bool withdraw(double a);
    
        bool transfer(BankAccount *a, double b);
    
    protected:
        string name;
        double balance;
};

#endif /* BankAccount_hpp */
