package chromedriver;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetWebDriver {
	WebDriver driver;

	private File logLocation;

	public SetWebDriver() throws IOException {
		System.setOut(new PrintStream(getLogLocation()));
		ChromeOptions options = new ChromeOptions();

		// Add the incognito argument to the options
		options.addArguments("--incognito");

		ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out)

				.build();
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");

		driver = new ChromeDriver(service,options);
		
	}

	public void SetUrl(String url) {
		driver.get(url);
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	private File getLogLocation() throws IOException {
		if (logLocation == null || !logLocation.exists()) {
			logLocation = File.createTempFile("chromedriver-", ".log");
		}

		return logLocation;
	}
}
