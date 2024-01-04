package com.house.service;

import com.house.helper.RowCounter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CsvToPdfConverter implements FileConverter {

    @Override
    public void csvToPdfConverter(String source, String destination) {
        File file = new File(source);
        try(CSVReader reader = new CSVReader(new FileReader(file))){
            int rowCount = RowCounter.getRowCount(source);
            String[] line;
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(destination));
            pdf.open();
            PdfPTable table = new PdfPTable(RowCounter.getRowCount(source));
            PdfPCell tableCell = null;
            while((line = reader.readNext()) != null) {
                for (int count = 0; count < rowCount; count++){
                    tableCell = new PdfPCell(new Phrase(new Phrase(line[count])));
                    table.addCell(tableCell);
                }
            }
            pdf.add(table);
            pdf.close();
        }catch(IOException ex){
            throw new RuntimeException("File " + source + " could not be found!");
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException ex) {
            throw new RuntimeException("Not a CSV file!");
        }
    }
}
