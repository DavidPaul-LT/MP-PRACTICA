package skill;

import interfaces.Factory;

import java.io.Serializable;

public class SkillFactory implements Factory {


    private DisciplineFactory df;

    private Gift gf;

    private Talent tlt;



    public SkillFactory(){

        gf = new Gift();

        tlt = new Talent();

        df = new DisciplineFactory();


    }

    @Override
    public Skill create() {

        return null;
    }
}
