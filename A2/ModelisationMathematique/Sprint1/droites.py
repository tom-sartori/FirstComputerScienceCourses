#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 22:46:47 2020

@author: tom
"""


import numpy as np 
import matplotlib.pyplot as plt 


def enveloppe() : # On se place dans un repère xy avec l'origine en haut à gauche et le pixel comme unité. 
    bleu = np.array([30, 120, 180], dtype = np.uint8)
    vert = np.array([45, 160, 45], dtype = np.uint8)
    orange = np.array([255, 130, 15], dtype = np.uint8)
    gris = np.array([125, 125, 125], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    # Initialisation de l'enveloppe 
    enveloppe = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    # Création des matrices d'indices (lignes et colonnes)
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')
    
    # Affectation des couleurs suivant les conditions
    enveloppe[ ( (2 * x) <= y )  &  ( (2 * x) <= (largeur - y) ) ] = bleu
    enveloppe[ ( (2 * x) < y )  &  ( (2 * x) > (largeur - y) ) ] = orange
    enveloppe[ ( (2 * x) >= y )  &  ( (2 * x) >= (largeur - y) ) ] = vert
    enveloppe[ ( ((largeur / hauteur) * x) > y )  &  ( ((largeur / hauteur) * x) < (largeur - y) ) ] = gris # Equivalent à "2*I" avec ces longueures
    
    plt.imshow(enveloppe)
    plt.show() 
    

    
def seychelles() : # On se place dans un repère xy avec l'origine en haut à gauche et le pixel comme unité. 
    bleu = np.array([0, 60, 135], dtype = np.uint8)
    jaune = np.array([255, 215, 85], dtype = np.uint8)
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    blanc = np.array([255, 255, 255], dtype = np.uint8)
    vert = np.array([0, 120, 60], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    # Initialisation  
    seychelles = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    # Création des matrices d'indices (lignes et colonnes)
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')

    
    seychelles[ (hauteur-x) * 0.8 >= y ] = bleu
    seychelles[ ( (hauteur-x) * 0.8 < y )  &  ( (hauteur-x) * 1.75 >= y ) ] = jaune
    seychelles[ ( (hauteur-x) * 1.75 < y )  &  ( (hauteur-x) * 3.25 >= y ) ] = rouge
    seychelles[ ( (hauteur-x) * 3.25 < y )  &  ( (hauteur-x) * 6 >= y ) ] = blanc
    seychelles[ (hauteur-x) * 6 < y ] = vert


    plt.imshow(seychelles)
    plt.show() 



def trinidad (): # On se place dans un repère xy avec l'origine en haut à gauche et le pixel comme unité. 
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    blanc = np.array([255, 255, 255], dtype = np.uint8)
    noir = np.array([0, 0, 0], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    # Initialisation 
    trinidad = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    # Création des matrices d'indices (lignes et colonnes)
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')    
    
    trinidad[ (1.25 * x) >= (y) ] = rouge # Coin rouge gauche
    trinidad[ ( (1.25 * x) < (y) )  &  ( (1.25 * x)+50 >= (y) ) ] = blanc # Blanc de gauche

    trinidad[ ( (1.25 * x)+50 < (y) )  &  ( (hauteur-x +50) * 1.25 <= (largeur-y) ) ] = noir # Milieu
    
    trinidad[ ( (hauteur-x +50) * 1.25 >= (largeur-y) )  &  ( (hauteur-x) * 1.25 < (largeur-y) ) ] = blanc # Blanc de droite
    trinidad[ (hauteur-x) * 1.25 >= (largeur-y) ] = rouge # Coin rouge droit


    plt.imshow(trinidad)
    plt.show()



def aideIJ() : # On se place dans un repère xy avec l'origine en haut à gauche et le pixel comme unité. 
    bleu = np.array([0, 60, 135], dtype = np.uint8)
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    blanc = np.array([255, 255, 255], dtype = np.uint8)
    vert = np.array([0, 120, 60], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    aide = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    x, y = np.meshgrid(\
                        np.arange(hauteur),\
                        np.arange(largeur),\
                        indexing = 'ij')


    # Affichage de courbes suivant différents axes
    # Par la suite, il suffit de modifier les coefficients
    aide[ (hauteur-x) == (y) ] = rouge
    aide[ (x) == (y) ] = bleu
    aide[ (x) == (largeur-y) ] = blanc
    aide[ (hauteur-x) == (largeur-y) ] = vert
    
    
    plt.imshow(aide)
    plt.show() 
    
    
    
def aideXY() : # On se place dans un repère xy avec l'origine en bas à gauche et le pixel comme unité. 
    bleu = np.array([0, 60, 135], dtype = np.uint8)
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    blanc = np.array([255, 255, 255], dtype = np.uint8)
    vert = np.array([0, 120, 60], dtype = np.uint8)
    
    hauteur = 400
    largeur = 800
    
    aide = np.zeros((hauteur, largeur, 3), dtype = np.uint8)
    
    X = np.arange(largeur)
    Y = np.arange(hauteur) 
    Y = Y[::-1]
    
    x, y = np.meshgrid(\
                        X,\
                        Y,\
                        indexing = 'xy')

    
    # Affichage de courbes suivant différents axes
    # Par la suite, il suffit de modifier les coefficients
    aide[ (hauteur-x) == (y) ] = rouge
    aide[ (x) == (y) ] = bleu
    aide[ (x) == (largeur-y) ] = blanc
    aide[ (hauteur-x) == (largeur-y) ] = vert
    
    # aide[ (3*x)+1 == (y) ] = bleu # Droite d'équation 3x+1 = y
    
    
    plt.imshow(aide)
    plt.show() 


#aideIJ()
aideXY()
enveloppe()
seychelles()
trinidad()

