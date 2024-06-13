
--Aufgabe 1
data BinTree a = Branch a (BinTree a) (BinTree a) | Leaf a
mirror :: BinTree a -> BinTree a
mirror (Branch x t1 t2) = Branch x (mirror t2) (mirror t1)
mirror (Leaf x) = Leaf x
yield :: BinTree a -> [a]
yield (Branch _ t1 t2) = yield t1 ++ yield t2
yield (Leaf x) = [x]
-- Induktionsbasis
-- Sei a ein beliebiger Typ und x :: a
reverse  (yield (Leaf x))
= reverse [x]               --(Zeile 9)(Z9)
= [x]                       --(E1)
= yield (Leaf x)            --(Z9)
= yielf (mirror (Leaf x))   --(Z5)


-- Induktionsschritt
-- Sei a ein beliebiger Typ und seien s, t :: BinTree a, sodass A(s) ∧ A(t) gilt.
-- Sei weiterhin x :: a.
reverse (yield (Branch x s t))
= reverse (yield s ++ yield t)              --(Z8)
= reverse (yield t) ++ reverse (yield s)    --(E2)
= yield (mirror t) ++ yield (mirror s)      --(IH)
= yield (Branch x (mirror t) (mirror s))    --(Z8)
= yield (mirror (Branch x s t))             --(Z4)

--Aufgabe 2
data IntTree = Leaf Int | Branch IntTree IntTree
add :: IntTree -> Int
add (Leaf a) = a
add (Branch t1 t2) = add t1 + add t2
sub :: IntTree -> Int

sub (Leaf a) = a
sub (Branch t1 t2) = sub t1 - sub t2

neg :: Int -> IntTree -> IntTree
neg i (Leaf a) = Leaf (a * i)
neg i (Branch t1 t2) = Branch (neg i t1) (neg (-i) t2)
--Induktionbasis
--Sei x, i :: Int.
add (neg i (Leaf x))            
= add (Leaf (x * i))              --(Z12)
= x * i                           --(Z4)
= i * x
= i * sub (Leaf x)                --(Z8)
-- Induktionsschritt
-- Sei s, t :: IntTree, sodass fur jedes j, k :: Int gilt:
add (neg j s) = j * sub s
add (neg k t) = k * sub t
-- Set weiterhin i :: Int.
add (neg i (Branch s t))
= add (Node (neg i s) (neg (-i) t))   --(Z13)
= add (neg i s) + add (neg (-i) t)    --(Z5)
= i * sub s + (-i) * sub t            --(IH)
= i * sub s - i * sub t
= i * (sub s - sub t)


--Aufgabe 3
