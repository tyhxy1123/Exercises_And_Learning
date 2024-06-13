""" Intelligent Systems TUD 2018, Ex.1

Decision Tree Learning:
Based on american census data you want to predict two classes of income of people:
>50K$, <=50K$.

We do not use continuous attributes for this first decision tree task.
"""
__author__ = 'Benjamin Guthier'

from math import log


def openfile(path, fname):
    """opens the file at path+fname and returns a list of examples and attribute values.
    examples are returned as a list with one entry per example. Each entry then
    is a list of attribute values, one of them being the class label. The returned list attr
    contains one entry per attribute. Each entry is a list of possible values or an empty list
    for numeric attributes.
    """
    datafile = open(path + fname, "r")
    examples = []
    for line in datafile:
        line = line.strip()
        line = line.strip('.')
        # ignore empty lines. comments are marked with a |
        if len(line) == 0 or line[0] == '|':
            continue
        ex = [x.strip() for x in line.split(",")]
        examples.append(ex)

    attr = []
    for i in range(len(examples[0])):
        values = list({x[i] for x in examples})  # set of all different attribute values
        if values[0].isdigit():  # if the first value is a digit, assume all are numeric
            attr.append([])
        else:
            attr.append(values)

    return examples, attr


def calc_entropy(examples, cls_index):
    """calculates the entropy over all examples. The index of the class label in the example
    is given by cls_index. Can also be the index to an attribute.
    """
    .
    .
    .
    return result


def calc_ig(examples, attr_index, cls_index):
    """Calculates the information gain over all examples for a specific attribute. The
    class index must be specified.

    uses calc_entropy
    """
    .
    .
    .
    return result


def majority(examples, attr_index):
    """Returns the value of attribute "attr_index" that occurs the most often in the examples."""
    # create a flat list of all attribute values (with duplicates, so we can count)
    .
    .
    .
    # among all unique attribute values, find the maximum with regards to occurrence in the attr_vals list
    return max(set(attr_vals), key=attr_vals.count)


def choose_best_attr(examples, attr_avail, cls_index):
    """Iterates over all available attributes, calculates their information gain and returns the one
    that achieves the highest. attr_avail is a list of booleans corresponding to the list of attributes.
    it is true if the attribute has not been used in the tree yet (and is not numeric).
    """
    igs = []  # list of information gains for each attribute
    .
    .
    .
    return igs.index(max(igs))  # return index of the attribute with highest IG


def dtree_learning(examples, attr_avail, default, cls_index):
    """Implementation of the decition tree learning algorithm according to the pseudo code
    in the lecture. Receives the remaining examples, the remaining attributes (as boolean list),
    the default label and the index of the class label in the attribute vector.
    Returns the root node of the decision tree. Each tree node is a tuple where the first entry is
    the index of the attribute that has been used for the split. It is "None" for leaf nodes.
    The second entry is a list of subtrees of the same format. The subtrees are ordered in the
    same way as the attribute values in "attr". For leaf nodes, the second entry is the predicted class.

    uses choose_best_attr, majority, dtree_learning
    """
    global attr
    .
    .
    .
    return tree


def dtree_classify(dtree, x):
    """Classifies a single example x using the given decision tree. Returns the predicted class label.
    """
    .
    .
    .
    return dtree_classify(dtree[1][subtree_pos], x)  # descend into subtree recursively


def dtree_test(dtree, examples, cls_index):
    """Classify all examples using the given decision tree. Prints the achieved accuracy."""
    .
    .
    .
    print("{} out of {} correct ({:.2f}%)".format(correct, len(examples), correct / len(examples) * 100))


path = "data/"  # directory of your data
datafile = "adult.data.txt"
testfile = "adult.test.txt"
examples, attr = openfile(path, datafile)  # load the training set
test, test_attr = openfile(path, testfile)  # load the test set
cls_index = len(attr) - 1  # the last attribute is assumed to be the class label
# attr_names = ["age", "workclass", "fnlwgt", "education", "education-num", "marital-status", "occupation", "relationship", "race", "sex", "capital-gain", "capital-loss", "hours-per-week", "native-country", "class"]

attr_avail = []  # marks which attributes are available for splitting (not numeric and not the class label)
for i in range(len(attr)):
    # the list attr[i] contains all possible values of attribute i. It is empty for numeric attributes.
    attr_avail.append(len(attr[i]) > 0 and i != cls_index)

dtree = dtree_learning(examples, attr_avail, [], cls_index)
dtree_test(dtree, examples, cls_index)
dtree_test(dtree, test, cls_index)