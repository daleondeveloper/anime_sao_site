package ua.daleondeveloper.sao_site.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//POJO object of user
//For login in site
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @JoinColumn(name = "Nickname")
    private String nickname;
    @JoinColumn(name = "access")
    private String access;

    //ImageId
    private long imageId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<UserRole> roles;

    //Date and Time
    private LocalDate lastUpdateDate;

    public User(String email, String password, String nickname, List<UserRole> roles, LocalDate lastUpdateDate) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.roles = roles;
        this.lastUpdateDate = lastUpdateDate;
    }
}
