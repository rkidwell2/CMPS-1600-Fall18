//
//  CheckingAccount.hpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#ifndef CheckingAccount_hpp
#define CheckingAccount_hpp

#include <stdio.h>
#include "BankAccount.hpp"
#include <iostream>

class CheckingAccount : public BankAccount{
    
    public:
        CheckingAccount(string n, double b);
        bool deductFees();
        void deposit(double a);
        bool withdraw(double a);
    private:
        int transactionCount;
        
    
};
#endif /* CheckingAccount_hpp */
