package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @Column(name = "adress", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    private String adress;

    public Restaurant(Integer id, String name, String adress) {
        super(id, name);
        this.adress = adress;

        }

    public Restaurant(Restaurant r) {
        this(r.id, r.name, r.adress);
    }

    public Restaurant() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        return adress != null ? adress.equals(that.adress) : that.adress == null;
    }

    @Override
    public int hashCode() {
        return adress != null ? adress.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
