package com.esprit.microservices.candidatecontroller;

import com.esprit.microservices.candidatentity.Candidat;
import com.esprit.microservices.candidateservice.CandidateService;
import com.esprit.microservices.candidatrepository.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
public class CandidatRestAPI {

    private String title = " Hello , I'm the candidate Microservice " ;

    @Autowired
    CandidateService candidatService ;

    @RequestMapping ( "/hello")
    public String sayHello () {
        System.out.println(title) ;
        return title ;
    }
    @Autowired
    CandidatRepository CondidateRepo ;
    @RequestMapping ( "/search")
    public Page<Candidat> searchbyname (@RequestParam String nom, Pageable pageable) {
        return CondidateRepo.candidatByNom(nom,pageable) ;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
        return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK) ;

    }

    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Candidat> updateCandidat(@PathVariable(value="id") int id,
                                                    @RequestBody Candidat candidat){
        return new ResponseEntity<>(candidatService.updateCandidat(id, candidat),HttpStatus.OK);
    }
    @DeleteMapping(value="/id", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value="id") int  id){
        return new ResponseEntity<>(candidatService.deleteCandidate(id),HttpStatus.OK);

    }




}

