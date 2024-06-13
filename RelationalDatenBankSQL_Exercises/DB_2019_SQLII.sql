-- Übung 4 Aufgabe 1
-- (i)
create table Menschen(SozVNr varchar(30) primary key, Name varchar(30));
create table verheiratet(Ehegatte1 varchar(30) not null references Menschen on delete cascade, Ehegatte2 varchar(30) not null references Menschen on delete cascade, primary key(Ehegatte1), unique (Ehegatte2));
-- 1)
-- (i)
Eltern_von(Mutter_Vater varchar(30) not null references Menschen, Kind varchar(30) not null references Menschen, primary key (Mutter_Vater, Kind));
-- (ii)
Eltern_von(Mutter varchar(30) not null references Menschen, Vater varchar(30) not null references Menschen, Kind varchar(30) not null references Menschen, primary key(Kind));

-- SQLII
select count(Distinct (A,B))         --A,B -> A,B,C,D,E
from R                     
                                                        A   B  .   .
                                                        1   1
                                                        1   2
                                                        2   1
                                                        1   1


                                                        count...
                                                        3
                                                        4


                                                        A B | C     count(*)
                                                        1 1 | 1     2
                                                            | 4     
                                                        1 2 | 2     1
                                                        2 1 | 3     1
union 
select count (A,B)
from R
group by A,B
having count(*)>1                                 =>  A | B
                                                      1 | 1   wenn Ausgabe, dann A,B kein Schlüssel
-- (b)
-- DE -> B
select D,E
from R
group by D,E
having count(Distinct B) > 1            wenn keine Ausgabe, dann whk. DE->B

D | E | B | A
1 | 1 | 1 | 1
1 | 2 | 2 | 1     (46)
1 | 1 | 1 | 3
1 | 2 | 3 | 3     (48) Widerspruch, da (46) und (48) D,E gleichen Werten haben

D | E | count(B)
1 | 1 | 2
1 | 2 | 2
nach Distinct:
D | E |
1 | 1 | 1
1 | 2 | 2


-- 3 (a)
KNote, Bonus -> GNote
Klausursumme -> KNote
Name, Aufgabe -> Erzielt
Name -> Bonus, (GNote), Klausursumme
Aufgabe -> Max
-- (b)
{Name, Aufgabe}