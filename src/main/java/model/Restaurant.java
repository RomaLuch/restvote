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
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", reiting=" + rating +
                '}';
    }
}
