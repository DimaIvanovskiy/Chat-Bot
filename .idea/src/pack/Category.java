package pack;

public enum Category {
    QUADRATIC_EQUATION("quadratic equation"),
    GEOGRAPHY("geography"),
    CINEMATOGRAPHY("cinematography"),
    JOKES("jokes");

    private final String name;

    private Category(String name)
    {
        this.name = name;
    }

    public static Category fromString(String string)
    {
        for (Category category : Category.values())
            if (string.equalsIgnoreCase(category.name))
                return category;
        return null;
    }
}
