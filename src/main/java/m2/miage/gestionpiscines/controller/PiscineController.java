package m2.miage.gestionpiscines.controller;

import m2.miage.gestionpiscines.dto.Piscine;
import m2.miage.gestionpiscines.exceptions.GeneralErreurException;
import m2.miage.gestionpiscines.exceptions.NotFoundException;
import m2.miage.gestionpiscines.services.IPiscineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@Controller
@RequestMapping("/piscine")
public class PiscineController {

    private static final Logger logger = LoggerFactory.getLogger(PiscineController.class);

    @Autowired
    IPiscineService piscineService;

    @GetMapping(value = "/")
    private ResponseEntity<Piscine> getPiscineById(@RequestParam String recordID) throws GeneralErreurException, NotFoundException {
        try{
            return  ResponseEntity.ok(piscineService.getPiscineByRecordID(recordID));
        } catch (NotFoundException e){
            throw new NotFoundException(e.getMessage());
        } catch (HttpStatusCodeException e){
            return null;
        }
    }

    @GetMapping(value = "/all")
    private ResponseEntity<List<Piscine>> getPiscines() throws GeneralErreurException {
        try{
            return  ResponseEntity.ok(piscineService.getAllPiscines());
        } catch (HttpStatusCodeException e){
            return null;
        }
    }
}
