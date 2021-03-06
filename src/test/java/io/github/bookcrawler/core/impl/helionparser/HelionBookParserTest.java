package io.github.bookcrawler.core.impl.helionparser;

import io.github.bookcrawler.core.impl.SourceScrappingResult;
import io.github.bookcrawler.core.impl.SourceScrappingStatus;
import io.github.bookcrawler.entities.BookInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelionBookParserTest {

    @Test
    public void testParsingBookElementsFromDocument() throws IOException {
        //given
        HelionBookParser helionBookParser = new HelionBookParser();

        Document source = Jsoup.parse(new File("src/test/java/io/github/bookcrawler/core/" +
                "impl/helionparser/helion_promo_of_the_day.html"), "UTF-8");
        SourceScrappingResult sourceScrappingResult = new SourceScrappingResult(source, SourceScrappingStatus.SUCCESS);

        String expectedTitle = "Sprint projektowy. Tworzenie produkt�w cyfrowych";
        String expectedAuthor = "Richard Banfield C. Todd Lombardo Trace Wax";
        String expectedDescription = "Sprintem do sukcesu!";
        String expectedPrice = "30% discount";
        String expectedLibrary = "Helion";


        //when
        BookInfo book = helionBookParser.parse(sourceScrappingResult);

        //then
        assertThat(book.getTitle(), is(expectedTitle));
        assertThat(book.getAuthor(), is(expectedAuthor));
        assertThat(book.getDescription(), is(expectedDescription));
        assertThat(book.getPrice(), is(expectedPrice));
        assertThat(book.getLibrary(), is(expectedLibrary));
    }


}