class NodeModel:

    def __init__(self, id, value, parent, grammar_type):
        self.id = id
        self.value = value
        self.parent = parent
        self.children = []
        self.grammar_type = grammar_type

    def __str__(self) -> str:
        return "id: " + self.id.__str__() + " value: " + self.value.__str__() + " grammar_type: " + self.grammar_type.__str__()