package company.controller;

/**
 * Container for our regex
 */

public interface Regex {
    /**
     * @param LAST_NAME_EN_REGEX - regex for latin last name's
     * @param LAST_NAME_UA_REGEX - regex for ukrainian last name's
     * @param NICKNAME_REGEX - regex for available nickname's
     */

    String LAST_NAME_EN_REGEX = "^[A-Z][a-z]{2,50}$";
    String LAST_NAME_UA_REGEX = "^[А-ЩЮЯЇІЄҐ][а-щА-ЩЬьЮюЯяЇїІіЄєҐґ]$";
    String NICKNAME_REGEX = "^[A-Za-z0-9]{5,50}$";
}
