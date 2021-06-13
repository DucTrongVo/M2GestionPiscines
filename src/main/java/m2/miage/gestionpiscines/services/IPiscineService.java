package m2.miage.gestionpiscines.services;

import m2.miage.gestionpiscines.dto.Piscine;
import m2.miage.gestionpiscines.exceptions.GeneralErreurException;
import m2.miage.gestionpiscines.exceptions.NotFoundException;

import java.util.List;

public interface IPiscineService {
    Piscine getPiscineByRecordID(String recordId) throws GeneralErreurException, NotFoundException;
    List<Piscine> getAllPiscines() throws GeneralErreurException;
}
