public class excelFactory extends docFactory {
    public Document createDocument(){
        return new excelDocument();
    }
    
}
