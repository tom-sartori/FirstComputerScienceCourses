#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 20:45:19 2020

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt 

gris = [128, 128, 128]; 
orange = [255, 127, 0]; 
vert = [0, 255, 0]; 
bleu = [0, 0, 255]; 

fond = np.ones((4, 6, 3), dtype=np.uint8) * gris; # Image avec fond gris

fond[:, 0] = bleu; # Barre bleue

fond [2, 4:] = vert; # S vert
fond[3, 3:5] = vert; 



def etape1() : 
    fond[:3, 1:4] = gris; # Remise à zero du gris
    fond[3, 2] = gris; 
    
    fond [:3, 1] = orange; # T orange
    fond [1, 2] = orange; 

    plt.imshow(fond); # Etape 1
    
    
def etape2(): 
    fond[:3, 1:4] = gris; # Remise à zero du gris
    fond[3, 2] = gris;
    
    fond [1, 1:4] = orange; # T orange
    fond[2, 2] = orange; 
    
    plt.imshow(fond); 
    
    
def etape3 ():
    fond[:3, 1:4] = gris; # Remise à zero du gris
    
    fond[2, 1:4] = orange; # T orange
    fond[3, 2] = orange; 
    
    plt.imshow(fond);
    


#etape1(); 
etape2(); 
#etape3(); 
