package to;

/**
 * Created by RLuchinsky on 09.06.2018.
 */
public class RestaurantWithVotes extends BaseTo {

    private String name;
    private String adress;
    private Integer amountOfVoting;

    public RestaurantWithVotes(String name, String adress, Integer amountOfVoting) {
            this(null,name,adress,amountOfVoting);
    }

    public RestaurantWithVotes(Integer id,String name, String adress, Integer amountOfVoting) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.amountOfVoting = amountOfVoting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getAmountOfVoting() {
        return amountOfVoting;
    }

    public void setAmountOfVoting(Integer amountOfVoting) {
        this.amountOfVoting = amountOfVoting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RestaurantWithVotes that = (RestaurantWithVotes) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        return amountOfVoting != null ? amountOfVoting.equals(that.amountOfVoting) : that.amountOfVoting == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (amountOfVoting != null ? amountOfVoting.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RestaurantWithVotes{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", amountOfVoting=" + amountOfVoting +
                '}';
    }
}
