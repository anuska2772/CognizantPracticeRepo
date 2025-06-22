import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class searchDemo {
    public static Product linearSearch(Product[] products, int targetId){
        for(Product product:products){
            if(product.productId == targetId){
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId){
        int start=0, end=products.length-1;
        while(start<=end){
            int mid= start+(end-start)/2;
            if(products[mid].productId ==targetId){
                return products[mid];
            }
            else if(products[mid].productId < targetId){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of products");
        int n=sc.nextInt();
        // int prodId[]= new int[100];
        // String prodName[]= new String[100];
        // String catg[]= new String[100];

        Product[] products=new Product[n];
        for(int i=0; i<n; i++){
            System.out.print("Enter product ID:");
            int prodId=sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter product name:");
            String prodName=sc.nextLine();
            

            System.out.print("Enter Category:");
            String catg=sc.nextLine();
            
            products[i]= new Product(prodId, prodName, catg);

        }
        System.out.println("REnter Taget ID");
        int targetId=sc.nextInt();

        System.out.println("Linear Search");
        Product result1=linearSearch(products, targetId);
        if(result1 != null){
            System.out.println("FOUND:"+result1);
        }else{
            System.out.println("Product not found!");
        }

        Arrays.sort(products, Comparator.comparingInt(p->p.productId));
        System.out.println("\nBinary Search");
        Product result2=binarySearch(products, targetId);
        // System.out.println();
        if(result2 != null){
            System.out.println("FOUND:"+result2);
        }else{
            System.out.println("Product not found!");
        }
        sc.close();
    }
}
