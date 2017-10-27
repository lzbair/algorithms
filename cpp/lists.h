#include <stdio.h>
#include <stdlib.h>
typedef struct LinkedList LinkedList;
LinkedList* prepend(void* head, LinkedList* tail);
void* get(int index, LinkedList* list);