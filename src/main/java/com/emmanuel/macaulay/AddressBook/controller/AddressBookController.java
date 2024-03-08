package com.emmanuel.macaulay.AddressBook.controller;


import com.emmanuel.macaulay.AddressBook.model.AddressBook;
import com.emmanuel.macaulay.AddressBook.model.dto.AddressBookDTO;
import com.emmanuel.macaulay.AddressBook.service.AddressBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/api/v1/address-book")
@RestController
public class AddressBookController {

    private final AddressBookService addressBookService;

    @PostMapping("/new")
    public ResponseEntity<AddressBook> createAddressBook(@RequestBody AddressBookDTO request) {

        return new ResponseEntity<>(addressBookService.createAddressBook(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getAddressBook(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(addressBookService.getAddressBookById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AddressBook>> getAllAddressBooks() {
        return ResponseEntity.ok().body(addressBookService.getAllAddressBooks());
    }

    @PutMapping("/update")
    public ResponseEntity<AddressBook> updateAddressBook(@RequestBody AddressBookDTO request) {
        return ResponseEntity.ok().body(addressBookService.updateAddressBook(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressBook(@PathVariable("id") Long id) {
        return new ResponseEntity<>(addressBookService.deleteAddressBook(id), HttpStatus.OK);
    }

}
