int lireligne(int fd, char *s, int size) {
   char c; // caractere lu
   int i; // indice dans la chaine s
   int r; // octets lus par read

   for (i = 0; i < size; i++) {
     r = read(fd, &c, 1);
     if (r == -1) { // erreur de lecture
       return -1;
       } else if (r == 0) { // fin du fichier
           break;
         } else { // un nouveau caractere lu
       s[i] = c;
       }
     if (c == '\n') {
        // fin de ligne : on passe a l'indice
        // suivant et on arrete la lecture
       i++;
       break;
      }
    }
   return i;
 }
