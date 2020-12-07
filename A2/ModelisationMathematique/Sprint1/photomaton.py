# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np 
import matplotlib.pyplot as plt 


knight = plt.imread('/Users/Tom/dark-knight.png', 'PNG')

plt.imshow (knight)
plt.show()


doubleVertical = np.concatenate((knight, knight)) # axis = 0
print(doubleVertical.shape)

plt.imshow (doubleVertical)
plt.show()

doubleVertical = doubleVertical[::-1,:,:]

plt.imshow (doubleVertical)
plt.show()
