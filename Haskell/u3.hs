data Tree = Node Int Tree Tree | Nil

insert :: Tree -> [Int] -> Tree
insert (Node x t1 t2) [] = (Node x t1 t2)
insert Nil [x:xs] = (Node x Nil Nil)
insert (Node x t1 t2) (y:ys)
--  Fall Unterscheidung
    | y < x = insert (Node x (insert t1 [y]) t2) ys
    | otherwise = insert (Node x t1 (insert t2 [y])) ys


equal :: Tree -> Tree -> Bool
equal Nil Nil = Tree
equal Nil (Node x t1 t2) = False
equal (Node x t1 t2) Nil = False
equal (Node x t1 t2) (Node y t3 t4)
    | x == y = (equal t1 t3) && (equal t2 t4)
    | otherwise = False

data Tree' = Node' Int [Tree'] deriving Show
--a
noLeaves :: Tree' -> Int
noLeaves (Node' x []) = 1
noLeaves (Node' x (t:ts)) = (noLeaves t) + (noLeaves (Node' x ts)) -1

noLeaves' :: Tree' -> Int
noLeaves' (Node' x []) = 1
noLeaves' (Node' x (t:ts)) = noLeavesInList (t:ts) where
    noLeavesInList [] = 0
    noLeavesInList (Node' x (t:ts)) = (noLeaves' t) + (noLeavesInList ts)
--b
evenTree :: Tree -> Bool
evenTree (Node' x ts) = (mod (length ts) 2 == 0) && aux ts where
    aux [] = True
    aux (t:ts) = (evenTree t) && aux ts

--12.1.54
f :: [Int] -> Int
f xs = foldr (*) 1 (map (^2) (filter even xs))

-- 12.1.11
maxLength :: [[Int]] -> Int
maxLength (l:ls) = aux 0 (l:ls) where
    aux n [] = n
    aux n (l:ls)
        | (length l) > n = aux (length l) l:ls
        | otherwise = aux n ls

maxLength' :: [[Int]] -> Int
maxLength' [] = 0
maxLength' (l:ls) = max' (length l) (maxLength ls) where
    max' x y
        | x > y = x
        | otherwise = y























