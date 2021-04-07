#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Mar 24 15:27:57 2021

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt

# Question 1 : 
T = np.linspace(0, 2 * np.pi, 1001)

X = np.sin(20 * T )
Y =np.sin(25*T) 

plt.plot(X, Y)
plt.show()


# Question 2.a

T = np.linspace(0, 2 * np.pi, 1001)

X = - np.cos(2 * T) * np.cos(T)
Y = - np.sin(2 * T) * np.cos(T) 

plt.plot(X, Y)
plt.show()



# Question 2.b

T = np.linspace(0, 2 * np.pi, 1001)

X = 2 * np.cos(T) + np.cos(2 * T)
Y = 2 * np.sin(T) + np.sin(2 * T) 

plt.plot(X, Y)
plt.show()



# Question 2.c

T = np.linspace(0, 2 * np.pi, 1001)

X = np.cos(T) ** 3
Y = np.sin(T) ** 3

plt.plot(X, Y)
plt.show()



# Question 2.d

T = np.linspace(0, 100, 1001)

X = T + (2 * np.cos(T))
Y = 0.5 * T

plt.plot(X, Y)
plt.show()



# Question 2.e

T = np.linspace(0, 100, 1001)

X = T + (2 * np.cos(T))
Y = (0.5 * T) + np.sin(T)

plt.plot(X, Y)
plt.show()






# PARTIE 2



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



# Question 3.a
P = np.array(
    [[0., 0, 1, 1], 
     [0, 1, 0, 1]]
    )

traceur(P)
plt.show()



# Question 3.b
P = np.array(
    [[0., 1, 1, 0], 
     [0, 1, 0, 1]]
    )

traceur(P)
plt.show()


# Question 3.c
P = np.array(
    [[0., 1, 0, -1], 
     [0, 0, 1, 0]]
    )

traceur(P)
plt.show()


# Question 3.d
P = np.array(
    [[0., 1, -3, -1], 
     [0, 2, 2, 0]]
    )

traceur(P)
plt.show()








