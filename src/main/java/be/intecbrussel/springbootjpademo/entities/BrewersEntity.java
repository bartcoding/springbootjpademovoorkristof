package be.intecbrussel.springbootjpademo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Brewers", schema = "StudentDB1", catalog = "")
public class BrewersEntity {
    private int id;
    private String name;
    private String address;
    private String zipCode;
    private String city;
    private Integer turnover;
    private Collection<BeersEntity> beersById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ZipCode", nullable = true, length = 6)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "City", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "Turnover", nullable = true)
    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrewersEntity that = (BrewersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(city, that.city) &&
                Objects.equals(turnover, that.turnover);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, zipCode, city, turnover);
    }

    @OneToMany(mappedBy = "brewersByBrewerId")
    public Collection<BeersEntity> getBeersById() {
        return beersById;
    }

    public void setBeersById(Collection<BeersEntity> beersById) {
        this.beersById = beersById;
    }
}
