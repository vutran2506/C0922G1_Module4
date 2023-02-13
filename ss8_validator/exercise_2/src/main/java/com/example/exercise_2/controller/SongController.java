package com.example.exercise_2.controller;

import com.example.exercise_2.dto.SongDto;
import com.example.exercise_2.model.Song;
import com.example.exercise_2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("/")
//    public String showList(@RequestParam(required = false,defaultValue = "") String nameSearch,
//                           @PageableDefault(size = 3,page = 0, sort = "nameSong",direction = Sort.Direction.ASC) Pageable pageable
//            , Model model) {
//        model.addAttribute("songList", songService.findByName(nameSearch,pageable));
//        return "list";
    public String showList(@RequestParam(required = false, defaultValue = "") String nameSearch,
                           @RequestParam(required = false, defaultValue = "") String singerSearch,
                           @RequestParam(required = false, defaultValue = "") String categorySearch,
                           @PageableDefault(size = 2, page = 0, sort = "nameSong", direction = Sort.Direction.DESC)
                           Pageable pageable, Model model) {
        model.addAttribute("songList", songService.findByNameAndSingerAndCategory(nameSearch, singerSearch, categorySearch, pageable));
        return "list";
    }

    @GetMapping("/song/create")
    public String create(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/song/save")
    public String save(@Validated SongDto songDto, BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Successfully created");
        return "redirect:/";
    }

    @GetMapping("/song/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("songDto", songService.findById(id));
        return "edit";
    }

    @PostMapping("/song/edit")
    public String edit(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, @RequestParam int id,
                       Model model, RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("songDto", songDto);
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("mess", "Successfully updated");
        return "redirect:/";
    }
}
