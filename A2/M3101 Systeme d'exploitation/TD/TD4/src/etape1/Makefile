myalloc_1 :	malloctest.o myalloc-1.o
	gcc -g -o myalloc-1.testme myalloc-1.o malloctest.o

malloctest.o : malloctest.c
	gcc -g -c malloctest.c

myalloc-1.o : myalloc-1.c ../generic/myalloc.h ../generic/entete_size.h ../generic/align.h myfree-1.c.inc myalloc-1.c.inc blocinfo-1.c.inc
	gcc -g -c myalloc-1.c

clean:
	rm *.o *.testme