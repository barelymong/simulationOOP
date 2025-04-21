package life.objects;

import life.Entity;

public class Rock extends NaturalEntity{
    private String image = "■";
    public boolean isCrossAbility() {
        return crossAbility;
    }
    boolean crossAbility = false;
    @Override
    public String getImage() {
        return image;
    }
}
