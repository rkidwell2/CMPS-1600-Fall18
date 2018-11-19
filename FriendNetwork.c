//
//  main.c
//  FriendNetwork
//
//  Created by Rosalind Kidwell on 11/13/18.
//  Copyright © 2018 Rosalind Kidwell. All rights reserved.
//NOTE: No information for any data is permitted to include spaces

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>


typedef struct person{
    char email[30]; //Unique identifier
    char firstName[20];
    char lastName[20];
    char age[20];
    char hometown[20];
    char hobby[20];
    
}Person;

typedef struct node{
    
    Person* person;
    struct node* next;
    
}Node;

Node* FriendHead = NULL;

typedef struct connection{
    Person* person1;
    Person* person2;
    struct connection* next;
    
 }connection;
connection* ConnectionHead = NULL;

bool email_in_list(char*email){
    Node* head = FriendHead;
    if (head == NULL)
        return false;
    while (head != NULL){
        if (strcmp(head->person->email, email) == 0){
            return true;
        }
        head = head->next;
    }
    return false;
}

void add_to_list(Person* entry){
    Node* newNode = (Node*)malloc(sizeof(Node));
    
    newNode->person = malloc(sizeof(Person));
    newNode->person = entry;
    
    if (FriendHead == NULL){
        FriendHead = (Node*)malloc(sizeof(Node));
        newNode->next = NULL;
        FriendHead->person = newNode->person;
        FriendHead->next = NULL;
        return;
    }
    
    newNode->next = FriendHead;
    FriendHead = newNode;
}

void add(char* email){
    /*Check if e-mail already exists.
     * If it doesn't, ask for all the person data
     * Add person to list
     */
    
    if (email_in_list(email)){
        printf("That email is already defined.\n");
        return;
    }
    
    //If e-mail does not exist, create new profile
    Person* newGuy = (Person*)malloc(sizeof(Person));
    strcpy(newGuy->email, email);
        
    printf("First name? ");
    scanf("%s", newGuy->firstName);
        
    printf("Last name? ");
    scanf("%s", newGuy->lastName);
        
    printf("Age? ");
    scanf("%s", newGuy->age);
        
    printf("Hometown? (Do not use spaces when entering) ");
    scanf("%s", newGuy->hometown);
        
    printf("Hobby? (Do not use spaces when entering) ");
    scanf("%s", newGuy->hobby);
        
    /*Profile is created, now add to the list
    *We'll add to the head, so we don't have to run through all the profiles
    */
    add_to_list(newGuy);
    printf("Saved sucessfully.\n");
}

Node* findNode(char* email){
    Node* current = FriendHead;
    Node* nullNode = NULL;
    if (current == NULL){
        printf("There are no people in the network.\n");
        return nullNode;
    }
    do{
        if (strcmp(current->person->email, email) == 0){
            return current;
        }
        current = current->next;
    }while (current != NULL);
    
    printf("%s is not in the network.\n", email);
    return nullNode;
}

void remove_friend(char email[]){
 /*
 *check if email is there, remove from wherever it is
 *Need to delete all of their connections too
 *First delete pointer, then person
 */
    //If email does not exist
    if (!email_in_list(email)){
        printf("This email does not exist.\n");
        return;
    }
    
    Node* currNode = FriendHead;
    
    
    Node* deletion = findNode(email); //Get node to be deleted
     //Get person to be deleted (for connections)
    
    if (currNode != NULL && currNode==deletion){
        FriendHead = currNode->next;
        //removeConnections
        free(currNode);
        
        return;
    }
    
    Node* previous = malloc(sizeof(Node));
    while (currNode!= NULL && currNode!= deletion){
        previous = currNode;
        currNode = currNode->next;
    }
    //Found node to delete
    previous->next = currNode->next;
    free(currNode);
    
    
    //Node has now been deleted
    
    Person* per2Del = deletion->person;
    
     //Go through connections list and see if either email contains target
    connection* temp = ConnectionHead;
    connection* prev = NULL;

    //If head connection & those immeadiately following has target
    while (temp!=NULL && (temp->person1 == per2Del || temp->person2 == per2Del)){
        ConnectionHead = temp->next;
        free(temp);
        temp = ConnectionHead;
    }
    
    while (temp!= NULL){
        while (temp!= NULL && !(temp->person1 == per2Del || temp->person2 == per2Del)){
            prev = temp;
            temp = temp->next;
        }
        if (temp == NULL) return;
        
        prev->next = temp->next;
        free(temp);
        
        temp = prev->next;
    }
        
 }


