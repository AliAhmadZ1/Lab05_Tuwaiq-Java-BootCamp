package com.example.lab05_q2.Controller;

import com.example.lab05_q2.ApiResponse.ApiResponse;
import com.example.lab05_q2.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project-tracker")
public class ProjectTrackerController {

    ArrayList<Project> projects = new ArrayList<>();

    //• Display all project.
    @GetMapping("/display")
    public ArrayList<Project> display(){
        return projects;
    }

//• Create a new project (ID,title , description , status, companyName)
    @PostMapping("/create")
    public ApiResponse createNewProject(@RequestBody Project project){
        projects.add(project);
        return new ApiResponse("created!!!!");
    }

    //• Update a project
    @PutMapping("/update/{id}")
    public ApiResponse updateProject(@PathVariable int id,@RequestBody Project project){
        for (int index=0;index<projects.size();index++){
            if (projects.get(index).getId()==id) {
                projects.set(index, project);
                return new ApiResponse("updated");
            }
        }
        return new ApiResponse("not found...");
    }

    //• Delete a project
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteProject(@PathVariable int id){
        for (int index=0;index<projects.size();index++){
            if (projects.get(index).getId()==id) {
                projects.remove(index);
                return new ApiResponse("deleted!");
            }
        }
        return new ApiResponse("not found...");
    }

    //• Change the project status as done or not done
    @PutMapping("/change-status/{id},{status}")
    public ApiResponse changeStatus(@PathVariable int id,@PathVariable String status){
        for (int index = 0; index < projects.size(); index++) {
            if (projects.get(index).getId()==id){
                if (status.equals("done")) {
                    projects.get(index).setStatus("done");
                    return new ApiResponse("Done!");
                }
                else if (status.equals("not done")) {
                    projects.get(index).setStatus("not done");
                    return new ApiResponse("Not Done!!");
                }
                else
                    return new ApiResponse("there are no status like that"+"'"+status+"'");
            }
        }
        return new ApiResponse("Not found!!");
    }

    //• Search for a project by given title
    @GetMapping("/search/{title}")
    public Project searchProject(@PathVariable String title){
        for (Project p: projects){
            if (p.getTitle().equals(title))
                return p;
        }
        return null;
    }

    //• Display All project for one company by companyName.
    @GetMapping("/display-company/{companyName}")
    public ArrayList<Project> displayAllByCompanyName(@PathVariable String companyName){
        ArrayList<Project> company = new ArrayList<>();
        for (Project p : projects) {
            if (p.getCompanyName().equals(companyName))
                company.add(p);
        }
        return company;
    }
}
