# Klasse airports neu laden
from breitsuche import airport, airports
ap = airports()
print("BFS from Dresden (DRS) to Sydney (SYD)")
fr = ap.d["DRS"]
to = ap.d["SYD"]
ap.printPath(ap.bfs(fr, to))