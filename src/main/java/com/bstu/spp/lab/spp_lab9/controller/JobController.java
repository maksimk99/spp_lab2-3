package com.bstu.spp.lab.spp_lab9.controller;

import com.bstu.spp.lab.spp_lab9.model.Job;
import com.bstu.spp.lab.spp_lab9.model.security.CustomUserDetails;
import com.bstu.spp.lab.spp_lab9.service.CityService;
import com.bstu.spp.lab.spp_lab9.service.CustomerService;
import com.bstu.spp.lab.spp_lab9.service.JobService;
import com.bstu.spp.lab.spp_lab9.service.UserService;
import com.bstu.spp.lab.spp_lab9.service.WorkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class JobController {

    private JobService jobService;
    private CustomerService customerService;
    private CityService cityService;
    private WorkTypeService workTypeService;
    private UserService userService;

    @Autowired
    public JobController(final JobService jobService, final CustomerService customerService,
                         final CityService cityService, final WorkTypeService workTypeService,
                         final UserService userService) {
        this.jobService = jobService;
        this.customerService = customerService;
        this.cityService = cityService;
        this.workTypeService = workTypeService;
        this.userService = userService;
    }

    @GetMapping(value = "/jobs")
    public String gotoJobListPage(final Model model, final Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        model.addAttribute("currentJob", userService.getUserByUserName(userDetails.getUsername()).getJob());
        model.addAttribute("jobList", jobService.findAll());
        return "jobs";
    }

    @GetMapping(value = "/job/{jobId}")
    public String gotoEditJobPage(@PathVariable final Integer jobId, final Model model) {
        model.addAttribute("job", jobService.findById(jobId));
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("workTypeList", workTypeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        return "job";
    }

    @GetMapping(value = "/job")
    public String gotoAddCoursePage(final Model model) {
        model.addAttribute("isNew", true);
        model.addAttribute("job", new Job());
        model.addAttribute("cityList", cityService.findAll());
        model.addAttribute("workTypeList", workTypeService.findAll());
        model.addAttribute("customerList", customerService.findAll());
        return "job";
    }

    @PostMapping(value = "/job")
    public String addCourse(@Valid final Job job, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            model.addAttribute("isNew", true);
            model.addAttribute("cityList", cityService.findAll());
            model.addAttribute("workTypeList", workTypeService.findAll());
            model.addAttribute("customerList", customerService.findAll());
            return "job";
        } else {
            this.jobService.add(job);
            return "redirect:/jobs";
        }
    }

    @PostMapping(value = "/job/{jobId}")
    public String updateCourse(@PathVariable final Integer jobId, @Valid final Job job, final BindingResult result,
                               final Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cityList", cityService.findAll());
            model.addAttribute("workTypeList", workTypeService.findAll());
            model.addAttribute("customerList", customerService.findAll());
            return "job";
        } else {
            job.setJobId(jobId);
            this.jobService.update(job);
            return "redirect:/jobs";
        }
    }

    @GetMapping(value = "/job/{jobId}/delete")
    public String deleteJob(@PathVariable final Integer jobId) {
        jobService.delete(jobId);
        return "redirect:/jobs";
    }
}
