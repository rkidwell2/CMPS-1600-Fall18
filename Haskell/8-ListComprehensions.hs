main = putStrLn( show outfits)

pants = ["jeans", "khakis"]
tops = ["white shirt", "grey turtleneck", "pink polo", "green hoodie"]
shoes = ["brogues", "converse", "sandals"]

outfits = [(a, b, c)|a<-pants, b<-tops, c<-shoes]

--It makes the most sense to purchase more pants, since that would increase
--your total outfits by 24. Getting either one more pant and one shoe or
--two pants 

scarves = ["grey scarf", "pink scarf"]
newoutfits = [(a, b, c, d)|a<-pants, b<-tops, c<-shoes, d<-scarves]
--Adding a new category doubles the potential outfit combinations

l = ["Mr.", "Ms.", "Mrs.", "Dr.", "Prof.", "Rev."]
options = l ++ [a ++ " and " ++ b| a<-l, b<-l]
--There are 42 total combinations

nb = [('A', "Alpha"), ('B', "Bravo"), ('C', "Charlie"), ('D', "Delta"), ('E', "Echo"),('F', "Foxtrot"),('G', "Golf"),('H', "Hotel"), ('I', "India"),('J', "Juliett"),('K', "Kilo"),('L', "Lima"),('M', "Mike"),('N', "November"),('O', "Oscar"),('P', "Papa"),('Q', "Quebec"),('R', "Romeo"), ('S', "Sierra"),('T', "Tango"),('U', "Uniform"),('V', "Victor"),('W', "Whiskey"),('X', "X-ray"), ('Y', "Yankee"),('Z', "Zulu")]
getNato str = [snd y|x<-str, y<-nb, x == fst y]



