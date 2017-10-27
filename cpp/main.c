#include <stdio.h>
#include <stdlib.h>
#include "lists.h"

int main(){
	int head = 9;
	int next = 5;
	LinkedList* tail = prepend(&next, NULL);
	LinkedList* list = prepend(&head, tail);
	int* value = (int*)get(1, list);
	printf("%d\n", *value);
	free(tail);
	free(list);
}




