package ua.daleondeveloper.sao_site.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "avatarImg", referencedColumnName = "id")
    @JsonBackReference
    private ImageAvatar avatarImg;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<UserRole> roles;

    //Date and Time
    @JoinColumn(name = "releaseDataAndTime")
    private LocalDateTime releaseDateTime;
    @JoinColumn(name = "lastUpdateDateTime")
    private LocalDateTime lastUpdateDateTime;

    public User(String email, String password, String nickname, List<UserRole> roles, LocalDateTime lastUpdateDateTime) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.roles = roles;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }
}
