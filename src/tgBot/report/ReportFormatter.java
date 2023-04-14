package tgBot.report;

import java.util.List;

public class ReportFormatter {
    public String reportFormatter(List<Report> reports) {
        StringBuilder sb = new StringBuilder("");
        for (Report report : reports) {
            sb.append(report.getStudentUserName() + "\n" +
                    report.getLocalDate() + "\n" +
                    report.getHours() + "\n" +
                    report.getTitle() + "\n");
            if (reports.indexOf(report) != reports.size() - 1) {
                sb.append("-----------------\n");
            }
        }
        return sb.toString();
    }
}
