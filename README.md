# Exercise1-Hashtable
Implement a stock price management program.
**Exercise 1 - HASHTABLE**

**Task:**
Work in pairs on the following programming example. The choice of programming language (C, C++, C#, Java) is up to you, but you need to implement the data structure yourself (do not use a pre-built Hashtable class). Other programming languages only by agreement!

**Problem Statement:**
Implement a program to manage stock prices. To quickly search for a specific stock, the stocks should be managed in a hashtable. For each stock, the program should store the name, security identification number (WKN as a string), and abbreviation (also a string). Additionally, the program needs to manage the price data for the past 30 days with the following information: (Date, Open, High, Low, Close, Volume, Adj Close). Stock price data of this format can be downloaded, for example, from http://de.finance.yahoo.com/q/hp?s=<ABBREVIATION> (e.g., for Microsoft stock with abbreviation MSFT: http://de.finance.yahoo.com/q/hp?s=MSFT), even as a CSV file.

The program is controlled through the following menu options:

1. ADD: Add a stock with name, WKN, and abbreviation.
2. DEL: Delete a stock.
3. IMPORT: Import price values for a stock from a CSV file.
4. SEARCH: Search for a stock in the hashtable (input by name or abbreviation) and output the most recent price entry (Date, Open, High, Low, Close, Volume, Adj Close).
5. PLOT: Plot the closing prices of the last 30 days for a stock.
6. SAVE <filename>: Save the hashtable to a file.
7. LOAD <filename>: Load the hashtable from a file.
8. QUIT: Exit the program.

**Data Structure:**
Devise a suitable hash function that generates a hash value from the name or abbreviation of the stock (criteria for good hash functions can be found in lectures). Implement quadratic probing as collision handling for the hashtable. Additionally, develop an efficient procedure for deleting entries from the hashtable.

Determine a suitable size for the hashtable under the assumption that a maximum of 1000 stocks will be managed. Define an appropriate data structure for storing the 30 price data entries per stock to efficiently display them.
