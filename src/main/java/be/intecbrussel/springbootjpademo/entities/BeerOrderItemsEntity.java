package be.intecbrussel.springbootjpademo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BeerOrderItems", schema = "StudentDB1", catalog = "")
public class BeerOrderItemsEntity {
    private int id;
    private Integer number;
    private BeerOrdersEntity beerOrdersByBeerOrderId;
    private BeersEntity beersByBeerId;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeerOrderItemsEntity that = (BeerOrderItemsEntity) o;
        return id == that.id &&
                Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number);
    }

    @ManyToOne
    @JoinColumn(name = "BeerOrderId", referencedColumnName = "Id")
    public BeerOrdersEntity getBeerOrdersByBeerOrderId() {
        return beerOrdersByBeerOrderId;
    }

    public void setBeerOrdersByBeerOrderId(BeerOrdersEntity beerOrdersByBeerOrderId) {
        this.beerOrdersByBeerOrderId = beerOrdersByBeerOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "BeerId", referencedColumnName = "Id")
    public BeersEntity getBeersByBeerId() {
        return beersByBeerId;
    }

    public void setBeersByBeerId(BeersEntity beersByBeerId) {
        this.beersByBeerId = beersByBeerId;
    }
}
