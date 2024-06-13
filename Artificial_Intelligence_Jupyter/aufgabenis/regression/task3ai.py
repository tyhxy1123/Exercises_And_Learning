"""
Note: It's tedious to draw this function because of the singularity at (x, y) = (0, 0). If you come up with a nice
idea, let me now.

Also there is a known bug (and open issue): You cannot see the arrows in the plot. The arrow heads somehow depend on
z-scale. If you like to resolve it, here is the link to the issue: https://github.com/matplotlib/matplotlib/issues/11746
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

maxabs = 0.4
minabs = 0.01
N = 100

x = np.empty(N)
x[:N//2] = np.linspace(-maxabs, -minabs, N//2, endpoint=True)
x[N//2:] = np.linspace(minabs, maxabs, N//2, endpoint=True)
y = np.empty(N)
y[:N//2] = np.linspace(-maxabs, -minabs, N//2, endpoint=True)
y[N//2:] = np.linspace(minabs, maxabs, N//2, endpoint=True)


X, Y = np.meshgrid(x, y)

print(function(X, Y).min())
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.plot_wireframe(X, Y, function(X, Y), rcount=30, ccount=30)
ax.set_zlim3d(-100, 100)


XArrow, YArrow, ZArrow = np.meshgrid(
    x[::20], y[::20], -100*np.ones(len(x))[::20]
)
U, V = gradx(XArrow, YArrow), grady(XArrow, YArrow)

ax.quiver(XArrow, YArrow, ZArrow, U, V, np.zeros(len(x))[::20], length = 0.00005, linewidth=1.0,
          facecolor='red', edgecolor='red', arrow_length_ratio=0.3)


plt.show()

