package life.objects;

import life.Entity;

public class Grass extends NaturalEntity{
    String image = "\uD83C\uDF3F";
    boolean crossAbility = true;
    @Override
    public String getImage() {
        return image;
    }
    public boolean isCrossAbility() {
        return crossAbility;
    }

}
