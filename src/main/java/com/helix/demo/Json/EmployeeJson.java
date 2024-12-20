package com.helix.demo.Json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeJson {
    private long id;
    private String name;
    private String email;
    private String j_date;
    private String Mob_no;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJ_date() {
        return j_date;
    }
    public void setJ_date(String j_date) {
        this.j_date = j_date;
    }
    public String getMob_no() {
        return Mob_no;
    }
    public void setMob_no(String mob_no) {
        Mob_no = mob_no;
    }
}
