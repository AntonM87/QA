package bellintegrator_homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests extends BaseTest{

    private String word = "гладиолус";
    private WebDriverWait wait;

    @Test
    public void gladiolusTest(){
        chromeDriver.get("https://www.google.com/");
        WebElement searchField = chromeDriver.findElement(By.xpath("//form[@action='/search']//textarea"));
        searchField.click();
        searchField.sendKeys("гладиолус\n");
        WebElement resultSearch = chromeDriver.findElement(By.xpath("//span[normalize-space(.)='Википедия']"));

        this.wait = new WebDriverWait(chromeDriver, 120);
//        System.out.println(resultSearch.getText());
        Assertions.assertEquals("википедия",resultSearch.getText().toLowerCase(),"Информация о " + this.word + " в википедии отсутсвует");
    }
}
