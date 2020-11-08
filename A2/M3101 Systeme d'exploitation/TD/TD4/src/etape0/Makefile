myalloc_0 :	malloctest.o myalloc-0.o
	gcc -g -o myalloc-0.testme myalloc-0.o malloctest.o

malloctest.o : malloctest.c
	gcc -g -c malloctest.c

myalloc-0.o : myalloc-0.c ../generic/myalloc.h ../generic/entete_size.h ../generic/align.h myfree-0.c.inc myalloc-0.c.inc blocinfo-0.c.inc
	gcc -g -c myalloc-0.c

clean:
	rm *.o *.testme