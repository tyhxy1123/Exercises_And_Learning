

data Tree = Node String [Tree] deriving Show

t = Node "Root" [

                    Node "l" [],
                    Node "m" [
                            Node "lu" [],
                            Node "ru" []
                            ],
                    Node "r" []
                    ]

level :: Int -> Tree -> [String]
level 0 (Node s (t:ts)) = [s]
level n (Node s []) = []
level n (Node s []) = []
level n (Node s (t:ts)) = (level (n-1) t) ++ level (Node s ts)