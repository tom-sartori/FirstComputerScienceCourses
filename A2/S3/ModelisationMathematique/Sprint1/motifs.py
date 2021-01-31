#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 20:05:37 2020

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt 

orange = [255, 127, 0]
vert = [0, 255, 0]

# Fonctionne avec n'importe quelle hauteur. 
# Il est preferable d'avoir un multiple de 
# trois car on va diviser l'image en trois. 
hauteur = 99


# Premier motif du challenge. 
motif1 = np.ones( (hauteur, hauteur, 3), dtype=np.uint8 ) * orange # Image 3x3 tout orange
motif1[(hauteur/3) *2:, (hauteur/3) *2:] = vert

plt.imshow(motif1) # Affichage 
plt.show()


# Deuxième motif du challenge. 
# Pour la partie du haut, on concatene deux motif1
# dont un avec un flip vertical. 
motif1DoubleHaut = np.concatenate((motif1, motif1[:, ::-1]), axis =1) 
# Pour le carré, on concatene deux parties hautes
# dont une, avec un flip horizontal. 
motif2 = np.concatenate((motif1DoubleHaut, motif1DoubleHaut[::-1, :]) )

plt.imshow(motif2) # Affichage 
plt.show()


# Troisième motif du challenge. 
# Concatenation verticale. 
motif3 = np.concatenate( (motif2, motif2) ) 
# Puis, triple concatenation horizontale du precedent. 
motif3 = np.concatenate( (motif3, motif3, motif3), axis = 1 ) 

plt.imshow(motif3) # Affichage 
plt.show()