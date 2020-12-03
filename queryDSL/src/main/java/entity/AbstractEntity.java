package entity;

import javax.persistence.*;

@MappedSuperclass
public class AbstractEntity {

    private Long id;

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "general_seq", sequenceName = "generalSequenceGenerator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "general_seq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
