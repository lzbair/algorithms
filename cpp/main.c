#include <stdio.h>
#include <stdlib.h>
#include "lists.h"

int main(){
	int head = 9;
	int next = 5;
	int other = 3;
	LinkedList* tail = prepend(&next, NULL);
	LinkedList* list = prepend(&head, tail);
	put(&other, &list, 2);
	int* value = (int*)get(2, list);
	printf("%d\n", *value);
	printf("Size is: %d\n", length(list));
	delete(&list, 1);
    printf("Size after deletion is: %d\n", length(list));
	free(tail);
	free(list);
}




