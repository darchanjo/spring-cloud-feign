package ns.feigndemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-feign-client/")
public class UserTestControllerUsingFeignClient {

    @Autowired
    private UserClient userClient;

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("Calling User Service using Feign Client!!");
        return userClient.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        System.out.println("Calling User Service using Feign Client!! " + id);
        return userClient.getUser(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") int id) {
        System.out.println("In Delete User");
        System.out.println("New Values");
        return userClient.deleteUser(id);
    }
    
    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        System.out.println("ADD User!!!");
        return userClient.addUser(user);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user){
        System.out.println("Update User");
        System.out.println(user.toString());
        return userClient.updateUser(user);
    }
}
