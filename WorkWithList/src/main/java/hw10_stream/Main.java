package hw10_stream;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws NotFoundException {

        List<Product> productsList = new ArrayList<>();

        productsList.add(new Product("Book", 250.5, true, LocalDate.of(2023, Month.MAY, 21)));
        productsList.add(new Product("Book", 60.0, false, LocalDate.of(2024, Month.MARCH, 28)));
        productsList.add(new Product("Book", 20.0, true, LocalDate.of(2024, Month.AUGUST, 15)));
        productsList.add(new Product("Toy", 450.5, true, LocalDate.of(2023, Month.MARCH, 28)));
        productsList.add(new Product("Shoes", 1500.0, true, LocalDate.of(2024, Month.JANUARY, 28)));

        System.out.println("Sorted by Type and Price:");
        sortedByTypePrice(productsList, "Book",250.0);
        System.out.println("-------------------");
        System.out.println("Price with discount:");
        applyDiscount(productsList,"Book");
        System.out.println("-------------------");
        cheapestProduct(productsList,"Book");
        System.out.println("-------------------");
        getTheLastProducts(productsList,3);
        System.out.println("-------------------");
        System.out.println("Total product cost:");
        totalCost(productsList, "Book", 75.0);
        System.out.println("-------------------");

        printMapProduct(productsList);

    }
    public static void printMapProduct(List<Product> productList){
        for (Map.Entry<String, List<Product>> mapEl : groupProducts(productList).entrySet()) {
            System.out.println(mapEl.getKey() + mapEl.getValue());
        }
    }
    public  static void totalCost (List<Product> productsList, String type, double price){
        double sum = productsList.stream()
                .filter(product -> product.getType().equals(type))
                .filter(product -> product.getCreationDate().getYear() == (LocalDate.now().getYear()))
                .reduce(0.0,
                        (x,y)-> {
                            if (y.getPrice()<=price)
                                return x + y.getPrice();
                            else
                                return x + 0;
                        },
                        Double::sum);
        System.out.println(sum);
    }

    public static Map<String, List<Product>> groupProducts(List<Product> productList) {
        return productList.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public static void getTheLastProducts(List<Product> products, int limit) {
        System.out.println(limit+ " last added products:");
        products.stream()
                .sorted(Comparator.comparing(Product::getCreationDate).reversed())
                .limit(limit)
                .forEach(System.out::println);
    }

    public static void cheapestProduct(List<Product> products, String type) throws NotFoundException {
        System.out.println("The cheapest product in category " + type);
        Optional<Product> prod = Optional.ofNullable(products.stream()
                .filter(product -> product.getType().equals(type))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NotFoundException("Продукт " + type + " не знайдено")));

        System.out.println(prod.get().getType()+" "+prod.get().getPrice());
    }


    public static void applyDiscount(List<Product> listDiscount, String type) {

        listDiscount.stream()
                .filter(product -> product.getType().equals(type))
                .filter(Product::isDiscount)
                .map(product -> (product.getPrice() - product.getPrice() * 0.1))
                .forEach(product ->System.out.println(type+" "+product));
    }

    public static void sortedByTypePrice(List<Product> products, String type, double price) {
        products.stream()
                .filter(product -> product.getType().equals(type))
                .filter(product -> product.getPrice() > price)
                .forEach(product ->System.out.println(product.getType()+" "+product.getPrice()));
    }
}
