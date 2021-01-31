#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Nov  4 09:48:03 2020

@author: tom
"""

import numpy as np
import matplotlib.pyplot as plt


# On se place dans un repère orthonormé avec comme unité le pixel. 
def formes(): 
    # Enveloppe, on démare au point en haut à gauche (-1 ; 0)
    plt.plot([-3, -1, -1, -3, -3, -2, -1], [0, 0, -2, -2, 0, -1, 0])
    
    # Tétris, on commence, en bas à gauche (-4 ; 2)
    plt.plot([-4, -4, -3, -3, -2, -2, -1, -1, -4], [2, 3, 3, 4, 4, 3, 3, 2, 2])
    
    # Maison, on commence en (0 ; 4)
    plt.plot([0, 2, 4, 0, 0, 3, 3, 2, 2, 4, 4], [4, 6, 4, 4, 0, 0, 2, 2, 0, 0, 4])
    
    # Cercle en (7 ; 2)
    theta = np.linspace(0, 2*np.pi, 101)
    x = np.cos(theta) + 7;
    y = np.sin(theta) + 2;
    plt.plot(x, y, linewidth=1);
    
    
    # L couché en violet, on commence en (-2 ; 1)
    plt.plot([2, 2, 5, 5, 6, 6, 2], [-3, -2, -2, -1, -1, -3, -3])
    
    
    # Cercle en (7 ; 2)
    theta = np.linspace(0, 2*np.pi);
    x = np.cos(theta) + 7;
    y = np.sin(theta) + 2;
    plt.plot(x, y, linewidth=1);
    
    
    # Motif en rouge, on commence en (7 ; -1)
    plt.plot([7, 10, 10, 7, 7, 7, 10, 10, 9, 9, 8, 8], [-1, -1, -3, -3, -1, -2, -2, -1, -1, -3, -3, -1])

    
    plt.axis("equal")
    plt.show


formes()