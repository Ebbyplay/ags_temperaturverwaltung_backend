package ags.SechsY.temperaturverwaltung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ags.SechsY.temperaturverwaltung.exception.ServerRackNotFoundException;
import ags.SechsY.temperaturverwaltung.model.ServerRack;
import ags.SechsY.temperaturverwaltung.repo.ServerRackRepo;

@Service
public class ServerRackService {

    @Autowired
    ServerRackRepo serverRackRepo;

    public ServerRack createRack() {
        return serverRackRepo.save(new ServerRack());
    }

    public List<ServerRack> findAll() {
        return (List<ServerRack>) serverRackRepo.findAll();
    }

    public ServerRack findById(long id) {
        Optional<ServerRack> rack = serverRackRepo.findById(id);
        if (!rack.isPresent()) {
            throw new ServerRackNotFoundException(id);
        }
        return rack.get();
    }

    public ServerRack updateServerRack(ServerRack rack) {
        return serverRackRepo.save(rack);
    }
}
