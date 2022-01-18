package ru.job4j.tracker.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        String text = textReport.generate("Report's name", "Report's body");
        System.out.println(text);
        HtmlReport htmlReport = new HtmlReport();
        String html = htmlReport.generate("Report's name", "Report's body");
        System.out.println(html);
        JsonReport jsonReport = new JsonReport();
        String json = jsonReport.generate("Report's name", "Report's body");
        System.out.println(json);
    }
}
