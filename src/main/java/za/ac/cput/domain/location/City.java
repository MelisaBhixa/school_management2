/*
 * Author: Panashe Muinzani(218186568)
 * Date: 16 June 2022
 */

package za.ac.cput.domain.location;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class City {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    private String id;

    @NotNull @Column(name = "name") private String name;

    @OneToOne
    @JoinColumn(name = "country")
    @NotNull
    private Country country;

    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * public void setCountry(Country country);
     * this.country = country;
     }
     */
    public City(CityBuilder cityBuilder) {
        this.id = cityBuilder.id;
        this.name = cityBuilder.name;
        this.country = cityBuilder.country;
    }

    public City() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    public static class CityBuilder {

        private String id, name;
        private Country country;

        public CityBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public CityBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CityBuilder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public CityBuilder copy(City city) {
            this.id = city.id;
            this.name = city.name;
            this.country = city.country;
            return this;
        }

        public City build() {
            return new City(this);}
    }
}

