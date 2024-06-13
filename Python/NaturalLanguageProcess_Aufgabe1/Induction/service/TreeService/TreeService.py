from Induction.model.GrammarType import GrammarType
from Induction.model.NodeModel import NodeModel


class TreeService:
    def __init__(self):
        self.repository = []
        self.id = 0

    def find_all_nodes(self) -> type(list):
        return self.repository

    def create_node(self, value, parent, type):
        self.id += 1
        node = NodeModel(self.id, value, parent, type)
        self.repository.append(node)
        return node

    def parse_tree(self, line):
        arr = line[1:].split(' ')
        root = self.create_node(arr[0], None, GrammarType.ATOM)
        stack = [root]
        for piece in arr[1:]:
            if "(" in piece:
                node = self.create_node(piece, stack[-1], GrammarType.NONLEXICAL)
                node.parent.children.append(node)
                stack.append(node)
            else:
                node = self.create_node(piece, stack[-1], GrammarType.LEXICAL)
                node.parent.children.append(node)
                l = list(filter(lambda x: x == ')', piece))
                for c in l:
                    stack.pop(-1)

    def find_all_trees(self):
        return list(filter(lambda x: x.grammar_type == GrammarType.ATOM, self.repository))
