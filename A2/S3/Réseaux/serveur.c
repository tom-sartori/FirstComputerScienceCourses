#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <string.h>
#include <netinet/in.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <strings.h>
#include <unistd.h>
#define PORT 12345

int sock, socket2, lg;
char mess[80];
struct sockaddr_in local;
struct sockaddr_in distant; // champs d entete distant

void creer_socket() {
    // preparation des champs d entete
    bzero(&local, sizeof(local));       // mise a zero de la zone adresse
    local.sin_family = AF_INET;         // famille d adresse internet
    local.sin_port = htons(PORT);       // numero de port
    local.sin_addr.s_addr = INADDR_ANY; // types d adresses prises en charge
    bzero(&(local.sin_zero),8);         // fin de remplissage


    lg = sizeof(struct sockaddr_in);
    if ((sock = socket(AF_INET, SOCK_STREAM, 0)) == -1)
    if((sock==socket (AF_INET, SOCK_STREAM,0))==-1){perror("socket");exit(1);} // creation socket du serveur mode TCP/IP
    if(bind(sock,(struct sokaddr * )local, sizeof(struct sockadr))==-1){perror("bind") ; exit(1);} // nommage de la socket
}

int main() {
    creer_socket();     // creation socket
    if(listen(sock, 5) == -1) {     // mise a l ecoute
        perror("listen");
        exit(1);
    }

    // boucle sans fin pour la gestion des connexions
    while(1) {
        // attente connexion client
        printf ("En attente d un client\n");
        if((socket2=accept(sock,(struct sockaddr *)&distant,&lg))==-1){perror("accept");exit(1);}
        printf ("client connecte \n");
        strcpy(mess,"");
        while (strncmp(mess,"fin",3)!=0) {
            read(socket2,mess,80);
            printf ("le client me dit %s \n",mess);
            write(socket2, "message recu !",80);
        }
        close(socket2); // on lui ferme la socket
    }
}