package pojo;

/**
 * Created by Ilya Evlampiev on 20.10.2015.
 */
public enum UserTypes {

    LIZIN("LIZIN"),
    MODER("MODER"),
    ADMIN("ADMIN")
    ;

    private final String text;

    /**
     * @param text
     */
    private UserTypes(final String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
