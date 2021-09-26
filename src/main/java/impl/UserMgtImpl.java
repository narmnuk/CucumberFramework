package impl;

import org.openqa.selenium.WebElement;
import pages.UserMgtPage;
import utils.SeleniumUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserMgtImpl {

    private UserMgtPage userMgtPage;

    public UserMgtPage getPage() {

        if (userMgtPage == null)
            userMgtPage = new UserMgtPage();

        return userMgtPage;
    }

    Map<String, String> map = new LinkedHashMap<>();

    public void inputFields(String inputField, String value) {

        switch (inputField.toLowerCase()) {
            case "firstname":
                getPage().firstName.sendKeys(value);
                break;
            case "lastname":
                getPage().lastName.sendKeys(value);
                break;
            case "phonenumber":
                getPage().phoneNumber.sendKeys(value);
                break;
            case "email":
                getPage().eMail.sendKeys(value);
                break;
            case "role":
                SeleniumUtils.selectByVisibleText(getPage().role, value);
                break;
        }

        map.put(inputField, value);
    }

    public boolean verifyFields() {

        List<WebElement> allInputs = getPage().tdDataTable;
        for (String key : map.keySet()) {
            for (int dataInput = 0; dataInput < allInputs.size(); dataInput++) {
                if (allInputs.get(dataInput).getText().equals(map.get(key))) {
                    return true;
                }
            }
        }

        return false;
    }

    public String verifyFields2() {

        String result = "PASS";
        List<WebElement> allInputs = getPage().tdDataTable;
        boolean missing = true;
        for (String key : map.keySet()) {
            for (int dataInput = 0; dataInput < allInputs.size(); dataInput++) {
                if (allInputs.get(dataInput).getText().equals(map.get(key))) {
                    missing = false;
                }
            }

            if (missing) {
                result = "FAIL";
            }
        }

        return result;
    }
}