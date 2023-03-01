/**
 * Retrieve historical stock prices
 */
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import yahoofinance.histquotes.HistQuotesRequest;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.fx.FxQuote;
import yahoofinance.quotes.csv.FxQuotesRequest;
import yahoofinance.quotes.csv.StockQuotesData;
import yahoofinance.quotes.csv.StockQuotesRequest;
import yahoofinance.quotes.query1v7.FxQuotesQuery1V7Request;
import yahoofinance.quotes.query1v7.StockQuotesQuery1V7Request;

import yahoofinance.*;
  import java.util.Calendar;

public class StockPriceHistory
{

    private final String TICKER = "GOOG";
    
    /**
     * Retrieve the stock price data
     */
    public void run() {
        try {
            Stock stock = YahooFinance.get(TICKER, true);
            System.out.println(stock);
            System.out.println(stock.getHistory());
        } catch (Exception e) {
            System.out.println("Error in stock call");    
        }
    }
    
    
    /**
     * Sends a request with the historical quotes included
     * at the specified interval (DAILY, WEEKLY, MONTHLY).
     * Returns null if the data can't be retrieved from Yahoo Finance.
     * 
     * @param symbol        the symbol of the stock for which you want to retrieve information
     * @param interval      the interval of the included historical data
     * @return              a {@link Stock} object containing the requested information
     * @throws java.io.IOException when there's a connection problem
     */
    public static Stock get(String symbol, Interval interval) throws IOException {
        return YahooFinance.get(symbol, HistQuotesRequest.DEFAULT_FROM, HistQuotesRequest.DEFAULT_TO, interval);
    }
    
    /**
     * Format a Calendar object to YYYY-MM-DD format
     */
    private String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";
        
        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }
    

    /**
     * Main method to run the program
     */
    public static void main (String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }
}

