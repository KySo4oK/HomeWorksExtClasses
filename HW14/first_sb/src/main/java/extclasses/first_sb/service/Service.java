package extclasses.first_sb.service;

import extclasses.first_sb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@org.springframework.stereotype.Service
@Component
public class Service {
    @Autowired
    private UserRepository userRepository;
    private static final String BUNDLE_NAME = "messages";

    public static ResourceBundle getResourceBundle() {
        return resourceBundle;
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

    public String getMessageFromPropertiesWithNameFromDB() {
        String nameFromDB = getNameFromDB();
        return getMessageFromProperties() + " " + nameFromDB;
    }

    private String getNameFromDB() {
        String nameFromDB;
        if (Service.getResourceBundle().getLocale().equals(new Locale(Service.ENG))) {
            nameFromDB = userRepository.findAll().iterator().next().getNameInLat();
        } else {
            nameFromDB = userRepository.findAll().iterator().next().getNameInUkr();
        }
        return nameFromDB;
    }

    private String getMessageFromProperties() {
        return resourceBundle.getString(MAIN_MESSAGE);
    }
}
