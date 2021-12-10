package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "ImmigrationData")
    public static Object[][] objectTestData() {
        return new Object[][]{
                {"Australia", "Tourism"},
                {"Chile", "Work, academic visit or business"},
                {"Colombia", "Join partner or family for a long stay"},
        };
    }


}
