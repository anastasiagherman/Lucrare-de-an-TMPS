package Entity;

public class Room {
    private String mainName;

    public Room() {
        mainName = "empty";
    }

    public void setName(String name) {
        mainName = name;
    }
    public String getName() {
        return mainName;
    }

}
