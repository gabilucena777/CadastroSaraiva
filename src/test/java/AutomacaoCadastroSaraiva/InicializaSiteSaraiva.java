package AutomacaoCadastroSaraiva;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class InicializaSiteSaraiva {

@Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\java\\AutomacaoCadastroSaraiva\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximizando a janela do navegador
        driver.manage().window().maximize();
        //abrindo o site solicitado
        driver.get("https://www.saraiva.com.br/");

        driver.findElement(By.id("link-account")).click();
        driver.findElement(By.id("loginWithUserAndPasswordBtn")).click();
        driver.findElement(By.id("inputEmail")).sendKeys("gabilucena777@hotmail.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Gabi12345");
        //salvando a janela anterior
        String winHandleBefore = driver.getWindowHandle();
        // clicando na nova janela
        driver.findElement(By.id("classicLoginBtn")).click();
        // mudando para a nova janela aberta
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(4000);

        //iniciando o Javascript para utilizar o scroll de pagina
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //scrolling  ate certo ponto da pagina
        js.executeScript("window.scrollBy(0,300)","");
        driver.findElement(By.cssSelector("a[href='/account#/profile/edit']")).click();

        Thread.sleep(2000);

        // Store campo de nome web element
        WebElement selecionafirstname = driver.findElement(By.cssSelector("input[name='firstName']"));
        Actions actionProvider = new Actions(driver);
        // Perform double-click action on the element
        actionProvider.doubleClick(selecionafirstname).build().perform();
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Gabriela");
        js.executeScript("window.scrollBy(0,300)","");
        // Store campo de sobrenome web element
        WebElement selecionalastname = driver.findElement(By.cssSelector("input[name='lastName']"));
        Actions actionProvider1 = new Actions(driver);
        // Perform double-click action on the element
        actionProvider1.doubleClick(selecionalastname).build().perform();
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Lucena");
        //driver.findElement(By.cssSelector("input[name='document']")).sendKeys("000.000.000-00");
        // Store campo de telefone web element
        WebElement selecionahomePhone = driver.findElement(By.cssSelector("input[name='homePhone']"));
        Actions actionProvider2 = new Actions(driver);
        Actions action1 = new Actions(driver);
        // Perform double-click action on the element
        action1 = actionProvider2.moveToElement(selecionahomePhone).doubleClick();
        //Perform one more click, as needed
        action1.click().build().perform();
        driver.findElement(By.cssSelector("input[name='homePhone']")).sendKeys("8199999999");
        driver.findElement(By.cssSelector("option[value='female']")).click();
        // Store campo de nascimento web element
        WebElement selecionabirthDate = driver.findElement(By.cssSelector("input[name='birthDate']"));
        Actions actionProvider3 = new Actions(driver);
        Actions action2 = new Actions(driver);
        // Perform double-click action on the element
        action2 = actionProvider3.moveToElement(selecionahomePhone).doubleClick();
        // Perform one more click, as needed
        action2.click().build().perform();
        driver.findElement(By.cssSelector("input[name='birthDate']")).sendKeys("01011900");
        js.executeScript("window.scrollBy(0,300)","");
        driver.findElement(By.cssSelector(".flex.items-center.justify-center.h-100.pv2.ph5.w-100.border-box")).click();
        driver.quit();

    }


}








