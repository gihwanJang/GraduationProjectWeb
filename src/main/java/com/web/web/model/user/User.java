package com.web.web.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User{
    
    @Id
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String addr;

    public String getId(){return id;}
    public void setId(String id){this.id = id;}

    public String getPw(){return pw;}
    public void setPw(String pw){this.pw = pw;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getTel(){return tel;}
    public void setTel(String tel){this.tel = tel;}

    public String getAddr(){return addr;}
    public void setAddr(String addr){this.addr = addr;}

    @Override
    public String toString(){
        return "User{" +
            "id=" + id +
            ", pw='" + pw + '\'' +
            ", name='" + name + '\'' +
            ", tel='" + tel + '\'' +
            ", addr='" + addr + '\'' +
            '}';
    }

}