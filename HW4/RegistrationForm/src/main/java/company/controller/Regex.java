package company.controller;

/**
 * Container for our regex
 */

public interface Regex {
    /**
     * @param LAST_NAME - regex for latin last name's
     * @param NICKNAME - regex for available nickname's
     */

    String  LAST_NAME = "^[A-Z][a-z]{2,50}$";
    String NICKNAME = "^[A-Za-z0-9]{5,50}$";
}
