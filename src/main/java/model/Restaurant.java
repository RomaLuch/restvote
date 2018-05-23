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

    @Column(name = "rating", columnDefinition = "int default 0")
    private Integer rating;

    public Restaurant(Integer id, String name, String adress, Integer rating) {
        super(id, name);
        this.adress = adress;
        this.rating = rating;
        }

    public Restaurant(Restaurant r) {
        this(r.id, r.name, r.adress, r.rating);
    }

    public Restaurant() {
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer reiting) {
        this.rating = reiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        return rating != null ? rating.equals(that.rating) : that.rating == null;
    }

    @Override
    public int hashCode() {
        int result = adress != null ? adress.hashCode() : 0;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", reiting=" + rating +
                '}';
    }
}
