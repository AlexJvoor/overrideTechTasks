package tgBot.report;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Report {
    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;

    public Report(Long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public LocalDate getDate() {
        return date;
    }

    public String outputString() {
        return studentUserName + "\n" +
                date + "\n" +
                hours + "\n" +
                title + "\n";
    }

    public String reportHistory(List<Report> reports, String studentUserName, int count) {
        String filteredReports = reports.stream()
                .filter(r -> r.getStudentUserName().equals(studentUserName))
                .limit(count)
                .sorted(Comparator.comparing(Report::getDate))
                .map(rep -> rep.outputString())
                .collect(Collectors.joining("-----------------"));
        return filteredReports;
    }
}
