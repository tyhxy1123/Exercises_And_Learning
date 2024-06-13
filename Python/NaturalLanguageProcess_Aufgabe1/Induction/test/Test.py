import re
import urllib

from urllib import request

from Induction.service.RuleService.RuleService import RuleService
from Induction.service.TreeService.TreeService import TreeService


def str_manipulate():
    txt = "123145"
    l = list(filter(lambda x: x == "1", txt))
    print(l)
    l.pop(-1)
    print(l)


def file():
    service = TreeService()
    f = open("../resource/training.mrg", "r")
    lines = f.readlines()
    for line in lines:
        service.parse_tree(line)
    for t in service.find_all_trees():
        print(t)


def CCCcCCC():
    f = open('../resource/challenge.txt')
    txt = ''.join(f.read()).replace('\n', '').replace('\r\n', '').replace('\r', '').replace('\\', '')
    regex = re.compile('[^A-Z][A-Z]{3}([a-z])[A-Z]{3}[^A-Z]')
    result = regex.findall(txt)
    print("".join(result))


def next_nothing():
    url = "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=12345"

    # number = 12345
    number = 16044 / 2
    numbers = [number]

    for j in range(500):
        url = "http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=%s" % number
        response = request.urlopen(url)
        txt = response.read().decode()
        print(txt)
        number = txt.split()[-1]
        print(number)
        numbers.append(number)

    print(len(numbers))


def rule_count():
    rule_service = RuleService()
    tree_service = TreeService()
    f = open("../resource/training.mrg", "r")
    lines = f.readlines()
    for line in lines:
        tree_service.parse_tree(line)
    rule_service.count_rules(tree_service.find_all_nodes())


rule_count()
