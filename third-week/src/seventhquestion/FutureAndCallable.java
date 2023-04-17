package seventhquestion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
public class FutureAndCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<List<Product>> searchTask = () -> dbSearch("p");
        Future<List<Product>> future =  executorService.submit(searchTask);

        try {
            List<Product> res = future.get();

            System.out.println("Search Results: ");
            for(Product p: res) {
                System.out.println(p);
            }
        }
        catch (Exception e) {
            throw  new RuntimeException("Error executing search  task", e.getCause());
        }

        executorService.shutdown();
    }

    private static List<Product> dbSearch(String query) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Product> res = new ArrayList<>();
        res.add(new Product(1, "computer", 10));
        res.add(new Product(2, "mobile", 14));
        res.add(new Product(3, "laptop", 130));


        return res.stream().filter(product -> product.getName().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
    }
}
