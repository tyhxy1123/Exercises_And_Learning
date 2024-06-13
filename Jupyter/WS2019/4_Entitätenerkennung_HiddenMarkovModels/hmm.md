Aufgabe 1:

|      | E    | A    | Pe   | St   | S    |
| ---- | ---- | ---- | ---- | ---- | ---- |
| E    | 0    | 0    | 0    | 0    | 0    |
| A    | 2    | 9    | 1    | 2    | 0    |
| Pe   | 1    | 3    | 4    | 0    | 0    |
| St   | 2    | 1    | 0    | 0    | 0    |
| S    | 0    | 1    | 3    | 1    | 0    |

count_A = 14;

ccount_E = 5;

count_Pe = 8;

count_St = 3;

count_S = 5;

Prob(A|E) = 2/14 = 1/7 = 0,1428;

Prob(A|A) = 9/14 = 0,6428;

Prob(A|Pe) = 1/14 = 0,0714;

Prob(A|St) = 2/14 = 0,1428;

Prob(Pe|E) = 1/8;

Prob(Pe|A) = 3/8;

Prob(Pe|Pe) = 4/8;

Prob(St|E) = 2/3;

Prob(St|A) = 1/3;

......

Aufgabe 2:

|       | 0    | 1                             | 2     | 3    | 4      | 5    |
| ----- | ---- | ----------------------------- | ----- | ---- | ------ | ---- |
| 0(S)  | 1    | 0                             | 0     | 0    | 0      | 0    |
| 1(Pe) | 0    | $1\cdot 0.4\cdot 0.25=0.1$    | 0     | 0    |        | 0    |
| 2(A)  | 0    | 0                             |       |      | 0      | 0    |
| 3(St) | 0    | $1\cdot 0.6 \cdot 0.2 = 0.12$ | 0     | 0    |        | 0    |
| 4(E)  | 0    | 0                             | 0     | 0    | 0      |      |
|       | $    | Paris                         | lives | in   | Denver | €    |

Aufgabe3:

a) wiki

F1 score to measure the model(more info on wiki)

$\cdot Recall: TP/(TP+FN)$

$\cdot Precistion:Prec=TP/(TP+FP)$

$\cdot F-measure: F_1=(2\cdot Prec\cdot Rec)/(Prec+Rec)$

b)

Sum:=16 (Cities)

TP: = 9 (True German Cities according to data set)

FN: = 2 (Dresden, Riesa)

TN: = 

FP: = 7 (Prague, Wroclaw, sister city, neighborhood, Bautzen, Meißen);

