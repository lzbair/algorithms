#include <stdlib.h>
#include "lists.h"

LinkedList* prepend(void* head, LinkedList* tail){
	LinkedList* list = malloc(sizeof(LinkedList));
    (*list).head = head;
	(*list).tail = tail;
    return list;
}

void* get(int index, LinkedList* list){
	if(index == 0) return (*list).head;
	return get(--index, (*list).tail);
}

int length(LinkedList* list){
	if(list == NULL) return 0;
	return 1 + length((*list).tail);
}

void put(void* element, LinkedList** list, int position){
	if(position == 0) {
		LinkedList* newList = malloc(sizeof(LinkedList));
		(*newList).head = element;
		(*newList).tail = *list;
		*list = newList;
	}else {
		put(element, &((*list)->tail), --position);
	}
}

void delete(LinkedList** list, int position){
	if(position == 0) {
		*list = (*list)->tail;
	}else {
		delete(&((*list)->tail), --position);
	}
}


