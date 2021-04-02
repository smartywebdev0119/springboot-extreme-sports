package SimiAlex.com.gitlab.extremesportsapp.controllers;

import SimiAlex.com.gitlab.extremesportsapp.model.SportType;
import SimiAlex.com.gitlab.extremesportsapp.repositories.SportTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sport_type")
public class SportTypeController {

    @Autowired
    private SportTypeRepository sportTypeRepository;



}
