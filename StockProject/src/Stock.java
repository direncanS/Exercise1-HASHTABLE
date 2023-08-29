
public class Stock {

    public String WKN;
    public String date;
    public double open;
    public double high;
    public double low;
    public double close;
    public double volume;
    public double adjClose;


    public Stock() {
        WKN = "";
        date = "";
        open = high = low = close = adjClose = volume = 0.0;
    }
    /*
       This is a method that accepts a stock record in string format
       and parses each property of the record and assigns it to the corresponding properties of the stock object.
       First, the string is separated by spaces (split) to get a string array (attributes).
       Then a for loop is performed on this array to assign each property to the appropriate variable.
       These properties are the (WKN),public String WKN, date, open, high, low, close, volume, adjClose.
       Also, the numeric values that are in the form of strings are converted to double values using the Double.parseDouble() method.
      */
    public Stock(String line) {
        String[] attributes = line.split("\\s+");
        for (int i = 0; i < attributes.length; i++) {
            switch (i){
                case 0:
                    WKN = attributes[i];
                    break;
                case 1:
                    date = attributes[i];
                    break;
                case 2:
                    open = Double.parseDouble(attributes[i]);
                    break;
                case 3:
                    high = Double.parseDouble(attributes[i]);
                    break;
                case 4:
                    low = Double.parseDouble(attributes[i]);
                    break;
                case 5:
                    close = Double.parseDouble(attributes[i]);
                    break;
                case 6:
                    volume = Double.parseDouble(attributes[i]);
                    break;
                case 7:
                    adjClose = Double.parseDouble(attributes[i]);
                    break;

            }
        }

    }

    public Stock(String WKN,
                 String date,
                 double open,
                 double high,
                 double low,
                 double close,
                 double volume,
                 double adjClose) {
        this.WKN = WKN;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.adjClose = adjClose;
    }
    /*
     This code defines a hashCode() method on the Stock class that returns the hash code of the WKN of the Stock object.
     A hash code is a numeric value assigned to an object to uniquely identify it.
     The hashCode() method is typically used to store and manage objects in a hash table.
     In this case, the method simply returns the hash code of the Stock object's WKN, which is calculated by calling the hashCode() method on the WKN's String object.
     Because the hash code of the WKN is unique, the return value of this method will be different for each stock object, helping to uniquely identify the stock object in a hash table.
      */
    @Override
    public int hashCode() {
        return WKN.hashCode();
    }
    //The purpose of this method is to cast an object of the Stock class to a string.    @Override
    public String toString() {
        return "Stock{" +
                "WKN='" + WKN + '\'' +
                ", date='" + date + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", adjClose=" + adjClose +
                '}';
    }

    public String getValues() {
        return date + "\t" + open + "\t" + high + "\t" + low + "\t" + close + "\t" + volume + "\t" + adjClose;
    }
}
