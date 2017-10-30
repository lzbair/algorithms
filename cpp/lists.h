
struct SLinkedList {
  void* head;
  struct SLinkedList* tail;
};

typedef struct SLinkedList LinkedList;
LinkedList* prepend(void* head, LinkedList* tail);
void* get(int index, LinkedList* list);
int length(LinkedList* list);
void put(void* element, LinkedList** list, int position);
void delete(LinkedList** list, int position);