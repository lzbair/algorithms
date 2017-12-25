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

void* fromEnd(int position, LinkedList* list){
	int size = length(list);
	if(position < 0 || position > size - 1 ) {
		return NULL;
	}
	return get(size - position - 1, list);
}

LinkedList* track(LinkedList* list, LinkedList* tracker){
	if(list == NULL){
		return tracker;
	}else {
		track((*list).tail, (*tracker).tail);
	}
}

LinkedList* subList(int from, LinkedList* list){
	if(from == 0){
		return list;
	}else {
		subList(--from, (*list).tail);
	}
}


void* optimized_fromEnd(int position, LinkedList** list){
	LinkedList* sub = subList(++position, *list);

	LinkedList* result = track(sub, *list);
	return (*result).head;
}


