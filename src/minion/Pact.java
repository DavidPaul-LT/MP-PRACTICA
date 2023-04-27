package minion;

public class Pact {
    private final String description;
    public Pact(String description){
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public Pact setDescription(String newDescription){
        return new Pact(newDescription);
    }
}
