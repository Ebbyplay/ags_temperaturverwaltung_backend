package ags.SechsY.temperaturverwaltung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ags.SechsY.temperaturverwaltung.dto.response.ServerRackResponseDTO;
import ags.SechsY.temperaturverwaltung.mapper.response.ServerRackResponseMapper;
import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.service.ServerRackService;

@RestController
@RequestMapping(value = "/serverrack", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServerRackController {

    @Autowired
    private ServerRackService rackService;

    @Autowired
    private ServerRackResponseMapper mapper;

    @GetMapping("/{id}")
    public ServerRackResponseDTO findById(@PathVariable long id) {
        ServerRack rack = rackService.findById(id);
        return mapper.mapEntity(rack);
    }

    @GetMapping("/findAll")
    public List<ServerRackResponseDTO> findAll() {
        List<ServerRackResponseDTO> dtos = new ArrayList<>();
        for (ServerRack rack : rackService.findAll()) {
            dtos.add(mapper.mapEntity(rack));
        }
        return dtos;
    }

    @PostMapping("/create")
    public ServerRack create() {
        return rackService.create();
    }

    @PutMapping("/update")
    public ServerRack update(@RequestBody ServerRack rack) {
        return rackService.update(rack);
    }

}
