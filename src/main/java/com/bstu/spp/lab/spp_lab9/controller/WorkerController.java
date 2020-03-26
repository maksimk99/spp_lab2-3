package com.bstu.spp.lab.spp_lab9.controller;

import com.bstu.spp.lab.spp_lab9.model.security.CustomUserDetails;
import com.bstu.spp.lab.spp_lab9.service.WorkerService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WorkerController {

    private WorkerService workerService;

    public WorkerController(final WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/worker")
    public String getWorkerPage(final Authentication authentication, final Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        model.addAttribute("worker", workerService.findById(userDetails.getUserId()));
        return "worker";
    }

    @GetMapping("/worker/job/{jobId}/get")
    public String getJob(@PathVariable final Integer jobId, final Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        workerService.addJob(userDetails.getUserId(), jobId);
        return "redirect:/jobs";
    }

    @GetMapping("/worker/job/quit")
    public String quitCurrentJob(final Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        workerService.deleteJob(userDetails.getUserId());
        return "redirect:/jobs";
    }
}
