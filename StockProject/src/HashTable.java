/*
This code defines a hash table class that stores data using a key-value pair and provides quick access to the data. This particular hash table takes an ArrayList<Stock> (list used to store stock data) as a value for a string key.

The class contains the following fields:

keys: an array of keys (strings) in the hash table
values: an array of ArrayLists containing the stock data corresponding to the keys in the hash table
MAX_VALUE_COUNT: The maximum number of stock data that can be associated with a key
size: the number of elements in the hash table
capacity: the capacity of the hash table
The class also contains the following methods:

HashTable(): creates a new hash table with the specified capacity
hashIndex(): calculates the index value in the hash table for a given key
put(): inserts a key-value entry into the hash table
delete(): deletes the stock data corresponding to the given key from the hash table
getValues(): returns a list of stock data matching the given key
getIndex(): returns the index in the hash table that corresponds to the given key
getStringFormat(): returns the data in the hash table as a formatted string
LoadTable(): loads data from a CSV file and groups it under "bucket" headings. Each "bucket" contains a key and one or more stock data associated with that key. The class uses the Stock class to read stock data from the CSV file.
Overall, the hash table class provides an efficient way to store and quickly access stock data.
  */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HashTable {

    private String[] keys;
    private ArrayList<Stock>[] values;
    private static final int MAX_VALUE_COUNT = 30;
    private int size;
    private int capacity;


    public HashTable(int capacity) {
        this.capacity = capacity;
        keys = new String[capacity];
        values = new ArrayList[capacity];
    }

    private int hashIndex(String key)
    {
        int hashTotal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashTotal += key.charAt(i);
        }

        int index = hashTotal % capacity;
        int counter = 1;
        while (values[index] != null)
        {
            if(values[index].size() < MAX_VALUE_COUNT)
            {
                return index;
            }
            index = (index + counter * counter++) % capacity;
        }
        return index;
    }

    public void printHashTable() {
        System.out.println(getStringFormat());
    }

    public void put(String key, Stock value) {

        int index = hashIndex(key);
        int i = 1;
        do
        {
            if (getKey(index) == null)
            {
                keys[index] = key;
                values[index] = new ArrayList<Stock>();
                values[index].add(value);
                size++;
                return;
            }

            if (getKey(index).equals(key))
            {
                if(values[index].size() < MAX_VALUE_COUNT)
                {
                    values[index].add(value);
                    return;
                }

            }

            index = (index + i * i++) % capacity;

        } while (index != i);


    }

    public void delete(String key)
    {
        int index = getIndex(key);
        keys[index] = null;
        values[index] = null;
        size--;
    }

    private String getKey(int index)
    {
        if(keys[index] == null){
            return null;
        }

        return keys[index];
    }
    public ArrayList<Stock> getValues(String key) {

        ArrayList<Stock> stocksWithKeys = new ArrayList<>();
        int stockCounter = 0;
        for (int i = 0; i < keys.length; i++) {
            if(keys[i] == null){
                continue;
            }

            if(keys[i].equals(key)){
                for (int j = 0; j < values[i].size(); j++) {
                    stocksWithKeys.add(values[i].get(j));
                }
            }
        }
        return stocksWithKeys;
    }



    public int getIndex(String key) {

        int index = hashIndex(key);
        int i = 1;
        do
        {
            if (getKey(index) != null && getKey(index).equals(key))
            {
                return index;
            }
            index = (index + i * i++) % capacity;

        } while (index != i);

        return -1;
    }


    public String getStringFormat()
    {
        String output = "";
        for (int i = 0; i < capacity; i++) {

            if(values[i] == null || values[i].size() <= 0)
                continue;

            output += ("Bucket: " + i + "\n" + keys[i] + " (" + values[i].get(0).WKN + ")") + "\n";

            for (Stock stock: values[i]) {
                if(stock == null)
                    break;
                output += stock.getValues() + "\n";
            }
            output += "\n\n\n";
        }
        return output;
    }


    public void LoadTable(String filePath) throws IOException {

        boolean indexFound = false;
        boolean nameExtracted = false;
        String line = "";
        String index = "";
        String name = "";
        String WKM = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null){

            if(line.length() < 2){
                if(indexFound)
                    indexFound = false;

                if(nameExtracted)
                    nameExtracted = false;

                continue;
            }


            if(line.startsWith("Bucket:")){
                String[] splited = line.split("\\s+");
                index = splited[1];
                indexFound = true;
                continue;
            }

            if(!nameExtracted){
                String[] splited = line.split("\\s+");
                name = splited[0];
                WKM = splited[1].substring(1, splited[1].length() - 1);
                nameExtracted = true;
                continue;
            }

            if(indexFound){
                keys[Integer.parseInt(index)] = name;
                if(values[Integer.parseInt(index)] == null)
                    values[Integer.parseInt(index)] = new ArrayList<>();
                values[Integer.parseInt(index)].add(new Stock(WKM + " " + line));
                continue;
            }
        }
    }
}