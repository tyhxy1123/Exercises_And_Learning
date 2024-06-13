import matplotlib.pyplot as plt
import numpy as np


def w0(x: np.ndarray, y: np.ndarray):
    return y.mean() - w1(x, y)*x.mean()


def w1(x: np.ndarray, y: np.ndarray):
    return ((x*y).mean() - x.mean()*y.mean())/((x**2).mean() - x.mean()**2)


def hypothesis(xval, w0, w1):
    return w0 + w1*xval


x = np.array([0, 30, 50, 80, 100, 130, 180])
y = np.array([0, 3.5, 5.0, 6.8, 7.4, 8.0, 12.0])


plt.figure()
plt.plot(x, y, '.')

xnew = np.linspace(x.min(), x.max(), 2)

plt.plot(xnew, hypothesis(xnew, w0(x, y), w1(x, y)))

plt.show()


print("Hypothesis gasoline prices: ")
for i in range(len(x)):
    xval = x[i]
    print(f"(s, chyp, ctrue) = ({xval}, {hypothesis(xval, w0(x, y), w1(x, y))}, {y[i]})")