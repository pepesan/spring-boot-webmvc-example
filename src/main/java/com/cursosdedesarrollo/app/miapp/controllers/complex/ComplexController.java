package com.cursosdedesarrollo.app.miapp.controllers.complex;

import com.cursosdedesarrollo.app.miapp.domain.complex.Group;
import com.cursosdedesarrollo.app.miapp.domain.complex.User;
import com.cursosdedesarrollo.app.miapp.domain.complex.UserGroup;
import com.cursosdedesarrollo.app.miapp.repositories.complex.GroupRepository;
import com.cursosdedesarrollo.app.miapp.repositories.complex.UserGroupRepository;
import com.cursosdedesarrollo.app.miapp.repositories.complex.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/complex")
public class ComplexController {
    Logger logger = LoggerFactory.getLogger(ComplexController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private UserGroupRepository userGroupRepository;
    private List<User> listado;
    ComplexController(){
        this.listado = new ArrayList<>();
    }
    @GetMapping()
    public String lista(Model modelo) {
        this.listado = userRepository.findAll();
        modelo.addAttribute("listado", listado);
        return "complex/listado";

    }

    @GetMapping("/insert")
    public String insert(Model modelo) {

        Long actualSize=userRepository.count();
        logger.trace("/mvc/insert: actualSize="+actualSize);
        if ( actualSize.equals(0L)){
            User user = new User();
            user.setUsername("pepe");
            user.setPassword("san");
            user.setEmail("pepesan@gmail.com");
            userRepository.save(user);
            logger.trace(user.toString());
            System.out.println("/mvc/insert: user="+user);
            Group group = new Group();
            group.setName("Admin");
            groupRepository.save(group);
            logger.trace(group.toString());
            System.out.println("/mvc/insert: group="+group);
            Group group2 = new Group();
            group2.setName("SemiAdmin");
            groupRepository.save(group2);
            logger.trace(group2.toString());
            System.out.println("/mvc/insert: group="+group2);
            UserGroup userGroup = new UserGroup();
            //userGroup.setUser(user);
            userGroup.setGroup(group);
            userGroup.setActivated(true);
            userGroup.setRegisteredDate(new Date());
            userGroupRepository.save(userGroup);
            logger.trace(userGroup.toString());
            System.out.println("/mvc/insert: usergroup="+userGroup);
            UserGroup userGroup2 = new UserGroup();
            //userGroup2.setUser(user);
            userGroup2.setGroup(group2);
            userGroup2.setActivated(true);
            userGroup2.setRegisteredDate(new Date());
            userGroupRepository.save(userGroup2);

            user.getUserGroups().add(userGroup);
            user.getUserGroups().add(userGroup2);
            userRepository.save(user);
            /*

            group.getUserGroups().add(userGroup);
            groupRepository.save(group);
            group2.getUserGroups().add(userGroup2);
            groupRepository.save(group2);

             */
            logger.trace(userGroup.toString());
            System.out.println("/mvc/insert: usergroup="+userGroup);

        }
        List<User> usuarios = userRepository.findAll();
        modelo.addAttribute("listado", usuarios);
        System.out.println(usuarios);
        return "complex/listado";

    }
}
