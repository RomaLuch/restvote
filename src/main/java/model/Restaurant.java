package model;

public class Restaurant extends AbstractNamedEntity {

    private Integer reiting;

    public Restaurant(Integer id, String name, Integer reiting) {
        super(id, name);
        this.reiting = reiting;
    }

    public Integer getReiting() {
        return reiting;
    }

    public void setReiting(Integer reiting) {
        this.reiting = reiting;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reiting=" + reiting +
                '}';
    }
}
