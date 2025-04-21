package life;

public abstract class Entity {

    protected String image;
    public abstract String getImage();
    Coordinate coordinate;
    private boolean crossAbility;


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }



    public boolean isCrossAbility() {
        return crossAbility;
    }




}
