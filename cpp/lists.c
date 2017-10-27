#include <stdio.h>
#include <stdlib.h>
#include "lists.h"

struct LinkedList {
  void* head;
  LinkedList* tail;
};

LinkedList* prepend(void* head, LinkedList* tail){
	LinkedList* list = malloc(sizeof(LinkedList));
    (*list).head = head;
	(*list).tail = tail;
    return list;
}

void* get(int index, LinkedList* list){
    LinkedList* current = list;
    int i;
    for(i = 0; i < index; i++){
        current = (*list).tail;
    }
    return (*current).head;
}



