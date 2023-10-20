package com.github.cbancale.tostringmask;

public class User extends MaskedBaseModel {
    @ToStringMask(type = MaskType.EMAIL)
    String email;

    @ToStringMask(type = MaskType.CUSTOM, len = 4)
    String userName;

    @ToStringMask(type = MaskType.CUSTOM)
    String userName2;

    @ToStringMask(type = MaskType.FULL)
    String password;

    @ToStringMask
    String password2;

    @ToStringMask(type = MaskType.SSN)
    String ssn;

    String description;

    public User(String email, String userName, String userName2, String password, String password2, String ssn,
            String description) {
        this.email = email;
        this.userName = userName;
        this.userName2 = userName2;
        this.password = password;
        this.password2 = password2;
        this.ssn = ssn;
        this.description = description;
    }

}
