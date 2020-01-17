package be.intecbrussel.springbootjpademo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "BeerOrders", schema = "StudentDB1", catalog = "")
public class BeerOrdersEntity {
    private int id;
    private String name;
    private Collection<BeerOrderItemsEntity> beerOrderItemsById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerOrdersEntity that = (BeerOrdersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "beerOrdersByBeerOrderId")
    public Collection<BeerOrderItemsEntity> getBeerOrderItemsById() {
        return beerOrderItemsById;
    }

    public void setBeerOrderItemsById(Collection<BeerOrderItemsEntity> beerOrderItemsById) {
        this.beerOrderItemsById = beerOrderItemsById;
    }
}
