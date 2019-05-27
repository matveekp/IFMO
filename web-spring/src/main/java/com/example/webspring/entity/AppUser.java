package com.example.webspring.entity;

//сущность пользователя в системе
// если класс наывается юзер, таблица так называться не может, нужно через аннотацию @Table(name=...)
//либо создать класс с другим именем, например AppUser


import javax.validation.constraints.*;

public class AppUser {
//
//    @NotNull
//    @Min(45)
//    @Max(100)
    @Size(min =2, max = 10, message = "От 2х до 10 символов") //not null не нужен
    private String login;

    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}", message = "Пароль должен состоять минимум из 8 символов, 1 заглавной, 1 строчной и 1 цифры")
    private String pwd;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
