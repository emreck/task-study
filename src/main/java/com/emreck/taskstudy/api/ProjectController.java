package com.emreck.taskstudy.api;

import com.emreck.taskstudy.dto.ProjelerDto;
import com.emreck.taskstudy.service.ProjelerService;
import com.emreck.taskstudy.service.impl.ProjelerServiceImpl;
import com.emreck.taskstudy.util.ApiPaths;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.projectCtrl.CTRL)//ana root// localhost:8080/project

public class ProjectController {
    private final ProjelerServiceImpl projelerServiceImpl;

    public ProjectController(ProjelerServiceImpl projelerServiceImpl) {
        this.projelerServiceImpl = projelerServiceImpl;
    }


    //bunun response entitysi var bununla ne yapıyor
    //entity üzerinde varsa mesaj entityi kolay bi şekilde build edebilmeyi sağlayan utility classı
    //geri dönüş tipi responseentity
    @GetMapping("/{id}")//localhost:8080/project/3

    public ResponseEntity<ProjelerDto> getById(@PathVariable(value = "id", required = true) Long id) {
        ProjelerDto projelerDto = projelerServiceImpl.getById(id);
//ProjelerDto projelerDto= projelerServiceImpl.getById(1L);//id si 1 olan Long değikeni dönsün. bize projenin kendisini dönüyor.bize project dto lazım.
        return ResponseEntity.ok(projelerDto); //http 200 isteğiyle beraber project dto içeriğini geri dönecek
    }


    @PostMapping
    public ResponseEntity<ProjelerDto> createProjeler(@Valid @RequestBody ProjelerDto project) {
        return ResponseEntity.ok(projelerServiceImpl.save(project));
    }

    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")

    //put işlemi yaparken id yi ayrıca vermek gerekiyor.
    public ResponseEntity<ProjelerDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjelerDto project) {

        return ResponseEntity.ok(projelerServiceImpl.update(id, project));

    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(projelerServiceImpl.delete(id));
    }

}
