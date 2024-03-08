package com.emmanuel.macaulay.AddressBook.model.dto;

import com.emmanuel.macaulay.AddressBook.model.enums.Gender;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AddressBookDTO {

    @Nullable
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private Gender gender;

    @Nullable
    private Timestamp dateCreated;

    @Nullable
    private Timestamp dateUpdated;
}
