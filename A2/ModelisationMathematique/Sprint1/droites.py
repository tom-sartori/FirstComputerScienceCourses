#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 22:46:47 2020

@author: tom
"""


import numpy as np 
import matplotlib.pyplot as plt 


def enveloppe() :
    bleu = np.array([30, 120, 180], dtype = np.uint8)
    vert = np.array([45, 160, 45], dtype = np.uint8)
    orange = np.array([255, 130, 15], dtype = np.uint8)
    gris = np.array([125, 125, 125], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    # Initialisation de l'enveloppe 
    enveloppe = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    # Création des matrices d'indices (lignes et colonnes)
    I, J = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')
    
    # Affectation des couleurs suivant les conditions
    enveloppe[ ((largeur / hauteur)*I <= J) &  ((largeur / hauteur)*I < (largeur - J)) ] = bleu
    enveloppe[ ((largeur / hauteur)*I <= J) & ((largeur / hauteur)*I > (largeur - J)) ] = orange
    enveloppe[ ((largeur / hauteur)*I >= J) &  ((largeur / hauteur)*I > (largeur - J)) ] = vert
    enveloppe[ ((largeur / hauteur)*I >= J) &  ((largeur / hauteur)*I < (largeur - J)) ] = gris
    
    plt.imshow(enveloppe)
    plt.show() 
    
def seychelles() :
    bleu = np.array([0, 60, 135], dtype = np.uint8)
    jaune = np.array([255, 215, 85], dtype = np.uint8)
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    blanc = np.array([255, 255, 255], dtype = np.uint8)
    vert = np.array([0, 120, 60], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    # Initialisation de l'enveloppe 
    enveloppe = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    # Création des matrices d'indices (lignes et colonnes)
    I, J = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')
    
    # Affectation des couleurs suivant les conditions
    #enveloppe[ ( (I*2) > (largeur - (J*3))   ) ] = orange
    #enveloppe[ ((largeur / hauteur)*I >= J) &  ((largeur / hauteur)*I > (largeur - J)) ] = vert
    #enveloppe[ (I >= J) &  (I <= (largeur - J)) ] = gris
    enveloppe[ (I*2) <= largeur ] = vert
    enveloppe[  ((I*2) <= (largeur - (J*0.2) ) ) ] = blanc
    enveloppe[ (I*2) <= (largeur - (J*0.5) ) ] = rouge
    enveloppe[  ((I*2) <= (largeur - (J*1.2) ) ) ] = jaune
    enveloppe[ (I*2) <= (largeur - (J*3) ) ] = bleu

    
    plt.imshow(enveloppe)
    plt.show() 

enveloppe()
seychelles()















