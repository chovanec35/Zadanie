package sk.zadanie.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleDto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String role_id;
    @Column
    private String name;

    public RoleDto() {
    }

    public RoleDto(String role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDto{" + "role_id=" + role_id + ", name=" + name + '}';
    }

}
