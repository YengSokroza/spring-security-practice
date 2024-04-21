package co.istad.springsecuritybasic.init;

import co.istad.springsecuritybasic.model.Authority;
import co.istad.springsecuritybasic.model.Role;
import co.istad.springsecuritybasic.repository.AuthorityRespository;
import co.istad.springsecuritybasic.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final AuthorityRespository authorityRespository;
    private final RoleRepository roleRepository;

    @PostConstruct
    void initData(){
        initAuthorities();
        initRoles();
    }

    private void initAuthorities(){
        List<String> authorities = List.of("READ","WRITE","DELETE");
        if(authorityRespository.count() == 0)
            for(String auth: authorities){
                Authority authority = new Authority();
                authority.setName(auth);
                authorityRespository.save(authority);
            }
    }
    private void initRoles(){
        if(roleRepository.count() == 0){
            Role userRole = new Role();
            userRole.setName("USER");
            userRole.setAuthorities(Set.of(authorityRespository.findByName("READ").get()));
            roleRepository.save(userRole);

            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            adminRole.setAuthorities(new HashSet<>(authorityRespository.findAll()));
            roleRepository.save(adminRole);
        }


    }



}
