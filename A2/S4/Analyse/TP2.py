#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Mar 26 13:32:26 2021

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt


def traceur (P): 
    B = np.array(
        [[1, -3, 3, -1], 
         [0, 3, -6, 3], 
         [0, 0, 3, -3], 
         [0, 0, 0, 1]]
        )
    
    T = np.linspace(0, 1, 1001)
    
    Vect = np.array([np.ones(1001), T, T**2, T**3])
    
    res = np.dot(P, np.dot(B, Vect))
    
    plt.plot(res[0,:], res[1, :])
    return res; 


M = np.array (
    [[0., 2.5, 8, 9, 9, 10, 11, 12, 12, 11.6, 11, 10.5, 10.5, 10, 8.5, 7.8, 7.8, 6.5, 3.8, 2.3, 2.3, 1.8, 1.8, 2.2, 2.2, 1.54, 0.88, 0], 
     [5, 0, 0, 5, 5, 5, 5, 5, 5, 5.2, 5.5, 5.7, 5.7, 7.3, 7.3, 6, 6, 3.5, 3.5, 7, 7, 6, 5.4, 4, 4, 4.3, 4.6, 5]]
    )

def tr(M): 
    
    for i in  range(7) : 
        p = M[0:,i*4:i*4+4]
        traceur(p)    
    
tr(M)

    
def transformation(M, A): 
    MH = np.concatenate((M,np.ones((1, 28))),axis = 0)
    
    N = np.dot(A, MH)
    
    tr(N)
   
    

A1 = np.array(
  [[1., 1, 12], 
   [0, 1, 0], 
   [0, 0, 1]]
  )  

#transformation(M, A1)
    
A2 = np.array(
    [[2., 0, -12], 
     [0, 2, 0], 
     [0, 0, 1]]
    )

#transformation(M, A2)


a = np.sqrt(2)/2
A3 = np.array(
    [[a, -a, 0], 
     [a, a, 10], 
     [0, 0, 1]]
    )

#transformation(M, A3)


A4 = np.array(
    [[-1., 0, 10], 
     [0, -1, -10], 
     [0, 0, 1]]
    )

#transformation(M, A4)





























