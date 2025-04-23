package life.entities.naturalEntities;

public class Ground extends NaturalEntity{
    private String image = "☐";

    boolean crossAbility = true;
    public boolean isCrossAbility() {
        return crossAbility;
    }
    @Override
    public String getImage() {
        return image;
    }
}
