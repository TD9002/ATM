package srhe.dittmar.pdfPrinter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import srhe.dittmar.account.Account;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class PdfPrinter {

    public static void writePdf(Account account) throws IOException {
        PDDocument document = new PDDocument();
        PDPage my_page = new PDPage();
        document.addPage(my_page);
        PDPageContentStream contentStream = new PDPageContentStream(document, my_page);

        contentStream.beginText();
        contentStream.newLineAtOffset(25, 700);

        String headline = "Account number %d  Account owner: %s";
        headline = String.format(headline, account.getAccountNumber(), account.getCustomerName());

        contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);
        contentStream.setLeading(14.5f);
        contentStream.showText(headline);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'|'HH:mm:ss");
        for (int i = 0; i < account.getTransactionList().size(); i++) {

            double amount = account.getTransactionList().get(i).getAmount();
            String transaction = account.getTransactionList().get(i).getTransactionType().toString();
            transaction = String.format("%-12s",transaction);
            ZonedDateTime date = account.getTransactionList().get(i).getTransactionTime();
            String time = dateTimeFormatter.format(date);
            contentStream.newLine();
            contentStream.showText(i + 1 + ".  " + time + " || " +transaction + String.format("%+,12.2f€",amount));
        }
        contentStream.newLine();
        contentStream.showText("");
        contentStream.newLine();
        contentStream.showText("Account balance:" + String.format("%+,44.2f€", account.getAccountValue()));
        contentStream.endText();
        contentStream.close();

        String home = System.getProperty("user.home");
        document.save(home+"/documents/" + "accountStatement.pdf");
        System.out.println("PDF created");
        document.close();
        }
    }


