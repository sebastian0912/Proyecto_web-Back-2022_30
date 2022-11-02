package com.Back.controladores;

import com.Back.modelo.Usuario;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class pdfGenerator {

    void Contrato(Usuario us) {
        Date date = new Date();
        File file = new File(us.getUsername() + "-Contrato.pdf");

        try (PdfWriter pdfWriter = new PdfWriter(file)) {

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph p = new Paragraph("CONTRATO DE TRABAJO A TÉRMINO INDEFINIDO CON SALARIO ORDINARIO,\n" +
                    "\n" +
                    "PERSONAL DE DIRECCIÓN, MANEJO Y CONFIANZA \n\n");
            Paragraph a = new Paragraph("Fecha de elaboracion " + date + "\n\n");
            Paragraph b = new Paragraph("Entre: \n" +
                    "La empresa: " + "Tu Alianza S.A.S" + "\n" +
                    "Representada por: " + "Maikol Alexander Vergara Torres" + "\n" +
                    "Con domicilio en: " + "Calle 71c #94a -72" + "\n" +
                    "R.F.C.: " + "855615674897474155441" + "\n" +
                    "A quien en lo sucesivo se le denominará: EL PATRÓN \n\n");
            Paragraph c = new Paragraph("Y \n" +
                    "El trabajador: " + us.getNombre() + " " + us.getApellido() + "\n" +
                    "Con domicilio en: " + "Calle 90a #85-47" + "\n" +
                    "R.F.C.: " + "100581505" + "\n" +
                    "A quien en lo sucesivo se le denominará: EL TRABAJADOR \n\n");
            Paragraph d = new Paragraph("Que celebran el presente contrato de trabajo a término indefinido, en los términos de la Ley Federal del Trabajo, para desempeñar el puesto de: " + "Asesor" + "\n\n");
            Paragraph e = new Paragraph("CLÁUSULA PRIMERA.- EL TRABAJADOR prestará sus servicios al PATRÓN en la ciudad de Bogotá, D.C., en la dirección antes señalada, en el horario de: " + "7:00 a.m - 6:00 p.m" + "\n\n");

            document.add(p);
            document.add(a);
            document.add(b);
            document.add(c);
            document.add(d);
            document.add(e);
            document.close();
            pdfDocument.close();

            System.out.println("PDF creado");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }


    void CertificadoLaboral(Usuario us) {
        Date date = new Date();
        File file = new File(us.getUsername() + "-CertificadoLaboral.pdf");
        try (PdfWriter pdfWriter = new PdfWriter(file)) {
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph p = new Paragraph("CERTIFICADO LABORAL \n\n");
            Paragraph a = new Paragraph("Fecha de elaboracion " + date + "\n\n");
            Paragraph b = new Paragraph("Yo, " + "Maikol Alexander Vergara Torres" + ", identificado con la cédula de ciudadanía número " +
                    "100581505" + ", actuando en mi calidad de " + "Gerente General" + " de la empresa "
                    + "Tu Alianza S.A.S" + ", con domicilio en " + "Calle 71c #94a -72" +
                    ", certifico que el trabajador " + us.getNombre() + " " + us.getApellido() +
                    ", identificado con la cédula de ciudadanía número " + "100581505" + ", laboró en esta empresa desde el " + "01/01/2021" + " hasta el " + "01/01/2021" + ", desempeñando el cargo de " + "Asesor" + ", con un salario mensual de " + "1000000" + " pesos, y que durante su permanencia en la empresa no se le presentaron faltas disciplinarias, ni se le aplicaron sanciones de ninguna clase, ni tampoco se le presentaron denuncias por parte de terceros. \n\n");
            Paragraph c = new Paragraph("Se expide el presente certificado a solicitud del interesado, para los fines que estime conveniente. \n\n");
            Paragraph d = new Paragraph("Bogotá, D.C., " + date + "\n\n");
            Paragraph e = new Paragraph("Firma: " + "Maikol Alexander Vergara Torres" + "\n\n");

            document.add(p);
            document.add(a);
            document.add(b);
            document.add(c);
            document.add(d);
            document.add(e);
            document.close();
            pdfDocument.close();

            System.out.println("PDF creado");

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());


        }

    }
}