#!/usr/bin/env python2
# -*- coding: utf-8 -*-
"""
Created on Wed Sep 16 13:00:22 2020

@author: tom
"""

import numpy as np
import matplotlib.pyplot as plt

x = np.arange(-5, 5, 0.1)
y = np.arange(-5, 5, 0.1)

x = x
y = y == x-3


x, y = np.meshgrid(x, y)

z = x + y
#z = np.sin(xx**2 + yy**2) / (xx**2 + yy**2)
#h = plt.contourf(x, y, z)

plt.imshow(z)