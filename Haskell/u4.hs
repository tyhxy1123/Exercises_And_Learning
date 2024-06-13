-- 02.05.2019 Thu.3.DS

--           1
--     |           |
--     2           5
-- |       |   |       |
-- 3       4   6       9
--            / \
--           7   8
import Prelude hiding (unzip)
data Tree a = Branch a (Tree a) (Tree a) | Leaf a deriving (Show)


--Aufgabe 1
--a
ta :: Tree Int
ta = Branch 1 (Branch 2 (Leaf 3) (Leaf 4)
              )
              (Branch 5 (Branch 6 (Leaf 7) (Leaf 8)) 
                        (Leaf 9)
               )

--b
depth :: Tree a -> Int
depth (Leaf _) = 1
depth (Branch _ l r) = 1 + min (depth l) (depth r)

--c
paths :: Tree a -> Tree [a]
paths a = help a [] where
    help (Branch v l r) s = let ns = s ++ [v] in Branch ns (help l ns) (help r ns)
    help (Leaf v) s = Leaf (s ++ [v])

--d
tmap :: (a -> b) -> Tree a -> Tree b
tmap f (Leaf x) = Leaf (f x) --Leaf $ f x
tmap f (Branch v l r) = Branch (f v) (tmap f l) (tmap f r)

--Aufgabe 2
unzip :: [(a,b)] -> ([a], [b])
unzip [] = ([], [])
unzip ((x,y) : zs) = ([x] ++ xs, [y] ++ ys) where
    (xs,ys) = unzip zs

{-
    map (uncurry (+)) [(1,2),(3,4)]
=3= uncurry (+) (1,2) : map (uncurry (+)) [(3,4)]
=6,3= (+) 1 2 : uncurry (+) (3,4) : map (uncurry (+)) []
=2,6=   3     :     (+) 3 4       : []
== 3 : 7 : []
== [3,7]
-}
























