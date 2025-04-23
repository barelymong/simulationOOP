package life.entities.naturalEntities;

public class Grass extends NaturalEntity{
    //String image = "\uD83C\uDF3F";
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
