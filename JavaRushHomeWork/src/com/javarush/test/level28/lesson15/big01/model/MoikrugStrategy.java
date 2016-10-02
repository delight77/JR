package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> result = new ArrayList<>();
        int page = 1;
        while (true){
            Document doc = null;
            try
            {
                doc = getDocument(searchString, page);
            }catch (IOException e){ break; }
            Elements vacancyElements = doc.getElementsByClass("job");
            if (vacancyElements.size() == 0) break;
            for (Element vacancyElement : vacancyElements) {
                Vacancy parsedVacancy = new Vacancy();
                parsedVacancy.setTitle(vacancyElement.getElementsByClass("title").text());
                parsedVacancy.setSiteName(doc.title());
                parsedVacancy.setSalary(vacancyElement.getElementsByClass("count").text());
                parsedVacancy.setCity(vacancyElement.getElementsByClass("location").text());
                parsedVacancy.setCompanyName(vacancyElement.getElementsByClass("company_name").select("a[href]").text());
                parsedVacancy.setUrl(vacancyElement.getElementsByClass("title").select("a").attr("abs:href"));
                result.add(parsedVacancy);
            }
            page++;
            break;
        }
        return result;
    }
    protected Document getDocument(String searchString, int page) throws IOException
    {
        Document document = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").referrer("none").get();
        return document;
    }
}