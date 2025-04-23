package life.entities.naturalEntities;

public class Tree extends NaturalEntity {
    String image = "\uD83C\uDF34";

    boolean crossAbility = false;
    public boolean isCrossAbility() {
        return crossAbility;
    }
    @Override
    public String getImage() {
        return image;
    }
}
