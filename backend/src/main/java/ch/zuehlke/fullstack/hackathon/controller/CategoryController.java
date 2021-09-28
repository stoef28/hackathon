package ch.zuehlke.fullstack.hackathon.controller;

import ch.zuehlke.fullstack.hackathon.model.Category;
import ch.zuehlke.fullstack.hackathon.service.CategoryService;
import ch.zuehlke.fullstack.hackathon.service.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Category> getAll() {
        List<Category> categories = categoryService.getAll().stream().collect(Collectors.toList());
        return new ResponseEntity(CategoryMapper.toCategoryDto(categories), HttpStatus.OK);
    }
}

