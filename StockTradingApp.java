import java.util.*;

class Stock {
    String ticker;
    double price;

    public Stock(String ticker, double price) {
        this.ticker = ticker;
        this.price = price;
    }

    public void updatePrice() {
        price *= (1 + (Math.random() - 0.5) / 10);  // Simulating price fluctuations
    }

    @Override
    public String toString() {
        return ticker + ": $" + String.format("%.2f", price);
    }
}

class Market {
    Map<String, Stock> stocks = new HashMap<>();

    public void addStock(String ticker, double initialPrice) {
        stocks.put(ticker, new Stock(ticker, initialPrice));
    }

    public void updateMarket() {
        for (Stock stock : stocks.values()) {
            stock.updatePrice();
        }
    }

    public void displayMarket() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    public void buyStock(Market market, String ticker, int quantity) {
        Stock stock = market.stocks.get(ticker);
        if (stock != null && balance >= stock.price * quantity) {
            balance -= stock.price * quantity;
            holdings.put(ticker, holdings.getOrDefault(ticker, 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + ticker);
        } else {
            System.out.println("Insufficient funds or invalid stock.");
        }
    }

    public void sellStock(Market market, String ticker, int quantity) {
        Stock stock = market.stocks.get(ticker);
        if (stock != null && holdings.getOrDefault(ticker, 0) >= quantity) {
            balance += stock.price * quantity;
            holdings.put(ticker, holdings.get(ticker) - quantity);
            System.out.println("Sold " + quantity + " shares of " + ticker);
        } else {
            System.out.println("Invalid stock or not enough shares to sell.");
        }
    }

    public void displayPortfolio() {
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Holdings: " + holdings);
    }
}

public class StockTradingApp {
    public static void main(String[] args) {
        Market market = new Market();
        market.addStock("AAPL", 150);
        market.addStock("GOOG", 2800);

        Portfolio portfolio = new Portfolio(5000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            market.updateMarket();
            market.displayMarket();
            portfolio.displayPortfolio();

            System.out.println("\nEnter command: (buy <ticker> <qty> / sell <ticker> <qty> / exit)");
            String command = scanner.nextLine();
            if (command.equals("exit")) break;

            String[] parts = command.split(" ");
            if (parts.length == 3) {
                String action = parts[0];
                String ticker = parts[1];
                int qty = Integer.parseInt(parts[2]);
                
                if (action.equals("buy")) portfolio.buyStock(market, ticker, qty);
                if (action.equals("sell")) portfolio.sellStock(market, ticker, qty);
            }
        }
        scanner.close();
    }
}
