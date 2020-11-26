#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Sun Nov 15 14:46:45 2020

@author: tom
"""

import numpy as np 
import matplotlib.pyplot as plt 


face = plt.imread('./face.png', 'PNG')

plt.imshow(face)
plt.show()


#face = np.roll(face, 150, axis = 0)
#face = np.roll(face, 150, axis = 1)



def translate1(): 
    u = 150
    n = 768 + u
    m = 1024 + u
    
    grand = np.zeros((n, m, 3), dtype = np.uint8) 
        
    grand[u:, u:] = face
    
    grand = grand[ :n-u, :m-u ]
    
    plt.imshow(grand)
    plt.show()
    
def translate(): 
    n = 768
    m = 1024
    
    u = 150
    
    rouge = np.array([215, 40, 40], dtype = np.uint8)
    image = np.ones((n, m, 3), dtype = np.uint8) #* rouge
    
    X = np.arange(m)
    Y = np.arange(n) 
    #Y = Y[::-1]
    
    X = np.linspace(n - 1, 0, n)
    Y = np.linspace(0, m - 1, m)
    
    x, y = np.meshgrid(\
                        X ,\
                        Y ,\
                        indexing = 'xy')
    
    
    #for i in range(n):
     #   for j in range(m): 
      #      if (i + u < n & j + u < m): 
       #         image[i, j] = face[i + 150, j + 150]
    
    image[:50, :50] = rouge
    #image[ (x) == (y) ] = rouge
    
    
    plt.imshow(image)
    plt.show()

    
    
    

def translate2(): 
    u = 150
    v = 350
    n = 768 + u
    m = 1024 + v
    
    grand = np.zeros((n, m, 3), dtype = np.uint8) 
        
    grand[u:, v:] = face
    
    grand = grand[ :n-u, :m-v ]
    
    plt.imshow(grand)
    plt.show()



def translate3(): 
    u = -300
    v = -150
    n = 768 - u
    m = 1024 - v
    
    grand = np.zeros((n, m, 3), dtype = np.uint8) 
        
    grand[:768, :1024] = face
    
    #grand = grand[ :n-u, :m-v ]
    
    plt.imshow(grand)
    plt.show()

    
translate()
#translate1()
#translate2()
#translate3()




#grand[n:2*n,m:2*m]=face

#plt.imshow(grand)