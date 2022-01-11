package src.main.javaFiles;

public enum TypesOperations {
    CHOOSE_OPERATION_ONE("1",".Show the contents of the dictionary\n"),
    CHOOSE_OPERATION_TWO("2",".Add an entry\n"),
    CHOOSE_OPERATION_THREE("3",".Delete an entry\n"),
    CHOOSE_OPERATION_FOUR("4",".Search records by key\n"),
    CHOOSE_OPERATION_FIFE("5",".Finish working with this dictionary\n"),
    NOT_SEARCH ("","There is no such answer option.\nPlease try typing again.");
    private final String INFO;
    private final String NUMBER;
    private final String ALLINFO;

    public String getALLINFO() {
        return ALLINFO;
    }

    TypesOperations(String NUMBER, String INFO)
    {
        this.INFO = INFO;
        this.NUMBER = NUMBER;
        this.ALLINFO = NUMBER+INFO;
    }

    public static TypesOperations fromValue(String value) {
        for (final TypesOperations type : values()) {
            if (type.NUMBER.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return NOT_SEARCH;
    }

    public String getINFO() {
        return INFO;
    }

    public String getNUMBER() {
        return NUMBER;
    }
}

