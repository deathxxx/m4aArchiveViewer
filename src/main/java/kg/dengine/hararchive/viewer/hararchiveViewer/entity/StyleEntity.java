package kg.dengine.hararchive.viewer.hararchiveViewer.entity;

import javax.persistence.*;

@Entity
@Table(name = "style", schema = "allsong", catalog = "Test")
public class StyleEntity {
    private Integer id;
    private String name;
    private Integer count;

    @Transient
    public Integer getCount() {
        return count;
    }

    @Transient
    public void setCount(Integer count) {
        this.count = count;
    }


    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
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

        StyleEntity that = (StyleEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
