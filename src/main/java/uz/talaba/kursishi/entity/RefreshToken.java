package uz.talaba.kursishi.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.digitalone.aptekaapp.domain.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Author: khamza@nightwell-logistics.com
 * Date: 4/22/2023
 * Time: 2:43 PM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "refresh_tokens")
public class RefreshToken extends Auditable {
    private String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RefreshToken that = (RefreshToken) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
