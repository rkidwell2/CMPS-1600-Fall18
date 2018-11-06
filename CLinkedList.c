/*
 
 Warm-up response:
 The * represents a pointer to a variable.
 & marks that we are looking at the memory address of a variable.
 */


#include <stdio.h>
#include <stdlib.h>

typedef struct list_node{
	int data;
	struct list_node* next;
} ListNode;


void addToStart(ListNode* head, int newData ){
    //Passes the reference to the start of the list, and the data the new node will hold

    ListNode* temp = NULL;
    temp = (ListNode*)malloc(sizeof(ListNode));

    temp->data = head->data;
    temp->next = head->next;

    head->next = temp;
    head->data = newData;

}

void removeHead(ListNode* head){
    //Passes the reference to the start of the list and removes it, making the next item the head
    ListNode* temp = NULL;
    temp = (ListNode*)malloc(sizeof(ListNode));

    temp->data = head->data;
    temp->next = head->next;

    head->data = temp->next->data;
    head->next = temp->next->next;

    free(temp);

}

int main()
{
	ListNode* head = NULL;
    ListNode* second = NULL;

    head = (ListNode*)malloc(sizeof(ListNode));
    second = (ListNode*)malloc(sizeof(ListNode));

    head->data = 1;
    second->data = 2;

    head->next = second;

    printf("List: %d, %d\n", head->data, head->next->data);

	addToStart(head, 8);

    printf("List: %d, %d, %d\n", head->data, head->next->data, head->next->next->data);

    addToStart(head, 15);

    printf("List: %d, %d, %d, %d \n", head->data, head->next->data, head->next->next->data, head->next->next->next->data);

    removeHead(head);

    printf("List: %d, %d, %d\n", head->data, head->next->data, head->next->next->data);


    return 0;
}

