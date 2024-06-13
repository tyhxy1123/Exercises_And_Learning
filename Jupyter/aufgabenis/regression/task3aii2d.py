import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D


def function(x, y):
    return x**2*y


def gradx(x, y):
    return 2*x*y


def grady(x, y):
    return x**2


x = np.linspace(-20, 20, 100)
y = np.linspace(-20, 20, 100)

X, Y = np.meshgrid(x, y)

XThinned, YThinned = np.meshgrid(x[::10], y[::10])
U = gradx(XThinned, YThinned)
V = grady(XThinned, YThinned)

z = function(X, Y)

plt.figure()
plt.pcolormesh(X, Y, z)

plt.gca().set_aspect("equal")
plt.colorbar()
plt.quiver(XThinned, YThinned, U, V)
plt.show()