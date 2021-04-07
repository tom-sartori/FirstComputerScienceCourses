#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Mar 23 11:00:18 2021

@author: tom
"""

import numpy as np 

import matplotlib.pyplot as plt


t = np.linspace(-3, 3, 100) 


X = t**3-3*t**2+3*t+1
Y = t**2-2*t

plt.plot(X, Y)
plt.show() 


X = np.cos(t)+np.sqrt(8)*np.cos(t/2)
Y = np.sin(t)

plt.plot(X, Y)