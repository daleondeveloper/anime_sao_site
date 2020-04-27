package ua.daleondeveloper.sao_site.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Table(name = "Roles")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }
}
