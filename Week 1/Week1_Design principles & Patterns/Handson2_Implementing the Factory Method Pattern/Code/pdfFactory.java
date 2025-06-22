public class pdfFactory extends docFactory{
    public Document createDocument(){
        return new pdfDocument();
    }
}
