#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 21:47:05 2020

@author: tom
"""

import numpy as np
import matplotlib.pyplot as plt

bleu = np.array([30, 120, 180], dtype = np.uint8)
orange = np.array([255, 130, 15], dtype = np.uint8)
vert = np.array([45, 160, 45], dtype = np.uint8)


def quartDeCercle(): # On se place dans un repère xy avec l'origine en haut à gauche et le pixel comme unité. 
    
    hauteur = 500
    largeur = 500
    
    # Initialisation avec fond bleu
    quart = np.ones((hauteur, largeur, 3), dtype = np.uint8) * bleu 
    
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')

    a = hauteur #Comme l'origine est en haut à gauche, on modifie le centre du cercle pour qu'il soit en bas à gauche. 
    b = 0
    rayon = 500
    
    # Equation d'un cercle : (x-a)^2 + (y-b)^2 = r^2 
    # donc ici : np.power(x-a, 2) + np.power(y-b, 2) = np.power(rayon, 2)
    # Avec colorisation en orange de la zone souhaitée
    quart[ (np.power(x-a, 2)) <= (np.power(rayon, 2) - np.power(y-b, 2)) ] = orange
    

    plt.imshow(quart)
    plt.show() 
    
    
    
def quartDeCercle2(): # avec plot
    
    quartCercle = plt.Circle((0, 0), 1, color='orange');
    
    fig, ax = plt.subplots();
    
    plt.xlim(0, 1); # Zone d'affichage
    plt.ylim(0, 1); 
        
    ax.set_aspect(1); # Repere orthonormé
    
    ax.add_artist(quartCercle);
        
    plt.show();



def donut() :
    
    hauteur = 500
    largeur = 500
    
    donut = np.ones((hauteur, largeur, 3), dtype = np.uint8) * bleu
    
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')
    
    a = hauteur/2 #Comme l'origine est en haut à gauche, on modifie le centre du cercle pour qu'il soit au milieu. 
    b = largeur/2
    rayon = 200
    
    
    # Equation d'un cercle : (x-a)^2 + (y-b)^2 = r^2 
    # donc ici : np.power(x-a, 2) + np.power(y-b, 2) = np.power(rayon, 2)
    
    # Coloration en orange de la partie souhaitée 
    # Le premier parametre correspond au contour du cercle exterrieur. On colorie donc ce qui est plus petit (à l'interrieur). 
    # Le deuxieme paramètre correspond à la limite interrieure. Le rayon est la moitié du rayon du grand cercle. 
    donut[ ( (np.power(x-a, 2)) <= (np.power(rayon, 2) - np.power(y-b, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayon/2, 2) - np.power(y-b, 2)) ) ] = orange
    

    plt.imshow(donut)
    plt.show() 
    
    
    
def donutXY() :
    
    hauteur = 500
    largeur = 500
    
    donut = np.ones((hauteur, largeur, 3), dtype = np.uint8) * bleu
    
    X = np.arange(largeur)
    Y = np.arange(hauteur)
    Y = Y[::-1]
    
    x, y = np.meshgrid(\
                        X,\
                        Y,\
                        indexing = 'ij')
    
    a = hauteur/2 #Comme l'origine est en haut à gauche, on modifie le centre du cercle pour qu'il soit au milieu. 
    b = largeur/2
    rayon = 200
    
    
    # Equation d'un cercle : (x-a)^2 + (y-b)^2 = r^2 
    # donc ici : np.power(x-a, 2) + np.power(y-b, 2) = np.power(rayon, 2)
    
    # Coloration en orange de la partie souhaitée 
    # Le premier parametre correspond au contour du cercle exterrieur. On colorie donc ce qui est plus petit (à l'interrieur). 
    # Le deuxieme paramètre correspond à la limite interrieure. Le rayon est la moitié du rayon du grand cercle. 
    donut[ ( (np.power(x-a, 2)) <= (np.power(rayon, 2) - np.power(y-b, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayon/2, 2) - np.power(y-b, 2)) ) ] = orange
    

    plt.imshow(donut)
    plt.show() 
    
    
def donut2(): # avec plot

    theta = np.linspace(0, 2*np.pi);
    
    x = np.cos(theta);
    y = np.sin(theta);
    plt.plot(x, y, linewidth=50, color='orange');
    plt.axis("equal");
    
    plt.xlim(-1.25, 1.25); 
    plt.ylim(-1.5, 1.5);
    
    plt.show(); 
    
    
    
def anneaux() :
    
    hauteur = 500
    largeur = 800
    
    anneaux = np.ones((hauteur, largeur, 3), dtype = np.uint8) * bleu
    
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')

    
    a = largeur/3 #Comme l'origine est en haut à gauche, on modifie le centre de chaque cercle à notre convenance. 
    b = hauteur/2
    c = (largeur/3) *2
    
    rayonExt = 200
    rayonInt= 180
    
    
    # Equation d'un cercle : (x-a)^2 + (y-b)^2 = r^2 
    # donc ici : np.power(x-a, 2) + np.power(y-b, 2) = np.power(rayon, 2)
    
    # Coloration en orange de la partie souhaitée 
    # Le premier parametre correspond au contour du cercle exterrieur. On colorie donc ce qui est plus petit (à l'interrieur). 
    # Le deuxieme paramètre correspond à la limite interrieure. Le rayon est la moitié du rayon du grand cercle. 
    #anneaux[ ( (np.power(x-a, 2)) <= (np.power(rayonExt, 2) - np.power(y-b, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayonInt, 2) - np.power(y-b, 2)) ) ] = orange
    #anneaux[ ( (np.power(x-a, 2)) <= (np.power(rayonExt, 2) - np.power(y-c, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayonInt, 2) - np.power(y-c, 2)) ) ] = vert

    # Coloration en orange du demi cercle du haut
    anneaux[ ( (np.power(x-a, 2)) <= (np.power(rayonExt, 2) - np.power(y-b, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayonInt, 2) - np.power(y-b, 2)) ) & (x >= hauteur/2) ] = orange
    
    # Coloration du cercle vert
    anneaux[ ( (np.power(x-a, 2)) <= (np.power(rayonExt, 2) - np.power(y-c, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayonInt, 2) - np.power(y-c, 2)) ) ] = vert
    
    # Coloration en orange du demi cercle du bas
    anneaux[ ( (np.power(x-a, 2)) <= (np.power(rayonExt, 2) - np.power(y-b, 2)) )  &  ( (np.power(x-a, 2)) >= (np.power(rayonInt, 2) - np.power(y-b, 2)) ) & (x <= hauteur/2)] = orange

    
    plt.imshow(anneaux)
    plt.show() 
    

    
    
quartDeCercle(); 
donut(); 
donutXY();
anneaux(); 














 
    