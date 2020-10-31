package be.hogent.oefening.docter.service;

import be.hogent.oefening.docter.business.DocterEntity;
import be.hogent.oefening.docter.business.repository.DocterRepository;
import be.hogent.oefening.docter.service.dto.Docter;
import be.hogent.oefening.docter.service.mapper.DocterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DocterService {

    @Autowired
    private DocterRepository docterRepository;

    @Autowired
    private DocterMapper docterMapper;

    public DocterService(DocterRepository docterRepository, DocterMapper docterMapper) {
        this.docterRepository = docterRepository;
        this.docterMapper = docterMapper;
    }

    public List<Docter> getAll() {
        List<Docter> docterList = StreamSupport
                .stream(docterRepository.findAll().spliterator(), false)
                .map(e -> docterMapper.toDTO(e))
                .collect(Collectors.toList());

        return docterList;
    }

    public Docter getById(Long id){
        Optional<DocterEntity> diagnosisEntityOptional = docterRepository.findById(id);
        if(diagnosisEntityOptional.isPresent()){
            return docterMapper.toDTO(diagnosisEntityOptional.get());
        }
        return null;
    }
}
