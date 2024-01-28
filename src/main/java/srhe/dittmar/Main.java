package srhe.dittmar;

import srhe.dittmar.ui.startMenu.StartMenu;

public class Main {
    public static void main(String[] args) {
        StartMenu startMenu = new StartMenu();
        startMenu.showDialog();

/*        PDDocument document = new PDDocument();
        PDPage my_page = new PDPage();
        document.addPage(my_page);
        try {
        document.save("C:\\Users\\Gerät\\Desktop\\JavaPDF/my_doc.pdf");System.out.println("PDF created");
        //Closing the document
        document.close();}
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }*/

    }
}