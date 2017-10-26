#include <stdio.h>
#include <stdlib.h>
struct LinkedList {
  void* head;
  LinkedList* tail;
};

LinkedList* prepend(void* head, LinkedList* tail){
	LinkedList* list = (LinkedList *)malloc(sizeof(LinkedList));
    *list = {head, tail};
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

int main(){
	int head = 9;
	int next = 5;
	LinkedList* tail = prepend(&next, NULL);
	LinkedList* list = prepend(&head, tail);
	int* value = (int*)get(0, list);
	printf("%d\n", *value);
	free(tail);
	free(list);
}




