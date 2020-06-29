import Data.List(sort, group, sortBy);
import Data.Char

toWordList = map (map toLower.filter isAlpha).words

countCommonWords wordList = length (filter isCommon wordList)
  where isCommon word = elem word commonWords
dropCommonWords wordList = filter isUncommon wordList
  where isUncommon w = notElem w commonWords

commonWords = ["the","a","it","he","be","in","for","as","to","that","not","you","of","have","on","do","and","I","with","at"]
countWords wordList = map (\w->(head w, length w)) $group $ sort wordList
compareTuples (w1,n1) (w2,n2) = if n1 < n2 then LT else if n1> n2 then GT else EQ
sortWords wordList = reverse $ sortBy compareTuples wordList
toAsteriskBar x = (replicate (snd x)'*')++ " -> " ++ (fst x) ++ "\n"
makeHistogram wordList = concat $ map toAsteriskBar (take 20 wordList)


text = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way--in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.\nThere were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever."

main = do
  let wordlist = toWordList text
  putStrLn "Report:"
  putStrLn ("\t" ++ (show $ length wordlist) ++ " words")
  putStrLn ("\t" ++ (show $ countCommonWords wordlist) ++ " common words")
  putStrLn "\nHistogram of the most frequent words (excluding common words):\n"
  putStr $ makeHistogram $ sortWords $ countWords $ dropCommonWords $ wordlist