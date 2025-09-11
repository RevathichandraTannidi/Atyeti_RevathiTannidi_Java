package com.carRental.service;

import com.carRental.entity.Branch;
import com.carRental.exceptionhandling.BadRequestException;
import com.carRental.exceptionhandling.ResourceNotFoundException;
import com.carRental.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public Branch createBranch(Branch branch) {
        if (branch == null) {
            throw new BadRequestException("Branch cannot be null");
        }
        if (branch.getName() == null || branch.getName().isEmpty()) {
            throw new BadRequestException("Branch name cannot be empty");
        }
        if (branch.getAddress() == null || branch.getAddress().isEmpty()) {
            throw new BadRequestException("Branch address cannot be empty");
        }
        return branchRepository.save(branch);
    }

    public Branch getBranchById(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with id: " + id));
    }

    public Branch getBranchByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new BadRequestException("Branch name cannot be empty");
        }
        return branchRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Branch not found with name: " + name));
    }

    public List<Branch> searchBranchesByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new BadRequestException("Search name cannot be empty");
        }
        List<Branch> branches = branchRepository.searchByName(name);
        if (branches.isEmpty()) {
            throw new ResourceNotFoundException("No branches found matching name: " + name);
        }
        return branches;
    }

    public List<Branch> searchBranchesByAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new BadRequestException("Search address cannot be empty");
        }
        List<Branch> branches = branchRepository.findByAddressContainingIgnoreCase(address);
        if (branches.isEmpty()) {
            throw new ResourceNotFoundException("No branches found containing address: " + address);
        }
        return branches;
    }

    public List<Branch> getAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        if (branches.isEmpty()) {
            throw new ResourceNotFoundException("No branches found in the system");
        }
        return branches;
    }


    public Branch updateBranch(Long id, Branch updatedBranch) {
        Branch branch = getBranchById(id);
        branch.setName(updatedBranch.getName());
        branch.setAddress(updatedBranch.getAddress());
        branch.setContact(updatedBranch.getContact());
        return branchRepository.save(branch);
    }

}
