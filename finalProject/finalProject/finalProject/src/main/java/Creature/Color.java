package Creature;

public enum Color {
    Red("老大"),
    Orange("老二"),
    Yellow("老三"),
    Green("老四"),
    Cyan("老五"),
    Blue("老六"),
    Purple("老七");
    private String name;
    Color(String name) {
        this.name = name;
    }
    String getName()
    {
        return name;
    }
}