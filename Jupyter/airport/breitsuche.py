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


class airports():
    """Implements a set of airports with their connections"""

    def __init__(self):
        self.d = {}  # a dictionary with code as key and airport as value
        self.city = {}  # for each city a set of its airports
        self.country = {}  # for each country a set of its airports
        self.goodCodes = self.codesWithRoutes(self.codesWithAirportInfo())
        self.readRoutes()
        self.readAirportInfo()
        self.indexCities()
        self.indexCountries()

    def get(self, code):
        if not code in self.d:
            self.d[code] = airport(code)
        return self.d[code]

        # Good codes have their airport info and at least one route

    # to a destination which has its airport information complete
    def codesWithRoutes(self, codesWithAirportInfo):
        codes = set([])
        for line in open("routes.dat", encoding='utf-8'):
            l = line.split(",")
            fr = l[2].strip("\"")
            to = l[4].strip("\"")
            if fr in codesWithAirportInfo and to in codesWithAirportInfo:
                codes.add(fr)
                codes.add(to)
        return codes

    # Collect all codes that have in principle all airport information
    def codesWithAirportInfo(self):
        codes = set([])
        for line in open("airports.dat", encoding='utf-8'):
            l = line.split(",")
            if len(l) == 12:
                code = l[4].strip("\"")
                city = l[2].strip("\"")
                country = l[3].strip("\"")
                x = float(l[6])
                y = float(l[7])
                if city and country and x and y:
                    codes.add(code)
        return codes

    def readRoutes(self):
        for line in open("routes.dat", encoding='utf-8'):
            l = line.split(",")
            fr = l[2].strip("\"")
            to = l[4].strip("\"")
            if fr in self.goodCodes and to in self.goodCodes:
                fr_airport = self.get(fr)
                to_airport = self.get(to)
                fr_airport.fly2(to_airport)
                to_airport.fly2(fr_airport)

    def readAirportInfo(self):
        for line in open("airports.dat", encoding='utf-8'):
            l = line.split(",")
            if len(l) == 12:
                code = l[4].strip("\"")
                city = l[2].strip("\"")
                country = l[3].strip("\"")
                x = float(l[6])
                y = float(l[7])
                if code in self.d and code in self.goodCodes:
                    self.d[code].set(city, country, x, y)

    def indexCities(self):
        for code in self.goodCodes:
            c = self.d[code].city
            self.city[c] = self.city.get(c, set([]))
            self.city[c].add(code)

    def indexCountries(self):
        for code in self.goodCodes:
            c = self.d[code].country
            self.country[c] = self.country.get(c, set([]))
            self.country[c].add(code)

    ################################################################
    #
    # Distance between airports from long/lat coordinates on sphere
    # See e.g. http://www.koordinaten.de/informationen/formel.shtml
    #conn
    ################################################################

    def distance(self, fr, to):
        if fr == to: return 0.0
        try:
            return math.acos(
                math.sin(math.radians(fr.x)) * math.sin(math.radians(to.x)) + math.cos(math.radians(fr.x)) * math.cos(
                    math.radians(to.x)) * math.cos(math.radians(to.y - fr.y))) * 6378.137
        except:
            print(fr.code + " " + to.code)
            sys.exit()

    def printPath(self, path):
        for n in path:
            print(n.str())
        dist = 0.0
        for i in range(len(path) - 1):
            dist += self.distance(path[i], path[i + 1])
        print("Distance: %d km" % (dist))

    def suggestAirport(self, s):
        # s is an airport code
        if s in self.d:
            return self.d[s]
        # s is a city, then return random airport code for that city
        elif s in self.city:
            l = list(self.city[s])
            return self.d[l[random.randint(0, len(l) - 1)]]
        # s is a country, then return random airport code for that country
        elif s in self.country:
            l = list(self.country[s])
            return self.d[l[random.randint(0, len(l) - 1)]]
        # return random airport code
        else:
            l = list(self.d.keys())
            return self.d[l[random.randint(0, len(l) - 1)]]

    def suggestNext(self, airport):
        l = list(airport.conn)
        return l[random.randint(0, len(l) - 1)]
      
    # Get path from fr to to and print out path
    def bfs_path(self, parent, fr, to):
        path = [to]
        while path[-1] != fr:  # last element of path is not fr
            path.append(parent[path[-1]])
        path.reverse()  # path is in wrong order, so reverse
        return path

    # Main breadth first search algorithm
    def bfs(self, fr, to):
        # FIFO queue of nodes to be processed
        queue = [fr]
        # Avoid loops by keeping track of visited nodes
        visited = {}
        # Store parent of node to get path from fr to to
        parent = {}
        while queue:
            # n = queue.___  # get first node of queue
            n = queue.pop(0)
            visited[n] = True
            if n == to:  # solution found
                return self.bfs_path(parent, fr, to)
            for nn in n.conn:  # add successors to queue
                if not nn in visited and not nn in queue:
                    parent[nn] = n
                    queue.append(nn)  # add nn to the end (important!) of queue (FIFO)