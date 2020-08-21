#include <stdio.h>

int main() {
  int a, *b;
  a = 12;
  b = &a;
  *b = a + 1;
  printf("a = %i, b = %lu\n", a, (long unsigned) b);
}
