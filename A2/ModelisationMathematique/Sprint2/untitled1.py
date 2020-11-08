#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Nov  4 09:48:03 2020

@author: tom
"""

import numpy as np
import matplotlib.pyplot as plt

bleu = np.array([30, 120, 180], dtype = np.uint8)
orange = np.array([255, 130, 15], dtype = np.uint8)
vert = np.array([45, 160, 45], dtype = np.uint8)




def cercle(): # avec plot

    theta = np.linspace(0, 2*np.pi);
    
    x = np.cos(theta);
    y = np.sin(theta);
    plt.plot(x, y, linewidth=1, color='orange');
    
    plt.axis("equal");
    plt.xlim(-1.25, 1.25); 
    plt.ylim(-1.5, 1.5);
    
    plt.show();



def test(): 
    # Enveloppe, on démare au point en haut à gauche (-1 ; 0)
    plt.plot([-3, -1, -1, -3, -3, -2, -1], [0, 0, -2, -2, 0, -1, 0])
    
    # Tétris, on commence, en bas à gauche (-4 ; 2)
    plt.plot([-4, -4, -3, -3, -2, -2, -1, -1, -4], [2, 3, 3, 4, 4, 3, 3, 2, 2])
    
    # Maison, on commence en (0 ; 4)
    plt.plot([0, 2, 4, 0, 0, 3, 3, 2, 2, 4, 4], [4, 6, 4, 4, 0, 0, 2, 2, 0, 0, 4])
    
    # Cercle en (7 ; 2)
    theta = np.linspace(0, 2*np.pi);
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
    
    
    # Motif en rouge, on commence en (7 ; -2)
    plt.plot([7, 7, 8, 8, 7], [-2, -1, -1, -2, -2])

    
    plt.axis("equal")
    plt.show



    

cercle()
test()