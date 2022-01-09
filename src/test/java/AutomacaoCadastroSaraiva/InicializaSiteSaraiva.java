package AutomacaoCadastroSaraiva;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InicializaSiteSaraiva {


    public static void main(String[] args)    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gabriela\\Desktop\\Gabi\\drivers\\chromedriver.exe");
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

        //iniciando o Javascript para utilizar o scroll de pagina
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //scrolling  ate certo ponto da pagina
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
        //scroll ate o fim da pagina



        //driver.findElement(By.cssSelector("#app > div.main > div > div > div > section > div.saraiva-account-user-profile > div > div > section:nth-child(1) > div > div > div > div > div:nth-child(1) > a:nth-child(4)")).click();
        //driver.quit();

    }


}





