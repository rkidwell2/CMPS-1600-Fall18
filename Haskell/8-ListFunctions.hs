outfits :: [a] -> [a] -> [a] -> [(a, a, a)]
outfits [] [] [] = []
outfits [a] [b] [c] = [(x, y, z)|x<-[a], y<-[b], z<-[c]]

honorifics :: [String] -> [String]
honorifics [] = []
honorifics l = l ++ [a ++ " and " ++ b| a<-l, b<-l]
 

nb = [('A', "Alpha"), ('B', "Bravo"), ('C', "Charlie"), ('D', "Delta"), ('E', "Echo"),('F', "Foxtrot"),('G', "Golf"),('H', "Hotel"), ('I', "India"),('J', "Juliett"),('K', "Kilo"),('L', "Lima"),('M', "Mike"),('N', "November"),('O', "Oscar"),('P', "Papa"),('Q', "Quebec"),('R', "Romeo"), ('S', "Sierra"),('T', "Tango"),('U', "Uniform"),('V', "Victor"),('W', "Whiskey"),('Y', "Yankee"),('Z', "Zulu")]
 
natoWord :: String -> [String]
natoWord str = [snd y|x<-str, y<-nb, x == fst y]