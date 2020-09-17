#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 22:46:47 2020

@author: tom
"""


import numpy as np 
import matplotlib.pyplot as plt 


def enveloppe() :
    bleu = np.array([0, 0, 255], dtype = np.uint8)
    vert = np.array([0, 255, 0], dtype = np.uint8)
    orange = np.array([255, 127, 0], dtype = np.uint8)
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
    enveloppe[ ((largeur / hauteur)*I <= J) &  ((largeur / hauteur)*I <= (largeur - J)) ] = bleu
    enveloppe[ ((largeur / hauteur)*I <= J) & ((largeur / hauteur)*I > (largeur - J)) ] = orange
    enveloppe[ ((largeur / hauteur)*I >= J) &  ((largeur / hauteur)*I > (largeur - J)) ] = vert
    enveloppe[ ((largeur / hauteur)*I >= J) &  ((largeur / hauteur)*I <= (largeur - J)) ] = gris
    
    plt.imshow(enveloppe)
    plt.show() 

enveloppe()