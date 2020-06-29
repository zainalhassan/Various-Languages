# -- coding: utf-8 --
"""
Created on Mon Oct 21 18:15:14 2019

@author: ZainAlHassan
"""
class TextFrequency(str):
    def __init__(self, file_name):
        self.file_name = file_name
        self.text = ()
        self.getText()
   
    def getText(self):
        file = open(self.file_name, 'r')
        self.text = file.read()
        file.close()
       
    def letterFreq(self):
        counts = dict()
        words = self.text.replace('\n', ' ')
        for word in words:
           
            if word in counts:
               
                counts[word] += 1
            else:
                counts[word] = 1
        return counts
       
    def wordFreq(self):
        counts = dict()
        words = self.text.split()
        for word in words:
           
            if word in counts:
                counts[word] += 1
            else:
                counts[word] = 1
        return counts
   
    def toLower(self):
        self.text = self.text.lower()
       
   
class HistogramPrinter(TextFrequency):
   
    def __init__(self, file):
        TextFrequency.__init__(self, file)
       

    def printLetterHist(self):
               
        freq = self.letterFreq()
        for items in freq:
            print(items, '*' * freq[items])
           
    def printWordHist(self):
        freq = self.wordFreq()
        
        for items in freq:
            print(items, '*' * freq[items])
           
   
        
    
tf = TextFrequency('lyrics.txt')
lyrics = tf.letterFreq()
for word in lyrics:
     print(word, "occurred", lyrics[word] , "times")  
   
print()


lyrics = tf.wordFreq()
for word in lyrics:
     print(word, "occurred", lyrics[word] , "times")  

print()

hp = HistogramPrinter('lyrics.txt')
hp.printLetterHist()

print()

hp = HistogramPrinter('lyrics.txt')
hp.printWordHist()

print()

hp = HistogramPrinter('lyrics.txt')
hp.toLower()
hp.printWordHist()

print()

hp = HistogramPrinter('lyrics.txt')
hp.toLower()
hp.printLetterHist()