package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayBookController {

    private final AddressBookRepository addressBookRepository;

    public DisplayBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/displayBook")
    public String displayBook(@RequestParam(name="addressBookId", required=false, defaultValue="1") long addressBookId,
                              Model model) {
        // Pass the requested id to the model
        model.addAttribute("id", addressBookId);

        // Get the AddressBook and pass its data to the model
        AddressBook addressBook = addressBookRepository.findById(addressBookId).orElse(null);

        model.addAttribute("bookExists", addressBook != null);
        if ((addressBook == null) || (addressBook.getBuddyList().isEmpty())) {
            model.addAttribute("buddyList", null);
        }
        else {
            model.addAttribute("buddyList", addressBook.getBuddyList());
        }

        return "displayBook";
    }
}
