package ags.SechsY.temperaturverwaltung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.repo.ServerRackRepo;

@Service
public class ServerRackService {

    @Autowired
    ServerRackRepo serverRackRepo;

    public ServerRack createRack() {
        return serverRackRepo.save(new ServerRack());
    }

    public List<ServerRack> getAllRacks() {
        return (List<ServerRack>) serverRackRepo.findAll();
    }
}
