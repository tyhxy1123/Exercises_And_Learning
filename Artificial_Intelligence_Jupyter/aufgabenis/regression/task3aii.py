

import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D

def function(x, y):
    return x**2*y


def gradx(x, y):
    return 2*x*y

def grady(x, y):
    return x**2

N = 100

x = np.linspace(-5, 5, N)
y = np.linspace(-5, 5, N)

X, Y = np.meshgrid(x, y)

print(function(X, Y).min())
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.plot_wireframe(X, Y, function(X, Y), rcount=30, ccount=30)

zmin = - 100


XArrow, YArrow, ZArrow = np.meshgrid(
    x[::10], y[::10], zmin*np.ones(len(x))[::10]
)
U, V = gradx(XArrow, YArrow), grady(XArrow, YArrow)

ax.set_zlim3d(zmin, 0)

ax.quiver(XArrow, YArrow, ZArrow, U, V, np.zeros(len(x))[::10], length=0.02, arrow_length_ratio=1)


plt.show()

