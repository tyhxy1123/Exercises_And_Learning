import numpy as np
import matplotlib.pyplot as plt

# uncomment if you use my style sheet standardsytle.mplstyle
# for me it needs to be in ~/.config/matplotlib/stylelib.mplstyle; you also need the matplotlibrc.template in
# ~/.config/matplotlib/

# plt.style.use('standardstyle')


N = 100
varX = 0.5
varY = 0.5
covar = 0
cov = np.array([[varX, covar],
 [covar, varY]])
mean = np.array([0, 0])
clusters = [np.random.multivariate_normal(np.array([-2, 2]), cov, N)]
clusters += [np.random.multivariate_normal(np.array([2, 2]), cov, N)]
clusters += [np.random.multivariate_normal(np.array([0, -2]), cov, N)]
examples = np.concatenate((clusters[0], clusters[1], clusters[2]))


class KMeansClustering(object):

    def __init__(self, examples, clusters, k, normalized):
        self.examples = examples
        self.k = k
        self.state = 0
        c = ['r', 'g', 'b', 'orange', 'y']

        self.c = c[:self.k]

        # init cluster centers
        minxattr = np.min(examples[:, 0])
        maxxattr = np.max(examples[:, 0])
        minyattr = np.min(examples[:, 1])
        maxyattr = np.max(examples[:, 1])

        if normalized:
            # normalize the data and the clusters
            examples[:, 0] = (examples[:, 0] - minxattr)/(maxxattr - minxattr)
            examples[:, 1] = (examples[:, 1] - minyattr)/(maxyattr - minyattr)
            for cluster in clusters:
                cluster[:, 0] = (cluster[:, 0] - minxattr)/(maxxattr - minxattr)
                cluster[:, 1] = (cluster[:, 1] - minyattr)/(maxyattr - minyattr)

        # just init the clusters
        fig, ax = plt.subplots(1, 2, figsize=(16, 8))
        ax[0].set_xlabel("Alter (normed)")
        ax[0].set_ylabel("Kredit (normed)")
        ax[1].set_xlabel("Alter (normed)")
        ax[1].set_ylabel("Kredit (normed)")
        ax[0].plot(clusters[0][:, 0], clusters[0][:, 1], '.')
        ax[0].plot(clusters[1][:, 0], clusters[1][:, 1], '.')
        ax[0].plot(clusters[2][:, 0], clusters[2][:, 1], '.')

        line_examples = []

        for j in range(k):
            line_example_j = ax[1].plot(examples[:, 0], examples[:, 1], '.', color='black')
            line_examples.append(line_example_j[-1])

        clustercenters = np.zeros(shape=(2, k))

        for j in range(k):
            clustercenters[:, j] = np.array([np.random.uniform(0, 1),
                                             np.random.uniform(0, 1)])
        self.clustercenters = clustercenters
        self.clusterindices = np.zeros(shape=k, dtype=list)
        self.print_cluster_centers()

        scatter = ax[1].scatter(clustercenters[0, :], clustercenters[1, :], c=self.c, marker='*', s=200)

        cid = fig.canvas.mpl_connect('button_press_event',
                                     lambda event: self.onclick(event, line_examples, scatter,
                                                                                      ax))

        ax[1].set_title("Initialization")
        plt.tight_layout()
        plt.show()

    def onclick(self, event, line_examples, scatter, axes):
        if self.state == 0:
            # calculate for each example the nearest cluster
            axes[1].set_title("3. Calculated Nearest Neighbors")
            distances = np.zeros(shape=(len(self.examples[:, 0]), self.k))
            for j in range(self.k):
                distances[:, j] = np.linalg.norm(self.examples - self.clustercenters[:, j], axis=1)

            indices = np.argmin(distances, axis=1)

            for j in range(self.k):
                indices_cluster_k = np.where(indices == j)[0]
                self.clusterindices[j] = indices_cluster_k
                examples_k = examples[indices_cluster_k, :]

                line_examples[j].set_data(examples_k[:, 0], examples_k[:, 1])
                line_examples[j].set_c(self.c[j])
            plt.draw()
            self.state = 1
        elif self.state == 1:
            # calculate new mean of clusters
            axes[1].set_title("4. Set New Cluster Centers")
            for j in range(self.k):
                examples_k = self.examples[self.clusterindices[j]]
                if len(examples_k) != 0:
                    self.clustercenters[:, j] = np.mean(examples_k, axis=0)

            self.print_cluster_centers()

            scatter.set_offsets(np.c_[self.clustercenters[0, :], self.clustercenters[1, :]])
            plt.draw()
            self.state = 0

    def print_cluster_centers(self):
        print(100 * "-")
        for j in range(self.k):
            print(f"Cluster {j}:", self.clustercenters[0, j], self.clustercenters[1, j])


kmc = KMeansClustering(examples, clusters, k=3, normalized=True)









