package extclasses.first_sb.service;

import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@org.springframework.stereotype.Service
@Component
public class Service {
    private static final String BUNDLE_NAME = "messages";

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public static void setResourceBundle(ResourceBundle resourceBundle) {
        Service.resourceBundle = resourceBundle;
    }

    public static final String ENG = "en";
    private static final String MAIN_MESSAGE = "main.message";
    private static ResourceBundle resourceBundle =
            ResourceBundle.getBundle(BUNDLE_NAME, new Locale(ENG));

    public void changeLocale(String lang) {
        if (!lang.equals(ENG)) {
            resourceBundle =
                    ResourceBundle.getBundle(BUNDLE_NAME, new Locale("UA", "ua"));
        }
    }

    public String getMessageFromProperties() {
        return resourceBundle.getString(MAIN_MESSAGE);
    }
}
