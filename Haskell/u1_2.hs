
rem, rem' :: Eq a => a -> [a] -> [a]
rem x [] = []
rem x (y:ys) | x == y = rem ys | otherwise = y : rem x ys

rem' x l = filter (/= x) l

merge :: Ord a => [a] -> [a] -> [a]
merge (x:xs) (y:ys)
    | x < y = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys
