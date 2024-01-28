package srhe.dittmar;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import srhe.dittmar.pdfPrinter.PdfPrinter;
import srhe.dittmar.ui.startMenu.StartMenu;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        StartMenu startMenu = new StartMenu();
        startMenu.showDialog();





    }
}