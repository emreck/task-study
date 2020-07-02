package com.emreck.taskstudy.api;


import com.emreck.taskstudy.dto.IslerDto;
import com.emreck.taskstudy.service.impl.IslerServiceImpl;
import com.emreck.taskstudy.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IslerCtrl.CTRL)//ana root- localhost:8080/project
public class IslerController {
    private final IslerServiceImpl ıslerServiceImpl;

    public IslerController(IslerServiceImpl ıslerServiceImpl) {
        this.ıslerServiceImpl = ıslerServiceImpl;
    }


    @GetMapping("/{id}")//localhost:8080/project/3
    public ResponseEntity<IslerDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IslerDto projelerDto = ıslerServiceImpl.getById(id);
//ProjelerDto projelerDto= projelerServiceImpl.getById(1L);//id si 1 olan Long değikeni dönsün. bize projenin kendisini dönüyor.bize project dto lazım.
        return ResponseEntity.ok(projelerDto); //http 200 isteğiyle beraber project dto içeriğini geri dönecek
    }

    @PostMapping
    public ResponseEntity<IslerDto> createProjeler(@Valid @RequestBody IslerDto project) {
        return ResponseEntity.ok(ıslerServiceImpl.save(project));

    }

    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    @PutMapping("/{id}")

    public ResponseEntity<IslerDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IslerDto project) {

        return ResponseEntity.ok(ıslerServiceImpl.update(id, project));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(ıslerServiceImpl.delete(id));
    }

}
