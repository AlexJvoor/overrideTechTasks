package tgBot.report;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Report {
    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;

    public String getStudentUserName() {
        return studentUserName;
    }

    public Integer getHours() {
        return hours;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String reportHistory(List<Report> reports, String studentUserName, int count) {
        Predicate<Report> predicate = r -> r.getStudentUserName().equals(studentUserName);
        Comparator<Report> comparator = Comparator.comparing(Report::getLocalDate);
        List<Report> lastNReports = reports.stream().filter(predicate)
                .limit(count).sorted(comparator)
                .collect(Collectors.toList());
        ReportFormatter reportFormatter = new ReportFormatter();
        return reportFormatter.reportFormatter(lastNReports);
    }
}
