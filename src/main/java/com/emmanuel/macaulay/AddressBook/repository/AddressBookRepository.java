package com.emmanuel.macaulay.AddressBook.repository;

import com.emmanuel.macaulay.AddressBook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

}
