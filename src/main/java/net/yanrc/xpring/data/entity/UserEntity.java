package net.yanrc.xpring.data.entity;

/**
 * UserDto
 *
 * @auther hzyanricheng
 * @create 2016-04-16 10:08
 */
public class UserEntity {
    private Integer id;
    private String name;
    private String password;
    private String mobile;
    private String email;

    public UserEntity(){

    }

    public UserEntity(Integer id, String name, String password, String mobile, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
