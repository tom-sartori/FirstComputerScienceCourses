#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Mon Sep  7 16:21:36 2020

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt 

# Importation de l'image en une matrice tridimensionnelle. 
knight = plt.imread('/Users/Tom/dark-knight.png', 'PNG')

plt.imshow (knight) # Affichage
plt.show()


flipHorizontal = knight[::-1, :]
# flipHorizontal = np.fliplr(knight) # Autre méthode avec fonction fliplr

plt.imshow (flipHorizontal)
plt.show()


flipVertical = knight[:, ::-1]
# flipVertical = np.flipud(knight)  # Résultat similaire 

plt.imshow (flipVertical)
plt.show()


double = np.concatenate( (knight, knight), axis=1 )
quadruple = np.concatenate( (double, np.flipud(double)) )
plt.imshow (quadruple)
plt.show()
