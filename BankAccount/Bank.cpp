//
//  Bank.cpp
//  bankAccount
//
//  Created by Rosalind Kidwell on 11/27/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//

#include "Bank.hpp"

Bank::Bank(){
    cout << "Welcome to Stanley Thomas Bank.\nPlease select an option from the following menu:\n";
    this->giveMenu();
}

void Bank::giveMenu(){
    string choice;
    string menu = "Press A to add a new account.\nPress V to view an account's name and balance.\nPress T to transfer between accounts.\nPress D to deposit into an account.\nPress W to withdraw from an account.\nPress Q to quit. ";
    cout << "        1) Create an account.\n";
    cout << "        2) Deposit.\n";
    cout << "        3) Withdraw.\n";
    cout << "        4) View an account.\n";
    cout << "        5) Quit.";
    cin >> choice;
    
    while (choice != "5"){
        if (choice == "1")
            this->AddCustomer();
    }
    
}

void Bank::AddCustomer(){
    cout << "Would you like to create a checking or savings account?";
}
