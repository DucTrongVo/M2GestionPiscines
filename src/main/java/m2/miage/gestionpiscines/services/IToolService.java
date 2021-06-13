package m2.miage.gestionpiscines.services;

import m2.miage.gestionpiscines.dto.Piscine;
import m2.miage.gestionpiscines.exceptions.GeneralErreurException;

import java.util.List;

public interface IToolService {
    Piscine convertJsonToPiscine(String json) throws GeneralErreurException;
    List<Piscine> convertJsonToPiscines(String json) throws GeneralErreurException;
}
