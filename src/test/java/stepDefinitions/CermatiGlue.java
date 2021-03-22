package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CermatiGlue {
private static WebDriver driver;
	
	@Given("user enter the sign up site")
	public void user_enter_the_sign_up_site() {
		System.setProperty("webdriver.chrome.driver","D://PRA-KERJA//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cermati.com/gabung");
	}

	@When("user input email")
	public void user_input_email() {
	    WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
	    email.sendKeys("iss16059@students.del.ac.id");
	}

	@When("user input kata sandi")
	public void user_input_kata_sandi() {
		WebElement kataSandi = driver.findElement(By.xpath("//input[@id='password']"));
		kataSandi.sendKeys("CermatiTesting2021");
	}

	@When("user input konfirmasi kata sandi")
	public void user_input_konfirmasi_kata_sandi() {
		WebElement konfirmasiKataSandi = driver.findElement(By.xpath("//input[@id='confirm-password']"));
		konfirmasiKataSandi.sendKeys("CermatiTesting2021");
	}

	@When("user input nama anda")
	public void user_input_nama_anda() {
		WebElement namaDepan = driver.findElement(By.xpath("//input[@id='first-name']"));
		namaDepan.sendKeys("Grace");
	}

	@When("user input nama belakang")
	public void user_input_nama_belakang() {
		WebElement namaBelakang = driver.findElement(By.xpath("//input[@id='last-name']"));
		namaBelakang.sendKeys("Jenner");
	}

	@When("user input nomor telepon")
	public void user_input_nomor_telepon() {
		WebElement nomorTelepon = driver.findElement(By.xpath("//input[@id='mobile-phone']"));
		nomorTelepon.sendKeys("082362286164");
	}

	@When("user choose kabupaten kota")
	public void user_choose_kabupaten_kota() {
		String kota = "KOTA JAKARTA PUSAT";
		
		WebElement kabupatenKota = driver.findElement(By.xpath("//input[@id='residence-city']"));
		By listKabupaten = By.xpath("//div[@class='autocomplete-list']/div[@class='autocomplete-list-item highlighted']");
		List<WebElement>kabupatens = driver.findElements(listKabupaten);
		
		kabupatenKota.sendKeys(kota);
		for(WebElement kab:kabupatens) {
			if(kab.getText().equalsIgnoreCase(kota)) {
				kab.click();
			}
		}
	}

	@When("click daftar akun button")
	public void click_daftar_akun_button() {
	    WebElement daftarAkun = driver.findElement(By.xpath("//div[@class='form-group']/button[@data-button-name='sign-up.submit']"));
	    daftarAkun.click();
	}

	@Then("user successfully registered")
	public void user_successfully_registered() {
	    System.out.println("Sucesss");
	}
}
