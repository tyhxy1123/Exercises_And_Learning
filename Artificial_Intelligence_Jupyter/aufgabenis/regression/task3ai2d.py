"""
Note: It's tedious to draw this function because of the singularity at (x, y) = (0, 0). If you come up with a nice
idea, let me now.
"""




import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D


def function(x, y):
    return 1/(x**2 + y**2)


def gradx(x, y):
    return (-2*x)/(x**2 + y**2)**2


def grady(x, y):
    return (-2*y)/(x**2 + y**2)**2


maxabs = 0.5
minabs = 0.01
N = 100

x = np.empty(N)
x[:N//2] = np.linspace(-maxabs, -minabs, N//2, endpoint=True)
x[N//2:] = np.linspace(minabs, maxabs, N//2, endpoint=True)
y = np.empty(N)
y[:N//2] = np.linspace(-maxabs, -minabs, N//2, endpoint=True)
y[N//2:] = np.linspace(minabs, maxabs, N//2, endpoint=True)


X, Y = np.meshgrid(x, y)

XThinned, YThinned = np.meshgrid(x[::20], y[::20])
U = gradx(XThinned, YThinned)
V = grady(XThinned, YThinned)

z = function(X, Y)

plt.figure()
plt.pcolormesh(X, Y, z)

plt.gca().set_aspect("equal")
plt.colorbar()


# idea for this scale function comes from
# https://stackoverflow.com/questions/45123091/quiver-plot-arrows-in-matplotlib-are-ridiculously-too-large
f = lambda x:np.sign(x)*np.log10(1+np.abs(x))

plt.quiver(XThinned, YThinned, f(U), f(V), pivot='mid')
plt.show()