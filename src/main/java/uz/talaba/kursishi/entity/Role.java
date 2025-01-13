package uz.talaba.kursishi.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import uz.digitalone.aptekaapp.domain.Auditable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: khamza@nightwell-logistics.com
 * Date:8/9/2024
 * Time:7:10 PM
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "roles")
public class Role extends Auditable implements GrantedAuthority, Serializable {

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "permission_id", referencedColumnName = "id")
            })
    private Set<Permission> permissions = new HashSet<>();

    @Column(name = "main_url")
    private String mainUrl;

    @Override
    public String getAuthority() {
        return roleName;
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
