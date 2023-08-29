
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class StockTrackSystem {

    public static HashTable hashTable;
    public static CSVReader reader = null;

    public StockTrackSystem()
    {
        hashTable = new HashTable(1000);
    }

    public void Add(String name, Stock stock){
        hashTable.put(name, stock);
    }

    public void Delete(String name)
    {
        hashTable.delete(name);
    }

    public void Import(String key, String WKM, String filePath) throws IOException {

        reader = new CSVReader(new FileReader(filePath));
        String[] nextLine;
        String totalLine = WKM + " ";
        boolean skipFirstLine = true;

        while((nextLine = reader.readNext()) != null){
            if(skipFirstLine){
                skipFirstLine = false;
                continue;
            }
            for (String token: nextLine) {
                totalLine += token + " ";
            }
            Stock stock = new Stock(totalLine);
            hashTable.put(key, stock);
            totalLine = WKM + " ";
        }
    }

    public ArrayList<Stock> Search(String name)
    {
        return hashTable.getValues(name);
    }
    public void Plot(){
        hashTable.printHashTable();
    }

    public void Save() throws IOException {
        FileWriter fileWriter = new FileWriter("src\\table.txt");
        fileWriter.write(hashTable.getStringFormat());
    }

    public void Load() throws IOException {
        hashTable.LoadTable("src\\table.txt");
    }

    //public void Quit();
    public void quit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }


}
