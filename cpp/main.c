#include <stdio.h>
#include <stdlib.h>
#include "lists.h"

void print(LinkedList* list){
	if(list == NULL){
		printf("\n");
		return;
	}else {
	  int* val = (*list).head;
	  printf("%d ", *val);
	  print((*list).tail);
	}
}

int main(){
	int head = 9;
	int next = 5;
	int other = 3;
	LinkedList* tail = prepend(&next, NULL);
	LinkedList* list = prepend(&head, tail);
	put(&other, &list, 2);
	
	printf("list --> "); print(list);
	
	int* value = (int*)get(2, list);
	printf("get(2, list) --> %d\n", *value);
	
    int* endValue = (int*)fromEnd(1, list);
	printf("fromEnd(1, list) --> %d\n", *endValue);
	
	printf("optimized_ fromEnd(1, list) --> %d\n", (*(int*)optimized_fromEnd(1, &list)));
	
	
	printf("length(list) --> %d\n", length(list));
	delete(&list, 1);
    printf("delete(&list, 1) & length(list) -->  %d\n", length(list));
	free(tail);
	free(list);
}






