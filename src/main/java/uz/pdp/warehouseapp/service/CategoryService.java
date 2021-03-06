package uz.pdp.warehouseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehouseapp.entity.Category;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.payload.CategoryDTO;
import uz.pdp.warehouseapp.projection.CategoryProjection;
import uz.pdp.warehouseapp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ApiResponse saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        if (categoryDTO.getParentId() != null) {
            Optional<Category> optionalCategory = categoryRepository.findById(categoryDTO.getParentId());
            category.setParentCategory(optionalCategory.get());
        } else {
            category.setParentCategory(null);
        }
        categoryRepository.save(category);
        return new ApiResponse("Saved!", true);
    }

    public ApiResponse getParents() {
        List<Category> categoryNull = categoryRepository.findAllByParentCategoryIsNull();
        return new ApiResponse("Mana", true, categoryNull);
    }

    public ApiResponse getByParentId(Integer id) {
        List<CategoryProjection> allByParentCategoryId = categoryRepository.findAllByParentCategoryId(id);
        return new ApiResponse("Mana", true, allByParentCategoryId);
    }

    public ApiResponse edit(Integer id, CategoryDTO categoryDTO) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (!categoryOptional.isPresent()) return new ApiResponse("NOT", false);

        Category edit = categoryOptional.get();
        if (categoryDTO.getName() != null) {
            edit.setName(categoryDTO.getName());
        }
        if (categoryDTO.getParentId() != null) {
            Optional<Category> byId = categoryRepository.findById(categoryDTO.getParentId());
            edit.setParentCategory(byId.get());
        }
//        if (categoryDTO.getParentId() != 0) {
//        } else {
//            edit.setParentCategory(null);
//        }
        categoryRepository.save(edit);
        return new ApiResponse("EDIT!", true);
    }

    public ApiResponse getOne(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.map(category -> new ApiResponse("Mana", true, category)).orElseGet(() -> new ApiResponse("NOT FOUND!", false));
    }

    public ApiResponse delete(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
        return new ApiResponse("Success!", true);
    }
}
