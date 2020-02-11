package company.controller;

public interface RegexController {

    String  LAST_NAME = "[A-Z]{1}[a-z](2,50)";
    String NICKNAME = "[A-Za-z0-9](5,50)";
}
