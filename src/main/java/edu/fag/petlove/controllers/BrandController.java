package edu.fag.petlove.controllers;

import edu.fag.petlove.models.Brand;
import edu.fag.petlove.services.BrandService;
import edu.fag.petlove.services._GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController extends _GenericController<Brand> {
    @Autowired
    BrandService brandService;

    @Override
    protected _GenericService<Brand> getService() {
        return brandService;
    }
}
