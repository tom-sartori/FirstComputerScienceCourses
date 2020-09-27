# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np 
import matplotlib.pyplot as plt 


knight = plt.imread('/Users/Tom/dark-knight.png', 'PNG')

#plt.imshow (knight)

doubleHorizontal = np.block([[knight], [knight]]) 
# doubleHorizontal = np.concatenate((knight, knight), axis=1)
plt.imshow (doubleHorizontal)
plt.show()

doubleVertical = np.concatenate((knight, knight)) # axis = 0
plt.imshow (doubleVertical)
plt.show()

quadruple = np.block([[doubleVertical], [doubleVertical]])
plt.imshow (quadruple)
plt.show()