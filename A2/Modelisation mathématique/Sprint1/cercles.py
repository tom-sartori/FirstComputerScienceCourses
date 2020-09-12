#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sat Sep 12 21:47:05 2020

@author: tom
"""

import numpy as np
import matplotlib.pyplot as plt



def quartDeCercle(): 
    quartCercle = plt.Circle((0, 0), 1, color='orange');
    
    fig, ax = plt.subplots();
    
    plt.xlim(0, 1); # Zone d'affichage
    plt.ylim(0, 1); 
        
    ax.set_aspect(1); # Repere orthonormé
    
    ax.add_artist(quartCercle);
        
    plt.show();
    



def donut(): 

    theta = np.linspace(0, 2*np.pi);
    
    x = np.cos(theta);
    y = np.sin(theta);
    plt.plot(x, y, linewidth=50, color='orange');
    plt.axis("equal");
    
    plt.xlim(-1.25, 1.25); 
    plt.ylim(-1.5, 1.5);
    
    plt.show(); 
    
#quartDeCercle(); 
#donut(); 
    