//
//  SavingsAccount.cpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#include "SavingsAccount.hpp"
#include <string>
using namespace std;

SavingsAccount :: SavingsAccount(string n, double b, double i){
    this->name = n;
    this->balance = b;
    this->interest = i;
}

void SavingsAccount::addInterest(){
    this->balance += this->balance * this->interest/100;
}
