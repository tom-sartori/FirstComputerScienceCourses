#include <stdlib.h>
#include <stdio.h>
#include <netdb.h>
#include <fcntl.h>
#include <string.h> // chaines de caracteres
#include <sys/socket.h> // interface socket
#include <netinet/in.h> // gestion adresses ip
#include <sys/types.h>

#define SERV "127.0.0.1" // adresse IP = boucle locale
#define PORT 11345  // port d’ecoute serveur
int port,sock;
char mess[81];   // n°port et socket
char rep[81];
struct sockaddr_in
struct hostent

creer_socket()
//==============
{

port = PORT;

// chaine de caracteres // chaine de caracteres
serv_addr; // zone adresse *server; // nom serveur
server = gethostbyname(SERV); // verification existance adresse
if (!server){fprintf(stderr, "Problème serveur \"%s\"\n", SERV);exit(1);}
// creation socket locale
sock = socket(AF_INET, SOCK_STREAM, 0); // AF_INET=famille internet
// SOCK_STREAM= mode connecte­TCP bzero(&serv_addr, sizeof(serv_addr)); // preparation entete
serv_addr.sin_family = AF_INET; // Type d’adresses bcopy(server­>h_addr, &serv_addr.sin_addr.s_addr,server­>h_length);
serv_addr.sin_port = htons(port);
main()
//==========
{ // creation socket
// port  du serveur
}
creer_socket();
// connexion au serveur
if (connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr))
< 0)
{perror("Connexion impossible:");exit(1);}
printf ("connexion avec serveur ok\n");
//dialogue avec le serveur
strcpy(mess,"");
while (strncmp(mess,"fin",3)!=0) { printf ("Question : ");
gets(mess); write(sock,mess,strlen(mess));

printf ("message : %s\n",mess);
int nb = read (sock,rep,80); rep[nb] = '\0';
printf ("Reponse : %s\n",rep);
}
close (sock);
}
