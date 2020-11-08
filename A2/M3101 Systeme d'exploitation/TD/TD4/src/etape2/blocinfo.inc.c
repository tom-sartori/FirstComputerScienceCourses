void blocinfo(void* ptr)
{
 bloc_entete* bloc_total= (bloc_entete*) ((char*)ptr - ENTETE_SIZE);
 printf("pointeur bloc %p \npointeur donnees %p\ntaille%d\n",
	bloc_total,
	ptr,
	bloc_total->taille);
}
