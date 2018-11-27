//
//  CheckingAccount.cpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#include "CheckingAccount.hpp"
#include <string>
using namespace std;

static const double TRANSACTION_FEE = 3.0;

CheckingAccount::CheckingAccount(string n, double b){
    this->name = n;
    this->balance = b;
    //this->TRANSACTION_FEE = 3.0;
}

bool CheckingAccount::deductFees(){
    double amount = TRANSACTION_FEE * transactionCount;
    if (amount > this->balance){
        cout << "Fees could not be deducted due to insufficient funds.\n";
        return false;
    }
    this->balance -= amount;
    transactionCount = 0;
    return true;
}

void CheckingAccount::deposit(double a){
    this->balance += a;
    transactionCount += 1;
}

bool CheckingAccount::withdraw(double a){
    if (this->balance < a){
        cout << "That amount exceeds the balance, and cannot be withdrawn.";
        return false;
    }
    this->balance -= a;
    transactionCount +=1;
    return true;
}

