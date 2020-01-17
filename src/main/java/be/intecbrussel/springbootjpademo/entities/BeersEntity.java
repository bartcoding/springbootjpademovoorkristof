package be.intecbrussel.springbootjpademo.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Beers", schema = "StudentDB1", catalog = "")
public class BeersEntity {
    private int id;
    private String name;
    private Double price;
    private Integer stock;
    private Double alcohol;
    private Integer version;
    private byte[] image;
    private Collection<BeerOrderItemsEntity> beerOrderItemsById;
    private BrewersEntity brewersByBrewerId;
    private CategoriesEntity categoriesByCategoryId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Stock", nullable = true)
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Basic
    @Column(name = "Alcohol", nullable = true, precision = 0)
    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    @Basic
    @Column(name = "Version", nullable = true)
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "Image", nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeersEntity that = (BeersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(stock, that.stock) &&
                Objects.equals(alcohol, that.alcohol) &&
                Objects.equals(version, that.version) &&
                Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, price, stock, alcohol, version);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @OneToMany(mappedBy = "beersByBeerId")
    public Collection<BeerOrderItemsEntity> getBeerOrderItemsById() {
        return beerOrderItemsById;
    }

    public void setBeerOrderItemsById(Collection<BeerOrderItemsEntity> beerOrderItemsById) {
        this.beerOrderItemsById = beerOrderItemsById;
    }

    @ManyToOne
    @JoinColumn(name = "BrewerId", referencedColumnName = "Id")
    public BrewersEntity getBrewersByBrewerId() {
        return brewersByBrewerId;
    }

    public void setBrewersByBrewerId(BrewersEntity brewersByBrewerId) {
        this.brewersByBrewerId = brewersByBrewerId;
    }

    @ManyToOne
    @JoinColumn(name = "CategoryId", referencedColumnName = "Id")
    public CategoriesEntity getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(CategoriesEntity categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    @Override
    public String toString() {
        return "BeersEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", alcohol=" + alcohol +
                ", version=" + version +
               '}';
    }
}
