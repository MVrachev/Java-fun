## Movie Review Sentiment Analyzer

Sentiment Analysis is the process of algorithmic identifying and categorising of opinions which are written in free text and more specially for defining the sentiment of the author for a specific subject.

This purpose of the project is to process a movie review and analyze it and evaluate its sentiment. The sentiment of the review can be in 5 categories. Every one of them is represented by an integer value:

| rating  | semantics         |
| ------- | ----------------- |
| 0       | negative          |
| 1       | somewhat negative |
| 2       | neutral           |
| 3       | somewhat positive |
| 4       | positive          |



At first the algorithm is teached with labeled data. I use 8529 reviews from the website [Rotten Tomatoes](https://www.rottentomatoes.com/) 

There are words which my algorithm will miss and won’t process because they are pointless for the purpose of the algorithm or they can even worse the algorithm’s correctness percentage. These words are called ["stop words"](https://en.wikipedia.org/wiki/Stop_words) by many similar sentiment algorithms.
Here I give an example of a file with 174 stop words taken by [ranks.nl](https://www.ranks.nl/stopwords).

