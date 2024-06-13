import collections

from Induction.model.GrammarType import GrammarType
from Induction.model.RuleModel import RuleModel


class RuleService:
    def __init__(self):
        self.rule_repository = list()
        self.id = 0

    def new_rule(self, lhs, rhs, grammar_type):
        self.id += 1
        rule = RuleModel(self.id, lhs, rhs, grammar_type)
        self.rule_repository.append(rule)
        return rule

    def append_rule(self, rule):
        self.rule_repository.append(rule)

    def count_rules(self, tree_repository):
        cfg_rules = dict()
        for node in tree_repository:
            if node.grammar_type is not GrammarType.LEXICAL:
                if node.children[0].grammar_type == GrammarType.LEXICAL:
                    self.new_rule(lhs=node.value, rhs=node.children[0].value, grammar_type=GrammarType.LEXICAL)
                elif node.children[0].grammar_type == GrammarType.NONLEXICAL:
                    self.new_rule(lhs=node.value, rhs=tuple(filter(lambda child: child.value, node.children)), grammar_type=GrammarType.NONLEXICAL)
        d = collections.Counter(self.rule_repository)
        for rule in self.rule_repository:
            print(d[rule])
        
