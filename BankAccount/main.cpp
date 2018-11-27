//
//  main.cpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/20/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#include <iostream>
#include "BankAccount.hpp"
#include "CheckingAccount.hpp"
#include "SavingsAccount.hpp"
#include "Bank.hpp"
#include <string>

using namespace std;


int main(int argc, const char * argv[]) {
    Bank help;
    BankAccount starter("Jane Doe", 0.0);
    BankAccount advanced("Harry Potter", 500.0);
    starter.deposit(1000);
    advanced.withdraw(100);
    
    starter.withdraw(200);
    advanced.deposit(200);
    
    //starter.to_string();
    //advanced.to_string();
    
    SavingsAccount save("Mr. Save", 0.0, 1);
    CheckingAccount check("Mr. Check", 500);
    save.deposit(1000);
    check.withdraw(100);
    save.withdraw(200);
    check.deposit(200);
    
    save.to_string();
    check.to_string();
    
    save.addInterest();
    save.to_string();
    
    check.deductFees();
    check.to_string();
    
    return 0;
}
