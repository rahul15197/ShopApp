/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static productmanagement.Rating.*;

/**
 *
 * @author rahulmaheshwari
 * @version 1.0
 *
 */
public class Shop {

    public static void main(String[] args) {
        ProductManager pm = ProductManager.getInstance();
        AtomicInteger clientCount = new AtomicInteger(0);
        Callable<String> client = () -> {
            String clientId = "Client " + clientCount.incrementAndGet();
            String threadName = Thread.currentThread().getName();
            int productId = 101;
            String languageTag = ProductManager.getSupportedLocales()
                    .stream()
                    .skip(ThreadLocalRandom.current().nextInt(4))
                    .findFirst().get();
            StringBuilder log = new StringBuilder();
            log.append(clientId + " " + threadName + "\n-\tstart of log\t-\n");
            log.append(pm.getDiscounts(languageTag)
                    .entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + "\t" + entry.getValue())
                    .collect(Collectors.joining("\n")));
            Product product = pm.reviewProduct(productId, Rating.FOUR_STAR, "YET ANOTHER review");
            log.append((product != null) ? "\nProduct " + productId + " reviewed\n" : "\nProduct " + productId + " not reviewed\n");
            pm.printProductReport(productId, languageTag, clientId);
            log.append(clientId + " generated report for " + productId + " product");
            log.append("\n-\tend of log\t-\n");
            return log.toString();

        };
        List<Callable<String>> clients = Stream.generate(() -> client).limit(1).collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //ProductManager pm = new ProductManager("en-GB");
        //ProductManager pm = ProductManager.getInstance();
        //pm.printProductReport(101, "en-GB");
        //pm.printProductReport(102, "ru-RU");
        //Product p1 = pm.createProduct(107, "Tea", BigDecimal.valueOf(1.99), NOT_RATED);
        //pm.parseProduct("D,101,Tea,1.99,0,2019-09-19");
        /*pm.printProductReport(101);
            pm.printProductReport(42);
            pm.printProducts(p->p.getPrice().floatValue() < 2, (p1, p2)->p2.getRating().ordinal()-p1.getRating().ordinal());
            Product p1 = pm.createProduct(113, "Coffee", BigDecimal.valueOf(1.99), NOT_RATED);
            pm.reviewProduct(113, THREE_STAR, "good coffee");
            pm.reviewProduct(p1, FIVE_STAR, "NOICEEEE");
            pm.reviewProduct(p1, TWO_STAR, "Okayish");
            pm.reviewProduct(p1, ONE_STAR, "NOT GOOD coffee");
            //pm.dumpData();
            //pm.restoreData();
            pm.printProductReport(113);*/
        //pm.printProductReport(101);
        //pm.parseReview("101,a,Not nice tea");
        //pm.printProductReport(101);
        /*pm.reviewProduct(101, FOUR_STAR, "Very nice Tea");
            pm.reviewProduct(101, THREE_STAR, "good Tea");
            pm.reviewProduct(p1, FIVE_STAR, "NOICEEEE");
            pm.reviewProduct(p1, TWO_STAR, "Okayish");
            pm.reviewProduct(p1, ONE_STAR, "NOT GOOD Tea");
            pm.reviewProduct(p1, FOUR_STAR, "Very nice Tea");*/
 /*pm.parseReview("101,2,Not nice tea");
            pm.parseReview("101,3,nice tea");
            pm.parseReview("101,4,great tea");
            pm.parseReview("101,5,awesome tea");
            pm.printProductReport(101);*/
        //pm.printProductReport(p1);
        //pm.changeLocale("ru-RU");
        /*Product p2 = pm.createProduct(102, "T", BigDecimal.valueOf(2.50), NOT_RATED);
            pm.reviewProduct(p2, FOUR_STAR, "Very nice Tea");
            pm.reviewProduct(102, TWO_STAR, "good Tea");
            pm.reviewProduct(p2, TWO_STAR, "NOICEEEE");
            pm.reviewProduct(p2, TWO_STAR, "Okayish");
            pm.reviewProduct(p2, ONE_STAR, "NOT GOOD Tea");
            pm.reviewProduct(p2, ONE_STAR, "Very nice Tea");
            pm.printProducts(p -> p.getPrice().floatValue() < 2, (pro1, pro2) -> pro2.getRating().ordinal() - pro1.getRating().ordinal());
            pm.getDiscounts().forEach((rating, discount) -> System.out.println(rating + "\t" + discount));
            Comparator<Product> ratingSorter = (pro1, pro2) -> pro2.getRating().ordinal() - pro1.getRating().ordinal();
            //pm.printProducts(ratingSorter);
            Comparator<Product> priceSorter = (pro1, pro2) -> pro2.getPrice().compareTo(pro1.getPrice());*/
        //pm.printProducts(priceSorter);
        //pm.printProducts(ratingSorter.thenComparing(ratingSorter).reversed());
        /**
         * Product p2 = pm.createProduct(102, "Coffee",
         * BigDecimal.valueOf(2.45), FOUR_STAR); Product p3 =
         * pm.createProduct(103, "Cake", BigDecimal.valueOf(3.99), FIVE_STAR,
         * LocalDate.now().plusDays(2)); Product p4 = pm.createProduct(104,
         * "Cookie", BigDecimal.valueOf(1.50), TWO_STAR, LocalDate.now());
         * Product p5 = p3.applyRating(ONE_STAR); Product p6 =
         * p1.applyRating(TWO_STAR); System.out.println("Product -> " +
         * p1.getId() + " " + p1.getName() + " " + p1.getPrice());
         * System.out.println("Product Discount -> " + p1.getDiscount());
         * System.out.println("Rating -> " + p1.getRating().getStars());
         * System.out.println("Product -> " + p2.getId() + " " + p2.getName() +
         * " " + p2.getPrice()); System.out.println("Product Discount ->" +
         * p2.getDiscount()); System.out.println("Rating -> " +
         * p2.getRating().getStars()); System.out.println("Product -> " +
         * p3.getId() + " " + p3.getName() + " " + p3.getPrice());
         * System.out.println("Product Discount ->" + p3.getDiscount());
         * System.out.println("Rating -> " + p3.getRating().getStars());
         * //System.out.println("Best Before Date -> " + p3.getBestBefore());
         * System.out.println("Product -> " + p4.getId() + " " + p4.getName() +
         * " " + p4.getPrice()); System.out.println("Product Discount ->" +
         * p4.getDiscount()); System.out.println("Rating -> " +
         * p4.getRating().getStars()); System.out.println("Product P1 -> " +
         * p1); System.out.println("Product P3 -> " + p3);
         * System.out.println("Product P3 and P2 -> " + p3.equals(p2));
         * System.out.println("\nProduct P1 = " + p1);
         * System.out.println("Product P2 = " + p2); System.out.println("Product
         * P3 = " + p3); System.out.println("Product P4 = " + p4);
         * System.out.println("Product P5 = " + p5); System.out.println("P5
         * Instance = " + (p5 instanceof Product)); System.out.println("Product
         * P6 = " + p6); System.out.println("P6 Instance = " + (p6 instanceof
         * Drink)); LocalDate p5BestBefore = p5.getBestBefore(); LocalDate
         * p6BestBefore = p6.getBestBefore(); System.out.println(p5BestBefore);
         * System.out.println(p6BestBefore);*
         */
        //pm.printProductReport(p2);
        //pm.parseProduct("F,103,Cake,3.99,0,2019-09-19");
        //pm.printProductReport(103);
        try {
            List<Future<String>> results = executorService.invokeAll(clients);
            executorService.shutdown();
            results.stream().forEach(result->{
                try {
                    System.out.println(result.get());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error retrieving client log", ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error retrieving client log", ex);
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(Shop.class.getName()).log(Level.SEVERE, "Error invoking clients", ex);
        }
    }

}
