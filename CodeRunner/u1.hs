module Main where
import Prelude hiding (rem)

main :: IO ()
main = putStrLn "Hello World"

fac :: Int -> Int
fac 0 = 1
fac n = n * fac(n-1)

fac' :: Int -> Int
fac' n = product [1 .. n]

sumFacs :: Int -> Int -> Int
sumFacs m n = sum [fac i | i <- [m .. n]] 
-- sum [i! | i aus {m, ..., n}]

fibFast :: Int -> Int -> Int -> Int
fibFast 0 x y = x
fibFast 1 x y = y
fibFast i x y = fibFast (i-1) y (x+y)

prod :: [Int] -> Int
prod (x:xs) = x + prod xs

rev :: Num a => [a] -> [a]
rev [] = []
rev [a] = [a]
rev (x:xs) = rev xs ++ [x]

rev' l = foldr (\x ys -> ys ++ [x]) [] l

rem, rem' :: Int -> [Int] -> [Int]
rem x [] = []
rem x (y:ys) 
    | x == y = rem ys 
    | otherwise = y : rem x ys

rem' x l = filter (/= x) l
merge :: Ord a => [a] -> [a] -> [a]
merge (x:xs) (y:ys)
    | x < y = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys
