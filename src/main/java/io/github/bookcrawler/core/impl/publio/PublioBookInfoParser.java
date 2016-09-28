package io.github.bookcrawler.core.impl.publio;

import io.github.bookcrawler.core.BookInfoParser;
import io.github.bookcrawler.core.impl.SourceScrappingResult;
import io.github.bookcrawler.entities.BookInfo;
import io.github.bookcrawler.entities.BookInfoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublioBookInfoParser implements BookInfoParser {

    @Override
    public BookInfo parse(SourceScrappingResult sourceScrappingResult) {
        return new BookInfoBuilder()
                .title(sourceScrappingResult.parsePublioTitle())
                .author(sourceScrappingResult.parsePublioAuthor().replaceAll("[^A-Za-z\\p{L}]", " ").trim())
                .description(sourceScrappingResult.parsePublioDescription())
                .inputDate(new java.sql.Date(new java.util.Date().getTime()))
                .price(sourceScrappingResult.parsePublioPrice())
                .library("PUBLIO")
                .url(sourceScrappingResult.location())
                .build();
    }
}
