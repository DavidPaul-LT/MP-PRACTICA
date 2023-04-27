package skill;

public class Discipline extends Skill{
    private final int MIN_COST = 1;
    private final int MAX_COST = 3;
    private final int bloodCost;

    public Discipline(int bloodCost) {
        this.bloodCost = bloodCost;
    }

    public int getBloodCost() {
        return this.bloodCost;
    }

}
