## Movie Review Sentiment Analyzer

Sentiment Analysis is the process of algorithmic identifying and categorising of opinions which are wrote in free text and more specially for defining the sentiment of the author for a specific subject.

This project purpose is that it will process a movie review and analyze it and it will evaluate its sentiment. The sentiment of the review can be in 5 categories. Every one of them is represented by an integer value:

| rating  | semantics         |
| ------- | ----------------- |
| 0       | negative          |
| 1       | somewhat negative |
| 2       | neutral           |
| 3       | somewhat positive |
| 4       | positive          |



At first the algorithm is teached with labeled data. I use 8529 reviews from the website [Rotten Tomatoes](https://www.rottentomatoes.com/) 

There are words which my algorithm will miss and wont process because they are pointless for the algorithm purpose or they can even worse the algorithm correctness percentage. Those words are called "stop words" by many similar sentiment algorithms.
Here I gave example of a file with stops words with 174 stop words taken by [ranks.nl](https://www.ranks.nl/stopwords).
