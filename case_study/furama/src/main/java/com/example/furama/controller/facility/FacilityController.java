package com.example.furama.controller.facility;

import com.example.furama.dto.customer.FacilityDto;
import com.example.furama.model.facility.Facility;
import com.example.furama.service.facility.IFacilityService;
import com.example.furama.service.facility.IFacilityTypeService;
import com.example.furama.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FacilityController {
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/facility")
    public String getAllFacility(@RequestParam(defaultValue = "") String nameSearch
            , @RequestParam(defaultValue = "0") int facilityTypeSearch,
                                 Model model, FacilityDto facilityDto,
                                 @PageableDefault(size = 5, page = 0) Pageable pageable) {
        if (facilityTypeSearch ==0){
            model.addAttribute("facilityList",facilityService.getAllByName(nameSearch,pageable));
        }else {
            model.addAttribute("facilityList", facilityService.getAllFacility(nameSearch, facilityTypeSearch, pageable));
        }
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("renType", rentTypeService.findAll());
        model.addAttribute("facilityType", facilityTypeService.findAll());
        return "facility/list";
    }

    @GetMapping("/facility/create")
    public String createFacility(Model model, FacilityDto facilityDto){
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("renTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/facility/save")
    public String saveFacility(@Validated FacilityDto facilityDto, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes , Model model){
//        if (bindingResult.hasErrors()){
//            model.addAttribute("facilityDto", facilityDto);
//            return "facility/create";
//        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto,facility);
        facilityService.saveFacility(facility);
        redirectAttributes.addFlashAttribute("mess","Thêm mới dịch vụ thành công");
        return "redirect:/facility";
    }

    @GetMapping("/deleteFacility")
    public String deleteFacility(@RequestParam int id, RedirectAttributes redirectAttributes){
        Facility facility = facilityService.findById(id);
        if (facility== null){
            redirectAttributes.addFlashAttribute("mess","Dịch vụ không tồn tại");
        }
        facilityService.deleteFacility(id);
        return "redirect:/facility";
    }
    @GetMapping("/facility/{id}/edit")
    public String editFacility(@PathVariable int id, Model model){
     Facility facility = facilityService.findById(id);
     model.addAttribute("facility",facility);
        model.addAttribute("renTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
     return"facility/edit";

    }
}
