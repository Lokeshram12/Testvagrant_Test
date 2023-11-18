import java.util.*;

class Product {
    private String productName;
    private double unitPrice;
    private double gst;
    private int quantity;

    public Product(String productName, double unitPrice, double gst, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.gst = gst;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getGst() {
        return gst;
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateTotalPrice() {
        double totalPrice = (unitPrice + (unitPrice * gst)) * quantity;
        if (unitPrice > 500) {
            totalPrice -= totalPrice * 0.05;
        }
        return totalPrice;
    }
    // Calculate GST 
    public double calculateGSTAmount() {
        return (unitPrice * gst) * quantity;
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalCartPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.calculateTotalPrice();
        }
        return total;
    }

    public Product findProductWithMaxGSTAmount() {
        double maxGST = 0.0;
        Product maxGSTProduct = null;
        for (Product product : products) {
            double gstAmount = product.calculateGSTAmount();
            if (gstAmount > maxGST) {
                maxGST = gstAmount;
                maxGSTProduct = product;
            }
        }
        return maxGSTProduct;
    }

    public double findMaxGSTAmount() {
        double maxGST = 0.0;
        for (Product product : products) {
            double gstAmount = product.calculateGSTAmount();
            if (gstAmount > maxGST) {
                maxGST = gstAmount;
                
            }
        }
        
        return maxGST;
    }
}

public class Products {
    public static void main(String[] args) {
        Product product1 = new Product("wallet", 1100.0, 0.18, 1);
        Product product2 = new Product("umbrella", 900.0, 0.12, 4);
        Product product3 = new Product("cigarette", 200.0, 0.28, 3);
        Product product4 = new Product("honey", 100.0, 0.0, 2);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);
        cart.addProduct(product4);

        // Displaying product details 
        List<Product> cartProducts = cart.getProducts();
        for (Product product : cartProducts) {
            System.out.println("Product: " + product.getProductName());
            System.out.println("Unit Price: rs" + product.getUnitPrice());
            System.out.println("GST: " + (product.getGst() * 100) + "%");
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Total Price: rs" + product.calculateTotalPrice());
            System.out.println();
        }

        //  displaying total cart price
        System.out.println("Total Cart Price: rs" + cart.calculateTotalCartPrice());

        //  maximum GST amount paid product
        System.out.println("Maximum GST Amount: rs" + cart.findMaxGSTAmount());
        Product maxGSTProduct = cart.findProductWithMaxGSTAmount();
        System.out.println("Product with Maximum GST Amount: " + maxGSTProduct.getProductName());
        System.out.println("Maximum GST Amount: rs" + maxGSTProduct.calculateGSTAmount());
    }
}