package com.example.mzord.services;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DocParser {

    String fileName = "/Users/mzord/Desktop/crewlist.docx";
    InputStream fis = new FileInputStream(fileName);
    XWPFDocument document = new XWPFDocument(fis);

    List<XWPFParagraph> paragraphs = document.getParagraphs();
    List<XWPFTable> tables = document.getTables();
    XWPFTable table = document.getTableArray(1);

    private XWPFTableRow cmt = table.getRow(1);
    private XWPFTableRow imt = table.getRow(2);
    private XWPFTableRow oqn = table.getRow(3);
    private XWPFTableRow mcb = table.getRow(4);
    private XWPFTableRow mnc1 = table.getRow(5);
    private XWPFTableRow mnc2 = table.getRow(6);
    private XWPFTableRow mnc3 = table.getRow(7);
    private XWPFTableRow mnc4 = table.getRow(8);
    private XWPFTableRow cfm = table.getRow(9);
    private XWPFTableRow sfm = table.getRow(10);
    private XWPFTableRow cdm = table.getRow(11);
    private XWPFTableRow mnm1 = table.getRow(12);
    private XWPFTableRow mnm2 = table.getRow(13);
    private XWPFTableRow cza = table.getRow(14);
    private XWPFTableRow taa = table.getRow(15);


    public DocParser() throws IOException, OpenXML4JException, XmlException {

        docSetText(
                cmt,
                "01",
                "Le Captain",
                "CMT",
                "BRASILEIRA",
                "02/12/1992",
                "381Pcarteado",
                "01/01/1960"
        );

        FileOutputStream out = new FileOutputStream("/Users/mzord/Desktop/teste.docx");
        document.write(out);
    }

    public void docSetText(
            XWPFTableRow row,
            String number,
            String name,
            String function,
            String nationality,
            String dob,
            String register,
            String embarkDate) {
        List<XWPFTableCell> cells = row.getTableCells();
        for (XWPFTableCell cell : cells) {

        }
        for (XWPFTableCell cell : row.getTableCells()) {
            for (XWPFParagraph paragraph : cell.getParagraphs()) {
                paragraph.removeRun(1);

                if (cell.equals(row.getTableCells().get(0))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(number, 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(1))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(name, 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(2))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(function, 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(3))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(nationality, 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(4))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(dob, 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(5))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(register, 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(6))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(embarkDate, 0);
                    }
                }
            }
        }
    }
}