//Original code author: Francisco Wagner Costa Aquino (with adaptations)
//Contact: https://www.udemy.com/user/francisco-wagner-costa-aquino/
package br.ce.wcaquino.runners;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "br.ce.wcaquino.steps",
		tags = {"funcionais"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerFuncionalTest {
	
	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.id("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}
}