void edit(char* email){
    /*
     * Give the Email address and the program shows the information of that person and you can edit any field.
     */
    
    //Iterate through to find the node requiring editing
    Node* current = FriendHead;
    //bool emailExists = false;
    while (current != NULL){
        if (strstr(current->person->email, email) != NULL) {
            //emailExists = true;
            break;
        }
        current = current->next;
    }
    
    printf("CURRENT INFORMATION:\n");
    printf("First name: %s (Enter F) to edit\n", current->person->firstName);
    printf("Last name: %s (Enter L) to edit\n", current->person->lastName);
    printf("Age: %s (Enter A) to edit\n", current->person->age);
    printf("Hometown: %s (Enter T) to edit\n", current->person->hometown);
    printf("Hobby: %s (Enter H) to edit\n", current->person->hobby);
    
    printf("What field would you like to edit? ");
    char choice[5];
    scanf("%s", choice);
    
    char newInfo[20];
    printf("What would you like the new information to be?\n");
    scanf("%s", newInfo);
    
    if (strcmp(choice,"F") == 0){
        strcpy(current->person->firstName, newInfo);
    }
    if (strcmp(choice,"L") == 0){
        strcpy(current->person->lastName, newInfo);
    }
    if (strcmp(choice,"A") == 0){
        strcpy(current->person->age, newInfo);
    }
    if (strcmp(choice,"T") == 0){
        strcpy(current->person->hometown, newInfo);
    }
    if (strcmp(choice,"H") == 0){
        strcpy(current->person->hobby, newInfo);
    }

}

bool connection_exists = false;

void connectFriend(char* email1, char* email2){
    connection* newConnect = (connection*)malloc(sizeof(connection));
    
    if (!email_in_list(email1) || !email_in_list(email2)) {
        printf("One of those emails does not exist. Please add them to the network first.\n");
        return;
    }
    
    //Check that the connection does not already exist
    connection* temp = ConnectionHead;
    if (connection_exists){
        while (temp != NULL){
            if (strcmp(temp->person1->email, email1) ==0 || strcmp(temp->person2->email, email1) ==0 ){
                if (strcmp(temp->person2->email, email2) ==0 || strcmp(temp->person1->email, email2) ==0){
                    printf("Connection already exists.");
                    return;
                }
            }
            temp = temp->next;
        }
    }
    
    newConnect->person1 = findNode(email1)->person;
    newConnect->person2 = findNode(email2)->person;
    
    newConnect->next = ConnectionHead;
    
    ConnectionHead = malloc(sizeof(connection));
    ConnectionHead = newConnect;
    connection_exists = true;
    
    return;
}

void disconnect(char * email1, char * email2){
    if (!email_in_list(email1)|| !email_in_list(email2)){
        printf("One of those emails is not in the network.\n");
        return;
    }
    connection *temp = ConnectionHead;

    //If there are no connections in the list
    if (temp == NULL){
        printf("No connections exist.\n");
        return;
    }
    
    //If head connection node is the connection to be deleted
    if ((temp!= NULL) && ((strcmp(temp->person1->email, email1) ==0 || strcmp(temp->person2->email, email1) ==0 ))){
        if (strcmp(temp->person2->email, email2) ==0 || strcmp(temp->person1->email, email2) ==0){
            ConnectionHead = temp->next;
            free(temp);
            return;
        }
    }
    
    //Search for node to be deleted, keeping track of previous node
    Node *person1 = findNode(email1);
    Node *person2 = findNode(email2);
    connection *prev = malloc(sizeof(connection));
    while (temp!= NULL){
        if (strcmp(temp->person1->email, email1) ==0 || strcmp(temp->person2->email, email1) ==0 ){
            if (strcmp(temp->person2->email, email2) ==0 || strcmp(temp->person1->email, email2) ==0){
                if (temp->next == NULL){
                    prev->next = NULL;
                    free(temp);
                    printf("%s and %s are no longer friends.\n", person1->person->firstName, person2->person->firstName);
                    return;
                }
                prev->next = temp->next;
                free(temp);
                printf("%s and %s are no longer friends.\n", person1->person->firstName, person2->person->firstName);
                return;
            }
        }
        prev = temp;
        temp = temp->next;
    }
    
    printf("%s and %s were not friends.", person1->person->firstName, person2->person->firstName);
    
    //if conn list is now empty, connection exists = false
    
}
        
