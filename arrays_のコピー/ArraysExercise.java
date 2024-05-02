package cao.hspedu.arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Li Mi~
 * @version 1.0
 */
public class ArraysExercise {
    public static void main(String[] args) {

        Book[] books = new Book[4];
        books[0] = new Book("三国志", 100);
        books[1] = new Book("君の名は", 90);
        books[2] = new Book("オーバーロード", 578);
        books[3] = new Book("ゼロからjava完全攻略", 143);

        //price high -> low
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                double priceVal = book2.getPrice() - book1.getPrice();
//                if (priceVal > 0) {
//                    return 1;
//                } else if (priceVal < 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });
//        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                //書名の長さで順番付
                return book1.getName().length() - book2.getName().length();

            }
        });
        System.out.println(Arrays.toString(books));

    }
}
class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
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
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
