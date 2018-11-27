//
//  Bank.hpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/27/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#ifndef Bank_hpp
#define Bank_hpp

#include <stdio.h>
#include "BankAccount.hpp"

class AccountList {
    public:
        BankAccount myAct;
        BankAccount* nextAct;
};

class User{
    //Each user will have a unique user ID
    //We will make linked list of users
    public:
        User();
    
    private:
        int AccNum;
        AccountList* myAccounts;
        User* next;
};



class Bank{
    public:
        Bank();
        void AddCustomer();
        void giveMenu();
    
    
    protected:
        User* userHead;
};





#endif /* Bank_hpp */