void getFriends(char *email){
   //find friend
    Node* thisNode = findNode(email);
    
    //go through list of connections and find their name
    connection* cursor = ConnectionHead;
    if (cursor == NULL){
        printf("%s has no friends.", thisNode->person->firstName);
        return;
    }
    
    char connections[150] = "";
    while (cursor != NULL && connection_exists){
        
        if (cursor->person1 == thisNode->person){
            
            strcat(connections, cursor->person2->firstName);
            strcat(connections, ", ");
            
        }
        if (cursor->person2 == thisNode->person){
            strcat(connections, cursor->person1->firstName);
            strcat(connections, ", ");
            
        }
        if (cursor->next == NULL){
            if (strlen(connections) == 0){
                printf("%s has no friends.", thisNode->person->firstName);
                return;
            }
            connections[strlen(connections)-2] = 0;
            printf("%s", connections);
        }
        
        cursor = cursor->next;
    }
}

void displayNetwork(){
    /*
     * Display shows the information (just the name) of each person and all their immediate connections.
     * Ex: Andrea {Tom, Mary}
     *     Tom {Andrea, Harry} etc.
     *
     */
    Node* current = FriendHead;
    while (current!= NULL){
        printf("%s %s: {", current->person->firstName, current->person->lastName);
        getFriends(current->person->email);
        
        printf("}\n");
        current = current->next;
    }
}

void printInfo(FILE* people, Node* this){
    fprintf(people, "%s, ", this->person->firstName);
    fprintf(people, "%s, ", this->person->lastName);
    fprintf(people, "%s, ", this->person->email);
    fprintf(people, "%s, ", this->person->age);
    fprintf(people, "%s, ", this->person->hometown);
    fprintf(people, "%s\n", this->person->hobby);
}

void saveNetwork(char* peopleFilename, char* connectionsFilename){
    FILE* friendf = fopen(peopleFilename, "w");
    if (friendf == NULL){
        printf("Creating friend file failed.\n");
        return;
    }
    Node* temp = FriendHead;
    while (temp!= NULL){
        printInfo(friendf, temp);
        temp = temp->next;
    }
    fclose(friendf);
    printf("Network file saved.\n");
    
    FILE* conf = fopen(connectionsFilename, "w");
    if (conf == NULL){
        printf("Creating connection file failed.\n");
        return;
    }
    connection* cursor = ConnectionHead;
    while (cursor!= NULL){
        fprintf(conf, "%s, %s\n", cursor->person1->email, cursor->person2->email);
        cursor = cursor->next;
    }
    fclose(conf);
    printf("Connection file saved.\n");

}

Person* create_person(char* line){
    Person* newGuy = malloc(sizeof(Person));
    const char com[2] = ", ";
    char* token;
    
    token = strtok(line, com);
    strcpy(newGuy->firstName, token);
    
    
    token = strtok(NULL, com);
    strcpy(newGuy->lastName, token);

    
    token = strtok(NULL, com);
    strcpy(newGuy->email, token);
    
    
    token = strtok(NULL, com);
    strcpy(newGuy->age, token);
    
    token = strtok(NULL, com);
    strcpy(newGuy->hometown, token);
    
    token = strtok(NULL, com);
    token[strlen(token)-1] = 0; //Deletes new line marker
    strcpy(newGuy->hobby, token);
    
    add_to_list(newGuy);
    
    return newGuy;
}

