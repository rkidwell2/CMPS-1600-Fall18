

remainder ::  (Integral a) => a -> a -> a
remainder a b = a- b*(div a b)


isEven :: Integer -> Bool
isEven a
  | remainder a 2 == 1 = False
  | otherwise = True
  

merge :: Ord a => [a] -> [a] -> [a]
merge [] [] = []
merge xs [] = xs
merge [] ys = ys
merge (a:list1) (b:list2)
  | a <= b = a:merge list1 (b:list2)
  | otherwise = b:merge list2 (a:list1)

removeMultiple :: (Integral a) => [a] -> a -> [a]
removeMultiple [a] 0 = []
removeMultiple [] b = []
removeMultiple (x:xs) b = [x | remainder x b /= 0] ++ [a | a<-xs, remainder a b /= 0]




