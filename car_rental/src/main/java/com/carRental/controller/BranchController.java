package com.carRental.controller;

import com.carRental.dtos.BranchRequestDTO;
import com.carRental.dtos.BranchResponseDTO;
import com.carRental.entity.Branch;
import com.carRental.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public BranchResponseDTO createBranch(@RequestBody BranchRequestDTO dto) {
        Branch branch = new Branch();
        branch.setName(dto.getName());
        branch.setAddress(dto.getAddress());
        branch.setContact(dto.getContact());
        return toDTO(branchService.createBranch(branch));
    }

    @GetMapping("/{id}")
    public BranchResponseDTO getBranchById(@PathVariable Long id) {
        return toDTO(branchService.getBranchById(id));
    }

    @GetMapping("/name/{name}")
    public BranchResponseDTO getBranchByName(@PathVariable String name) {
        return toDTO(branchService.getBranchByName(name));
    }

    @GetMapping("/search/name")
    public List<BranchResponseDTO> searchByName(@RequestParam String name) {
        return branchService.searchBranchesByName(name)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/search/address")
    public List<BranchResponseDTO> searchByAddress(@RequestParam String address) {
        return branchService.searchBranchesByAddress(address)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping
    public List<BranchResponseDTO> getAllBranches() {
        return branchService.getAllBranches()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }
    @PutMapping("/{id}")
    public BranchResponseDTO updateBranch(@PathVariable Long id, @RequestBody BranchRequestDTO dto) {
        Branch updatedBranch = new Branch();
        updatedBranch.setName(dto.getName());
        updatedBranch.setAddress(dto.getAddress());
        updatedBranch.setContact(dto.getContact());
        return toDTO(branchService.updateBranch(id, updatedBranch));
    }



    private BranchResponseDTO toDTO(Branch branch) {
        BranchResponseDTO dto = new BranchResponseDTO();
        dto.setId(branch.getId());
        dto.setName(branch.getName());
        dto.setAddress(branch.getAddress());
        dto.setContact(branch.getContact());
        return dto;
    }
}
