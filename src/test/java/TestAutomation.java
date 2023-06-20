import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestAutomation {
    public static void main(String[] args) {
        // Configurar la ubicación del controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "/Users/juanchacon/Documents/GitHub/Project1/drivers/chromedriver");

        // Crear una instancia del controlador de Chrome
        WebDriver driver = new ChromeDriver();

        // Maximizar la ventana del navegador
        driver.manage().window().maximize();

        // Navegar a una URL
        driver.get("https://demo.evershop.io/");

        //===========================ESCENARIO 1: Flujo de compra de 3 artículos===========================================

        //Click en el Login
        driver.findElement(By.xpath("//a[@href='/account/login']")).click();

        // Ingresar el usuario y contraseña en los campos correspondientes
        driver.findElement(By.name("email")).sendKeys("juan@test.com");
        driver.findElement(By.name("password")).sendKeys("test1234");

        // Hacer clic en el botón de inicio de sesión
        driver.findElement(By.xpath("//button[@type='submit' and span[text()='SIGN IN']]")).click();

        // Esperar para que se complete el inicio de sesión
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click en el primer producto de la lista
        driver.findElement(By.xpath("//div[@class='product-name product-list-name mt-1 mb-025']//a/span[text()='Nike air zoom pegasus 35']")).click();

        //Ingresar 3 unidades del producto
        WebElement inputElement = driver.findElement(By.xpath("//input[@name='qty']"));
        inputElement.clear();
        inputElement.sendKeys("3");

        // Seleccionar la talla y color del producto: "M", "Blue"
        WebElement mButton = driver.findElement(By.xpath("//div[@class='variant variant-container grid grid-cols-1 gap-1 mt-2']//ul[@class='variant-option-list flex justify-start']//a[text()='M']"));
        mButton.click();
        WebElement blueButton = driver.findElement(By.xpath("//ul[@class='variant-option-list flex justify-start']//a[text()='Blue']"));
        blueButton.click();

        // Esperar para que se complete la selección del producto
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encontrar el botón "Add to Cart"
        WebElement addToCartButton = driver.findElement(By.xpath("//div[contains(@class, 'add-to-cart')]//button[@class='button primary outline']//span[text()='ADD TO CART']"));
        addToCartButton.click();

        // Esperar para que se cargue el Popup "JUST ADDED TO YOUR CART"
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click en el botón "View Cart"
        WebElement viewCartButton = driver.findElement(By.xpath("//a[@class='add-cart-popup-button' and contains(text(),'VIEW CART')]"));
        viewCartButton.click();

        // Esperar que se cargue la página de "View Cart"
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click en el botón "CheckOut"
        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='button primary']/span[text()='CHECKOUT']"));
        checkoutButton.click();

        // Esperar que cargue la página de Pago con el formulario de pago
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Ingresar los datos obligatorios en el formulario de Pago
        WebElement form = driver.findElement(By.id("checkoutShippingAddressForm"));
        form.findElement(By.cssSelector("input[name='address[full_name]']")).sendKeys("Juan");
        form.findElement(By.cssSelector("input[name='address[telephone]']")).sendKeys("+1 987743932");
        form.findElement(By.cssSelector("input[name='address[address_1]']")).sendKeys("Lyles St.");
        form.findElement(By.cssSelector("input[name='address[city]']")).sendKeys("Odenville");
        form.findElement(By.cssSelector("select[name='address[country]']")).sendKeys("United States");
        form.findElement(By.cssSelector("select[name='address[province]']")).sendKeys("Alabama");
        form.findElement(By.cssSelector("input[name='address[postcode]']")).sendKeys("35120");

        //Esperar para que cargue las opciones de envío
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click en la opción de envío: "Standar Delivery"
        WebElement standardDeliveryButton = driver.findElement(By.xpath("//label[@for='method0']"));
        standardDeliveryButton.click();

        //Click en el botón "Continue to Payment"
        form.findElement(By.xpath(".//button/span[text()='Continue to payment']")).click();

        //Esperar que cargue la página "Payment Method"
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Seleccionar en la opción "Cash on Delivery" e ingresar los datos de la tarjeta
        WebElement cashOnDelivery = driver.findElement(By.xpath("//*[@id=\"checkoutPaymentForm\"]/div[3]/div[1]/div/div/div/div[1]/a"));
        cashOnDelivery.click();

        //Click en el botón "Place Order"
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[@class='button primary']/span[text()='Place Order']"));
        placeOrderButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cerrar el navegador
        driver.quit();
    }
}

