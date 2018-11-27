//
//  SavingsAccount.hpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#ifndef SavingsAccount_hpp
#define SavingsAccount_hpp
#include "BankAccount.hpp"
#include <stdio.h>
#include <string>
using namespace std;

class SavingsAccount : public BankAccount{
    public:
        SavingsAccount(string n, double b, double i);
        void addInterest();
    
    private:
        double interest;
    
};

#endif /* SavingsAccount_hpp */
