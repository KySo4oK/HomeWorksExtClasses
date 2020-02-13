package company.model;

/**
 * Entity, which represent our data of app in mvc
 */
public class Model {
    /**
     * Data of user
     */
    private String lastName;
    private String nickName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
