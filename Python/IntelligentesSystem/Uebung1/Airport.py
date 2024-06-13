import math
import sys
import random

class airport():
    """Implements an airport with airport code, city, country, x, y, and connections"""

    def __init__(self, code):
        """Creates airport object."""
        self.code = code
        self.conn = set([])

    def set(self, city, country, x, y):
        self.city = city
        self.country = country
        self.x = x
        self.y = y

    def fly2(self, a):
        self.conn.add(a)

    def str(self):
        return "%s, %s, %s" % (self.code, self.city, self.country)


