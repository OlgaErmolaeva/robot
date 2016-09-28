package io.github.bookcrawler.core.impl.empik;

import io.github.bookcrawler.core.BookInfoParser;
import io.github.bookcrawler.core.impl.SourceScrappingResult;
import io.github.bookcrawler.entities.BookInfo;
import io.github.bookcrawler.entities.BookInfoBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmpikBookInfoParser implements BookInfoParser {

    @Override
    public BookInfo parse(SourceScrappingResult sourceScrappingResult) {
        return new BookInfoBuilder()
                .title(sourceScrappingResult.parseEmpikTitle())
                .author(sourceScrappingResult.parseEmpikAuthor().replaceAll("[^A-Za-z\\p{L}]", " ").trim())
                .description(sourceScrappingResult.parseEmpikDescription())
                .price(sourceScrappingResult.parseEmpikPrice())
                .library("EMPIK")
                .inputDate(new java.sql.Date(new java.util.Date().getTime()))
                .url(sourceScrappingResult.location())
                .build();
    }
}
