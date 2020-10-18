package com.example.mzord.services;

import com.example.mzord.models.Seafarer;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DocParser {

    String fileName = "/Users/mzord/Desktop/crewlist.docx";
    InputStream fis = new FileInputStream(fileName);
    XWPFDocument document = new XWPFDocument(fis);

    List<XWPFParagraph> paragraphs = document.getParagraphs();
    List<XWPFTable> tables = document.getTables();
    XWPFTable table = document.getTableArray(1);

    private List<Seafarer> crew = new ArrayList<>();


    public DocParser(List<Seafarer> seafarerList) throws IOException, OpenXML4JException, XmlException {
        this.crew = seafarerList;
    }


    public void write() throws IOException {
        FileOutputStream out = new FileOutputStream("/Users/mzord/Desktop/teste.docx");
        populateCrewList();
        document.write(out);
    }

    public void populateCrewList() {
        // Ignore o count, eu vou mudar isso.
        int count = 1;
        for (Seafarer member : crew) {
            // Crio um Row para cada membro em crew(List<CrewMember>)
            XWPFTableRow tableRow = table.createRow();
            List<XWPFTableCell> cells = tableRow.getTableCells();

            // Pego o parágrafo da célular para mudar o texto. Nesse caso, cada célular só tem um parágrafo,
            // por isso usei o get(0) na lista de paragrafos.
            XWPFParagraph paragraph = cells.get(0).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(String.valueOf(count));

            paragraph = cells.get(1).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            paragraph.setStyle("Heading1");
            run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(member.getSeafarerName());

            paragraph = cells.get(2).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            paragraph.setStyle("Heading1");
            run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(member.getSeafarerFunction().toString());

            paragraph = cells.get(3).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(member.getNationality());

            paragraph = cells.get(4).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(member.getSeafarerDob().toString());

            paragraph = cells.get(5).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(member.getSeafarerRegister());

            paragraph = cells.get(6).getParagraphs().get(0);
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run = paragraph.createRun();
            run.setBold(true);
            run.setFontSize(8);
            run.setText(member.getEmbarkDate().toString());

            count++;

        }
    }

    public void docSetRowText(
            XWPFTableRow row,
            Seafarer seafarer) {
        List<XWPFTableCell> cells = row.getTableCells();
        for (XWPFTableCell cell : cells) {

        }
        for (XWPFTableCell cell : row.getTableCells()) {
            for (XWPFParagraph paragraph : cell.getParagraphs()) {
                paragraph.removeRun(1);

                if (cell.equals(row.getTableCells().get(0))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText("0", 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(1))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(seafarer.getSeafarerName(), 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(2))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(seafarer.getSeafarerFunction().toString(), 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(3))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(seafarer.getNationality(), 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(4))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(seafarer.getSeafarerDob().toString(), 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(5))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(seafarer.getSeafarerRegister(), 0);
                    }
                }

                if (cell.equals(row.getTableCells().get(6))) {
                    for(XWPFRun run : paragraph.getRuns()) {
                        run.setText(seafarer.getEmbarkDate().toString(), 0);
                    }
                }
            }
        }
    }
}