
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        StockTrackSystem stockTrackSystem = new StockTrackSystem();

        String operation= "1.View transaction\n"+
                "2.ADD\n"+
                "3.DEL\n"+
                "4.IMPORT\n"+
                "5.SEARCH\n"+
                "6.PLOT\n"+
                "7.SAVE\n"+
                "8.LOAD\n"+
                "9.QUIT\n";

        Scanner input =new Scanner(System.in);

        while(true){
            int choose= input.nextInt();
            switch(choose) {
                case 1:
                    System.out.println(operation);
                    break;
                case 2:
                    /*
                       (Key,new Stock(WKN,date,open,high,low,close,volume,adjClose))
                    */
                    stockTrackSystem.Add("Amazon",
                            new Stock("AWS", "3/8/2023", 349.3, 367.4, 339.1, 352.3, 23294.2, 3492.3));
                    break;
                case 3:
                    System.out.println("Give me the key");
                    String key = input.next();
                    stockTrackSystem.Delete(key);
                    break;
                case 4:
                    //import
                    /*
                    System.out.println("Give me the key");
                    input.nextLine();
                    String key = input.nextLine();
                    System.out.println("Give me the  WKM");
                    String WKM = input.nextLine();
                    System.out.println("Give me the filePath");
                    String filePath = input.nextLine();
                    stockTrackSystem.Import(key, WKM, filePath);
                    */
                    stockTrackSystem.Import("Microsoft", "WKM", "src\\nsft.csv");
                    break;
                case 5:
                    System.out.println("Give me the key");
                    String keyName = input.next();

                    ArrayList<Stock> result = stockTrackSystem.Search(keyName);

                    for (Stock stock : result) {
                        System.out.println(stock.getValues());
                    }

                    break;
                case 6:
                    //plot
                    stockTrackSystem.Plot();
                    System.out.println("\n\n\n");
                    break;
                case 7:
                    //save
                    stockTrackSystem.Save();
                    break;
                case 8:
                    //load
                    stockTrackSystem.Load();
                    break;
                case 9:
                    //quit
                    stockTrackSystem.quit();
                    break;
            }
        }
    }
}