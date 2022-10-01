package com.esprit.microservices.candidateservice;

import com.esprit.microservices.candidatrepository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservices.candidatentity.Candidat;
import com.esprit.microservices.candidatrepository.CandidatRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidatRepository candidatRepository;

    public Candidat addCandidat(Candidat candidat) {
        return candidatRepository.save(candidat);

    }

    public Candidat updateCandidat(int id, Candidat newCandidat) {
        if (candidatRepository.findById(id).isPresent()) {
            Candidat existingCandidat = candidatRepository.findById(id).get();
            existingCandidat.setNom(newCandidat.getNom());
            existingCandidat.setPrenom(newCandidat.getPrenom());
            existingCandidat.setEmail(newCandidat.getEmail());

            return candidatRepository.save(existingCandidat);
        } else
            return null;


    }
    public String deleteCandidate(int id) {
        if (candidatRepository.findById(id).isPresent()) {
            candidatRepository.deleteById(id);
            return "candidat suppring";
        } else
            return "candidat non supprimé";
    }



}


