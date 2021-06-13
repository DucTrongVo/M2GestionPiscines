package m2.miage.gestionpiscines.services;

import m2.miage.gestionpiscines.dto.Piscine;
import m2.miage.gestionpiscines.exceptions.GeneralErreurException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PiscineServiceImpl implements IPiscineService{

    private static final Logger logger = LoggerFactory.getLogger(PiscineServiceImpl.class);

    @Autowired
    protected RestTemplate restTemplatePiscine;

    @Autowired
    private IToolService toolService;

    protected String serviceUrlPiscines;

    public PiscineServiceImpl (String serviceUrlPiscines) {
        this.serviceUrlPiscines = serviceUrlPiscines;
    }
    @Override
    public Piscine getPiscineByRecordID(String recordId) throws GeneralErreurException {
        String piscineJson = restTemplatePiscine.getForObject(this.serviceUrlPiscines+"q=&refine.recordid="+recordId, String.class);
        Piscine piscine = toolService.convertJsonToPiscine(piscineJson);
        logger.info("Piscine d'id {} trouvé est {}",recordId, piscine);
        return piscine;
    }

    @Override
    public List<Piscine> getAllPiscines() throws GeneralErreurException{
        String piscinesJson = restTemplatePiscine.getForObject(this.serviceUrlPiscines+"q=", String.class);
        return toolService.convertJsonToPiscines(piscinesJson);
    }

}
