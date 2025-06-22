public class docTest {
    public static void main(String[] args) {
        docFactory wordDocFactoryObj=new wordDocFactory();
        Document wordDoc=wordDocFactoryObj.createDocument();
        wordDoc.open();

        docFactory pdfFactoryObj=new pdfFactory();
        Document pdfDoc= pdfFactoryObj.createDocument();
        pdfDoc.open();

        docFactory excelFactoryObj=new excelFactory();
        Document excelDoc= excelFactoryObj.createDocument();
        excelDoc.open();
    }
    
}
