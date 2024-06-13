-- Aufgabe 1a)

pack :: Eq a => [a] -> [[a]]
pack [] = []
pack (x:xs) = pack' [x] xs

pack' :: Eq a => [a] -> [a] -> [[a]]
pack' [] _ = undefined
pack' ys [] = [ys]
pack' (y:ys) (x:xs)
    | y == x = pack' (x:y:ys) xs
    | otherwise = (y:ys) : pack' [x] xs

-- Aufgabe 1b)

encode :: Eq a => [a] -> [(Int, a)]
encode xs
    = let ys = pack xs
          bla = 5
          blub = 7
          f [] = undefined
          f (z:zs) = (length (z:zs), z)
      in map f ys

-- Aufgabe 1c)

decode :: [(Int, a)] -> [a]
decode = concatMap (\(i, x) -> take i $ repeat x)
    -- = let f (i, x) = take i $ repeat x  TAKE first element of array [x] which has infinite x
    --     ys = map f xs
    -- in concat ys


--  Aufgabe 1d)

rotate :: [a] -> Int -> [a]
rotate xs 0 = xs
rotate [] _ = []
rotate xs 0 = xs
rotate (x:xs) i
    | i > 0 = rotate (xs ++ [x]) (i-1)
    | i < 0 = rotate (x:xs) (i + length (x:xs))
    | otherwise = (x:xs)

rotate' :: [a] -> Int -> [a]
rotate' (x:xs) i
    | i > 0 = drop i xs ++ take i xs
    | i < 0 = rotate' (x:xs) (i + length (x:xs))
    | otherwise = (x:xs)

-- Aufgabe 2a)

unwords1 :: [String] -> [String]
unwords1 [] = []
unwords1 [x] = x
unwords1 (x:xs) = x ++ " " ++ unwords1 xs

words1 :: String -> [String]
words1 [] = []
words1 xs = words' [] xs
    where words' ys [] = [ys]
          words' ys (' ':zs) = ys : words' [] zs
          words' ys (z:zs) = words' (ys ++ [z]) zs



-- Aufgabe 3a)

data Tree = Node String [Tree]

tree :: Tree
tree = node "root" 
       [
         Node "l" [],
         Node "m"
         [
            Node "lu" [],
            Node "ru" []
         ],
         Node "r" []
       ]

































