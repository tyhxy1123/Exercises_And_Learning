import numpy as np
import matplotlib.pyplot as plt
from matplotlib.lines import Line2D

# uncomment if you use my style sheet standardsytle.mplstyle
# for me it needs to be in ~/.config/matplotlib/stylelib.mplstyle; you also need the matplotlibrc.template in
# ~/.config/matplotlib/

# plt.style.use('standardstyle')
# plt.rcParams['legend.markerscale'] = 1.0

bank_data = [
    [25, 40000, 'N'],
    [35, 60000, 'N'],
    [45, 80000, 'N'],
    [20, 20000, 'N'],
    [35, 120000, 'N'],
    [52, 18000, 'N'],
    [23, 95000, 'Y'],
    [40, 62000, 'Y'],
    [60, 100000, 'Y'],
    [48, 220000, 'Y'],
    [33, 150000, 'Y']
]

cls_index = len(bank_data[0]) - 1


def parse_data_to_numpy_array(data):
    """
    Gets data in the List-List format and returns an attribute array and an array of labels.
    The attribute array has shape (len(data), len(data[0]) - 1). We suppose, that only the last entry in an example is
    a the (categorically) class label. The others are continuous data.
    """
    array = np.zeros(shape=(len(data), len(data[0]) - 1))
    for i in range(len(data)):
        array[i, :] = data[i][:(len(data[0]) - 1)]

    class_labels = np.array([data[i][-1] for i in range(len(data))])

    return array, class_labels


def get_distances_to_example(attribute_array, x):
    """
    attribute_array is the array of attributes as is from parse_data_to_numpy_array.
    x   is the attribute vector for an example to be classified (needs to be an numpy array)
    """
    diff = attribute_array - x
    distances = np.linalg.norm(diff, axis=1)

    return distances


def get_knn_indices_of_examples(distances, k):
    sortindices = np.argsort(distances)

    knn_indices = sortindices[:k]

    return knn_indices


def get_majority_classification_of_knn(knn_indices, class_labels):
    knn_classlabels = class_labels[knn_indices]

    unique, counts = np.unique(knn_classlabels, return_counts=True)

    majority_index = np.argmax(counts)

    majority_class = unique[majority_index]

    return majority_class


def get_color_from_class(class_labels):
    if type(class_labels) == np.str_:
        if class_labels == 'Y':
            return 'r'
        elif class_labels == 'N':
            return 'b'

    else:
        colors = np.copy(class_labels)
        for j in range(len(colors)):

            if class_labels[j] == 'Y':
                colors[j] = 'r'
            elif class_labels[j] == 'N':
                colors[j] = 'b'
        return colors


def plot_data_and_example(array, class_labels, x, maj_label, knn_indices):

    plt.figure(figsize=(8, 8))

    # plot dotted lines from example to be classified to k nearest neighbors
    for j in range(len(knn_indices)):
        plt.plot((x[0], array[knn_indices[j]][0]), (x[1], array[knn_indices[j]][1]), '--', color='black', zorder=-1)
    # plot examples
    plt.scatter(array[:, 0], array[:, 1], c=get_color_from_class(class_labels), s=50, marker='o')
    plt.xlabel("Alter (normed)")
    plt.ylabel("Kredit (normed)")

    # plot example to be classified
    plt.scatter(x[0], x[1], c=get_color_from_class(maj_label), s=100, marker='*')

    legend_elements = [Line2D([0], [0], color='r', marker='o', label='Y', linestyle='None'),
                       Line2D([0], [0], marker='o', color='b', label='N', linestyle='None'),
                       Line2D([0], [0], marker='*', color=get_color_from_class(maj_label), label=maj_label, linestyle='None')
                       ]
    plt.legend(handles=legend_elements)
    plt.tight_layout()
    plt.show()


def classify_and_plot(data, x, k):

    array, class_labels = parse_data_to_numpy_array(data)

    distances = get_distances_to_example(array, x)

    knn_indices = get_knn_indices_of_examples(distances, k)

    maj_class = get_majority_classification_of_knn(knn_indices, class_labels)

    print(f"The majority of the {k} nearest neighbor classes for unnormalized data is: ", maj_class)
    plot_data_and_example(array, class_labels, x, maj_class, knn_indices)


def find_min_and_max(attr_array):
    minarray = np.min(attr_array, axis=0)
    maxarray = np.max(attr_array, axis=0)

    return minarray, maxarray


def classify_and_plot_normalized(data, x, k):
    array, class_labels = parse_data_to_numpy_array(data)

    minarray, maxarray = find_min_and_max(array)
    array = (array - minarray)/(maxarray - minarray)
    x = (x - minarray)/(maxarray - minarray)

    distances = get_distances_to_example(array, x)

    knn_indices = get_knn_indices_of_examples(distances, k)

    maj_class = get_majority_classification_of_knn(knn_indices, class_labels)

    print(f"The majority of the {k} nearest neighbor classes for normalized data is: ", maj_class)
    plot_data_and_example(array, class_labels, x, maj_class, knn_indices)


# classify_and_plot(bank_data, x=np.array([48, 142000]), k=3)
classify_and_plot_normalized(bank_data, x=np.array([48, 142000]), k=3)