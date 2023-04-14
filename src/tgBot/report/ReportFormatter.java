package tgBot.report;

import java.util.List;

//        no_punkz
//        2021-09-25
//        1
//        Из-за внешних факторов все никак не могу сделать задачу со стримами, не хватило времени
//        -----------------
//        no_punkz
//        2021-09-26
//        2
//        Бился над компаратором, пытался накостылить через видимую внешнюю переменную, начал читать о решениях из чата
//        -----------------
//        no_punkz
//        2021-09-27
//        5
//        Продолжаю мучать предпоследнюю задачу (теперь и Толяна), собес на котором узнал много нового

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
