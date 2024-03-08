package com.emmanuel.macaulay.AddressBook.service;


import com.emmanuel.macaulay.AddressBook.exception.ResourceNotFoundException;
import com.emmanuel.macaulay.AddressBook.model.AddressBook;
import com.emmanuel.macaulay.AddressBook.model.dto.AddressBookDTO;
import com.emmanuel.macaulay.AddressBook.repository.AddressBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class AddressBookService {

    private final AddressBookRepository addressBookRepository;

    public AddressBook createAddressBook(AddressBookDTO request) {
        AddressBook addressBook = new AddressBook();
        BeanUtils.copyProperties(request, addressBook);
        return addressBookRepository.save(addressBook);
    }

    public AddressBook getAddressBookById(Long id) {
        return addressBookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AddressBook not found!"));
    }

    public List<AddressBook> getAllAddressBooks() {
        return addressBookRepository.findAll();
    }

    public String deleteAddressBook(Long id) {
        try {
            AddressBook addressBook = this.getAddressBookById(id);
            addressBookRepository.delete(addressBook);

            return "AddressBook has been deleted!";
        } catch (Exception e) {
            log.info("Error :: {} ", e.getMessage());
            return "Delete operation failed!";
        }
    }
}
