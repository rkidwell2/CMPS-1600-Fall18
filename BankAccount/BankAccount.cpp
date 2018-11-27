//
//  BankAccount.cpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//
#include <string>
#include "BankAccount.hpp"
#include "CheckingAccount.hpp"
#include <iostream>
using namespace std;

BankAccount :: BankAccount(){
    this->name = "";
    this->balance = 0.0;
}

BankAccount :: BankAccount(string n, double b){
    this->name = n;
    this->balance = b;
}

string BankAccount::getName(){
    return this->name;
}

double BankAccount::getBalance(){
    return this->balance;
}

void BankAccount::deposit(double a){
    this->balance += a;
}

bool BankAccount::withdraw(double a){
    if (this->balance < a){
        cout << "That amount exceeds the balance, and cannot be withdrawn.";
        return false;
    }
    this->balance -= a;
    return true;
}

void BankAccount::to_string(){
    cout << "Name: " << this->name << "\nBalance: " << this->balance << endl;
}
