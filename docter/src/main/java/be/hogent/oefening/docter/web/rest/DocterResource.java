package be.hogent.oefening.docter.web.rest;

import be.hogent.oefening.docter.business.DocterEntity;
import be.hogent.oefening.docter.business.repository.DocterRepository;
import be.hogent.oefening.docter.service.DocterService;
import be.hogent.oefening.docter.service.dto.Docter;
import be.hogent.oefening.docter.service.mapper.DocterMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DocterResource {
    @Autowired
    private DocterService docterService;

    @Autowired
    private DocterRepository docterRepository;

    @Autowired
    private DocterMapper docterMapper;

    @GetMapping("/docters")
    public ResponseEntity<List<Docter>> getAll(){
        List<Docter> docters = docterService.getAll();
        return ResponseEntity.ok(docters);
    }

    @GetMapping("/docters/{id}")
    public ResponseEntity<Docter> getById(@PathVariable Long id){
        Docter docter = docterService.getById(id);
        if(docter==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(docter);
    }

    @PostMapping("/docters")
    public ResponseEntity<DocterEntity> createDocter(@RequestBody Docter docter){
        DocterEntity returnValue = docterMapper.toEntity(docter);
        docterRepository.save(returnValue);

        return ResponseEntity.ok(returnValue);
    }
}
