public class loggerTest {
    public static void main(String[] args) {
        logger log1=logger.getInstance();
        logger log2=logger.getInstance();

        log1.log("This is the first log instance");
        log2.log("This is the second log instance");

        if(log1==log2){
            System.out.println("Same logger instances!");
        }
        else{
            System.out.println("Different logger instances!");
        }
    }
}
