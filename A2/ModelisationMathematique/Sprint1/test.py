#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Sep 16 13:00:22 2020

@author: tom
"""

import numpy as np
import matplotlib.pyplot as plt


def aide() :
    bleu = np.array([30, 120, 180], dtype = np.uint8)
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    blanc = np.array([255, 255, 255], dtype = np.uint8)
    vert = np.array([45, 160, 45], dtype = np.uint8)
    orange = np.array([255, 130, 15], dtype = np.uint8)

    
    hauteur = 500
    largeur = 800
    
    aide = np.ones((hauteur, largeur, 3), dtype = np.uint8) * bleu
    
    I, J = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')


    # Affichage de courbes suivant différents axes
    # Par la suite, il suffit de modifier les coefficients
    aide[ (hauteur-I) == (J) ] = rouge
    aide[ (I) == (J) ] = bleu
    aide[ (I) == (largeur-J) ] = blanc
    aide[ (hauteur-I) == (largeur-J) ] = vert
    
    a = hauteur/2
    b = largeur/3 
    c = (largeur/3) *2
    
    rayonExt = 200
    rayonInt= 180
    
    # Coloration en orange de la partie souhaitée 
    # Le premier parametre correspond au contour du cercle exterrieur. On colorie donc ce qui est plus petit (à l'interrieur). 
    # Le deuxieme paramètre correspond à la limite interrieure. Le rayon est la moitié du rayon du grand cercle. 
    aide[ ( (np.power(I-a, 2)) <= (np.power(rayonExt, 2) - np.power(J-b, 2)) )  &  ( (np.power(I-a, 2)) >= (np.power(rayonInt, 2) - np.power(J-b, 2)) ) ] = orange
    
    aide[ ( (np.power(I-a, 2)) <= (np.power(rayonExt, 2) - np.power(J-c, 2)) )  &  ( (np.power(I-a, 2)) >= (np.power(rayonInt, 2) - np.power(J-c, 2)) ) ] = vert

    
    plt.imshow(aide)
    plt.show() 
    

aide()

