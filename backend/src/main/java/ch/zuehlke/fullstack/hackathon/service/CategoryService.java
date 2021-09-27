package ch.zuehlke.fullstack.hackathon.service;

import ch.zuehlke.fullstack.hackathon.model.Category;
import ch.zuehlke.fullstack.hackathon.service.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;
import java.util.Collection;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryBy(long id) {
        return categoryRepository.findById(id).orElseThrow(FindException::new);
    }

    public Collection<Category> getAll() {
        return categoryRepository.findAll();
    }

}
