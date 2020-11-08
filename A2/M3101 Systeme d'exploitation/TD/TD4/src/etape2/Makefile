myalloc_2 :	malloctest.o myalloc.o
	gcc -g -o myalloc-2.testme myalloc.o malloctest.o

malloctest.o : malloctest.c
	gcc -g -c malloctest.c

myalloc.o : myalloc.c ../generic/myalloc.h ../generic/entete_size.h ../generic/align.h myfree.inc.c myalloc.inc.c blocinfo.inc.c
	gcc -g -c myalloc.c

clean:
	rm *.o *.testme