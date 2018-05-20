package model;

public class Restaurant extends AbstractNamedEntity {

    private String adress;
    private Integer reiting;

    public Restaurant(Integer id, String name, String adress, Integer reiting) {
        super(id, name);
        this.adress = adress;
        this.reiting = reiting;
        }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
                ", adress='" + adress + '\'' +
                ", reiting=" + reiting +
                '}';
    }
}
