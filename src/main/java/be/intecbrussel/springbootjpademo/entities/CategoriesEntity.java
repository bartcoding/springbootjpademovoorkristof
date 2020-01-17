package be.intecbrussel.springbootjpademo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Categories", schema = "StudentDB1", catalog = "")
public class CategoriesEntity {
    private int id;
    private String category;
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
    @Column(name = "Category", nullable = true, length = 50)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriesEntity that = (CategoriesEntity) o;
        return id == that.id &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<BeersEntity> getBeersById() {
        return beersById;
    }

    public void setBeersById(Collection<BeersEntity> beersById) {
        this.beersById = beersById;
    }
}
