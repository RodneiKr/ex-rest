package org.kr.exrest.festa;

import org.kr.exrest.common.AbstractKrController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/festa")
public class FestaController extends AbstractKrController<Festa, FestaDocument> {

    @Autowired
    private FestaService service;

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/ALL")
    public @ResponseBody void deleteAll() {
        this.service.deleteAll();
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public @ResponseBody void deleteById(@PathVariable("id") final String id) {
        this.service.deleteById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public @ResponseBody List<FestaDocument> getAll() {
        return this.res(this.service.getAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public @ResponseBody FestaDocument getById(@PathVariable final String id) {
        return this.res(this.service.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public @ResponseBody FestaDocument post(@RequestBody final Festa festa) {
        return this.post(festa, this.service.post(festa));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public @ResponseBody FestaDocument put(@PathVariable("id") final String id, @RequestBody final Festa festa) {
        return this.put(festa, this.service.put(festa));
    }
}
