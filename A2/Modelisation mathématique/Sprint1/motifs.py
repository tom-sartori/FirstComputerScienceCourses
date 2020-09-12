#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 20:05:37 2020

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt 

orange = [255, 127, 0]; 
vert = [0, 255, 0]; 

tab = np.zeros((1, 1, 3), dtype=np.uint8); 
tab[0, 0] = orange; 



motif1 = orange * np.ones((3, 3, 3), dtype=np.uint8); # Image 3x3 tout orange
motif1[2, 2] = vert; 
#plt.imshow(motif1); # Premier motif challenge

motif1DoubleHaut = np.concatenate((motif1, np.fliplr(motif1)), axis =1); 
motif2 = np.concatenate((motif1DoubleHaut, np.flipud(motif1DoubleHaut))); 
#plt.imshow(motif2); # Deuxieme motif du challenge

motif3 = np.concatenate((motif2, motif2)); 
motif3 = np.concatenate((motif3, motif3, motif3), axis = 1); 
plt.imshow(motif3); # Troisieme motif du challenge