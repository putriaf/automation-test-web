package utilities;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        BrowserDriver.initialize();
    }

    @After
    public void tearDown() {
        BrowserDriver.quit();
    }
}
