package company.controller;

/**
 * Container for our regex
 */

public interface Regex {
    /**
     * @param LAST_NAME_EN - regex for latin last name's
     * @param LAST_NAME_UA - regex for ukrainian last name's
     * @param NICKNAME - regex for available nickname's
     */

    String LAST_NAME_EN = "^[A-Z][a-z]{2,50}$";
    String LAST_NAME_UA = "^[А-ЩЮЯЇІЄҐ][а-щА-ЩЬьЮюЯяЇїІіЄєҐґ]$";
    String NICKNAME = "^[A-Za-z0-9]{5,50}$";
}
