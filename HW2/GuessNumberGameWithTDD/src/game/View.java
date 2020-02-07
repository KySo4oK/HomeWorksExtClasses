package game;

public class View {
    private final String SEPARATOR = " ";
    private final String THAN = "than";
    private final String GREATER = "grater";
    private final String LESSER = "lesser";
    private final String EQUAL = "equal";

    public String getSEPARATOR() {
        return SEPARATOR;
    }

    public String getTHAN() {
        return THAN;
    }

    public String getGREATER() {
        return GREATER;
    }

    public String getLESSER() {
        return LESSER;
    }

    public String getEQUAL() {
        return EQUAL;
    }

    public String makeResult(String... words) {
        String result = "";
        for(int i = 0; i < words.length; i++){
            result += words[i] + SEPARATOR;
        }
        return result;
    }
}
