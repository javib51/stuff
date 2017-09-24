package simple.contacts.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class AddressController {

    private AddressRepository addressRepository = new AddressRepository();
  /*  @GetMapping(path="/address")
    public Address address() {

        return new Address(0,"Calle San Jose","Madrid","28220","Spain");
    }*/

    @GetMapping(path="/address")
    public @ResponseBody Iterable<Address> getAllAddresses() {
        Iterable<Address> result = null;
        try {
            result = addressRepository.findAll();
        } catch(SQLException se) {
            se.printStackTrace();
        }
        return result;
    }
}
