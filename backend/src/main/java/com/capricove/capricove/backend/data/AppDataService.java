package com.capricove.capricove.backend.data;

import com.capricove.capricove.backend.entities.CategoryDAO;
import com.capricove.capricove.backend.entities.MenuDAO;
import com.capricove.capricove.backend.entities.OptionDAO;
import com.capricove.capricove.backend.entities.TagDAO;
import com.capricove.capricove.backend.repositories.CategoryRepository;
import com.capricove.capricove.backend.repositories.MenuRepository;
import com.capricove.capricove.backend.repositories.OptionRepository;
import com.capricove.capricove.backend.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AppDataService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private TagRepository tagRepository;

    public void addMenu(Menu menu) throws SQLException {
        //insert single attributes linearly
        //insert into menu table
        menuRepository.save(new MenuDAO(menu.getId(), menu.getName(), menu.getSection(), menu.getPrice(), menu.getSrc(), menu.getDescription()));

        //insert into tags table
        for (String tag: menu.getTags()){
            tagRepository.save(new TagDAO(menu.getId(), tag));
        }

        //insert into categories table
        for (String category: menu.getCategories()){
            categoryRepository.save(new CategoryDAO(menu.getId(), category));
        }

        //insert into options table
        for(String optionCategory: menu.getOptions().keySet()){
            for(String option: menu.getOptions().get(optionCategory).keySet()){
                int price = menu.getOptions().get(optionCategory).get(option);
                optionRepository.save(new OptionDAO(menu.getId(), optionCategory, option, price));
            }
        }
    }

    public void addMenuOption(){

    }
}