void makeconnections(char* filename){
    FILE* conFile = fopen(filename, "r");
    if (!conFile){
        printf("Connection file not found.");
        return;
    }
    
    char line[60];
    const char com[2] = ", ";
    fgets(line, 60, conFile);
    while(!feof(conFile)){
        char* email1 = strtok(line, com);
        char* email2 = strtok(NULL, com);
        email2[strlen(email2) -1]= 0; //Gets rid of new line marker
        
        connectFriend(email1, email2);
    
        fgets(line, 60, conFile);
    }
    
    fclose(conFile);
}

void retrieveNetwork(char* peopleFileName, char* connectionFileName){
    FILE* friendFile = fopen(peopleFileName, "r");
    if (!friendFile){
        printf("People file not found.");
        return;
    }
    char eachLine[300];
    fgets(eachLine, 150, friendFile);
    while(!feof(friendFile)){
         //each line now has the value of one person's entire info
        create_person(eachLine);
        fgets(eachLine, 150, friendFile);
    }
    
    fclose(friendFile);
   
    makeconnections(connectionFileName);
    // M myfriends.txt myconnections.txt
    printf("Network sucessfully retrieved.\n");
}

int main() {
    //make list of person structs
    FriendHead = NULL;
    ConnectionHead = NULL;
    
    char choice [5];
    printf("MENU:\nPress A to add person\nPress R to remove person\nPress E to edit an entry\nPress C to make a connection\nPress V to view each member and their connections\nPress D to remove a connection\nPress F to get the friends of a person\nPress S to save all connections to a file\nPress M to make a network from a retrieved file\nPress Q to quit\nNOTE: No data entry is permitted to have spaces. (Enter New York as NewYork.)\n");
    scanf("%s", choice);
    
    while (strcmp(choice, "Q") != 0){
        if (strcmp(choice, "A") == 0){
            printf("Enter the new member's email: ");
            char newEmail[30];
            scanf("%s", newEmail);
            add(newEmail);
        }
        else if (strcmp(choice, "R") == 0){
            printf("Enter the email you'd like to remove: ");
            char newEmail[30];
            scanf("%s", newEmail);
            remove_friend(newEmail);
        }
        else if (strcmp(choice, "E") == 0){
            printf("Enter the email of the person you'd like to edit: ");
            char newEmail[30];
            scanf("%s", newEmail);
            edit(newEmail);
        }
        else if (strcmp(choice, "C") == 0){
            printf("Enter the email of the first friend: ");
            char email1[30];
            scanf("%s", email1);
            
            printf("Enter the email of the second friend: ");
            char email2[30];
            scanf("%s", email2);
            connectFriend(email1, email2);
            printf("%s and %s are now friends.\n", findNode(email1)->person->firstName, findNode(email2)->person->firstName );
        }
        else if (strcmp(choice, "V") == 0){
            displayNetwork();
        }
        else if (strcmp(choice, "D") == 0){
            printf("Enter the email of the first friend to disconnect: ");
            char email1[30];
            scanf("%s", email1);
            
            printf("Enter the email of the second friend to disconnect: ");
            char email2[30];
            scanf("%s", email2);
            disconnect(email1, email2);
        }
        else if (strcmp(choice, "F") == 0){
            printf("Enter the email whose friends would you like to view: ");
            char email[30];
            scanf("%s", email);
            printf("%s is friends with: ", email);
            getFriends(email);
            printf("\n");
        }
        else if (strcmp(choice, "S") == 0){
            printf("What file would you like to save the network in? ");
            char friendfile[30];
            scanf("%s", friendfile);
            
            printf("What file would you like to save the connections in? ");
            char confile[30];
            scanf("%s", confile);
            
            saveNetwork(friendfile, confile);
        }
        else if (strcmp(choice, "M") == 0){
            printf("What file is each person's information in? ");
            char friendfile[30];
            scanf("%s", friendfile);
            
            printf("What file are the connections in? ");
            char confile[30];
            scanf("%s", confile);
            
            retrieveNetwork(friendfile, confile);
        }
        
        printf("Enter 'Q' to quit, or enter a new action choice (A, R, E, C, V, D, F, S, M)\n");
        scanf("%s", choice);
    }
    
    return 0;
}




