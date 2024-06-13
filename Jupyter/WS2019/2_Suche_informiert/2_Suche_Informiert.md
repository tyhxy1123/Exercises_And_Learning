Step 1

|  S   |  S   |  S   |
| :--: | :--: | :--: |
|      |      |      |
|      |      |      |

|      |  S   |  S   |
| ---- | :--: | :--: |
|      |      |      |
|      |  S   |      |

|  S   |      |  S   |
| :--: | ---- | :--: |
|      |      |      |
|  S   |      |      |

|  S   |      |  S   |
| :--: | ---- | :--: |
|      |      |      |
|      |      |  S   |

|  S   |  S   |      |
| :--: | :--: | ---- |
|      |      |      |
|      |  S   |      |

|      |  S   |  S   |
| ---- | :--: | :--: |
|      |      |  S   |
|      |      |      |

|  S   |  S   |      |
| :--: | :--: | ---- |
|  S   |      |      |
|      |      |      |

step 2

|      |      |  S   |
| :--: | :--: | :--: |
|      |      |      |
|  S   |  S   |      |

|      | S    |      |
| ---- | ---- | ---- |
| S    |      |      |
|      | S    |      |

|      | S    |      |
| ---- | ---- | ---- |
|      |      | S    |
|      | S    |      |

|      |      | S    |
| ---- | ---- | ---- |
|      |      |      |
| S    | S    |      |

|  1   |       2       |  3   |
| :--: | :-----------: | :--: |
|  4   | Not Reachable |  5   |
|  6   |       7       |  8   |

6 possibilities for step 1

###Aufgabe 1

####1.

P1 has 8 possible states

P2 has 8 - 1(P1) = 7 possible states

P3 has therefore 8 - 1(P1) - 1(P2) = 6 possible states

####2.

(1,2,3) -> (5,8,3)

ID(Iterative Deep first search):

(1,2,3) 

-> (5,2,3)(7,2,3)(1,6,3)(1,8,3)(1,2,4)(1,2,7) ------ d1 not solution

expand the first node (5,2,3)

-> (6,2,3)(1,2,3)(5,6,3)(5,8,3)(5,2,7)(5,2,4) ------ d2 found solution (5,8,3)



A* Search:

(1,2,3) false movement f=0+2=2

-> (5,2,3)(7,2,3)(1,6,3)(1,8,3)(1,2,4)(1,2,7) ------ d1 not solution

for(5,2,3) false movement f = 1+1=2

for(7,2,3) f = 3

for(1,6,3) f = 1+ 2 = 3

for(1,8,3) f = 1+ 1 = 2

for(1,2,4) f = 1 + 3 = 4

for(1,2,7) f = 1 + 3 = 4

expand (5,2,3) according to f (select lower f):

(6,2,3) f = 4

(1,2,3) f = 4

(5,6,3) f = 3

(5,8,3) f = 2 solution

(5,2,7) f = 4

(5,2,4) f = 4

#### 3.

branch factor = 6, because each node has 6 children

b = 6, d = 15, 3Byte per node

$$O(b^{d+1}) \rightarrow 6^{16}\cdot3 \approx 8.46TB$$

$O(bd)=6\cdot15\cdot3=270B$

####5.

Figure out is it possible to move from S1 to S3

$StateI (1,2,3)\rightarrow StateIII(6,7,8)$ Not possible

See Note for details

$StateI(1,2,3)\rightarrow StateIV(8,7,6)$



### Aufgabe 2

Also have to use ID and A*

M=25

F=20

D=10

S=5

$[MFSDF]\rightarrow []$

Starting point: $[MFSDF][]$ as root node then expand according to states: number means cost

$([DS][MFL]25)([FS][MDL]25)([FD][MSL]25)([MD][FSL]20)([MS][FDL]20)([MF][FSL]10)$

According ID cost 10 will be expanded:

$([MF][FSL]) \rightarrow ([MFDL][S]10)([MFSL][D]5)$

