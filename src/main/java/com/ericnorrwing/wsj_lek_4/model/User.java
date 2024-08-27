package com.ericnorrwing.wsj_lek_4.model;

//Records are always "final"
//Generates automatic methods (get/set/hash/equals/toString etc)

public record User(
        int id,
        String username,
        String password

) {
}
