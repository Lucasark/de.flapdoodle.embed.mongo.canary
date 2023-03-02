package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private UserRepository repository;

    public void createUser(String name) {
        User user = new User(name);
        repository.save(user);

        OtherService service = applicationContext.getBean("otherService", OtherService.class);
        service.foo();
    }
}
