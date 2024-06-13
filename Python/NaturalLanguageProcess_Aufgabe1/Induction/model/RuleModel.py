class RuleModel:

    def __init__(self, id, lhs, rhs, grammar_type):
        self.id = id
        self.lhs = lhs
        self.rhs = rhs
        self.grammar_type = grammar_type

    def __hash__(self) -> int:
        return hash((self.lhs, self.rhs, self.grammar_type))

    def __eq__(self, other):
        # return self.__hash__() == other.__hash__()
        if self.lhs == other.lhs and self.rhs == other.rhs and self.grammar_type == other.grammar_type:
            return True
        else:
            return False
