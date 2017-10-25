#include <stdlib.h>
struct LinkedList {
  void* head;
  LinkedList* tail;
};

LinkedList prepend(void* head, LinkedList* tail){
    LinkedList list = {head, tail};
    return list;
}

void* get(int index, LinkedList* list){
    LinkedList* current = (LinkedList *)malloc(sizeof(LinkedList));
    current = list;
    int i;
    for(i = 0; i < index; i++){
        current = (*list).tail;
    }
    void* result = (*current).head;
    free(current);
    return result;
}

int head = 9;
int next = 5;
LinkedList tail = prepend(&next, NULL);
LinkedList list = prepend(&head, &tail);
int* value = get(1, &list);
printf("%d\n", *value);


