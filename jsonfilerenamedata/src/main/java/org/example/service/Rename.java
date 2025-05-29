package org.example.service;

import org.example.jsontopojo.*;
public class Rename {
//jsonobject
    public static void renameAllNames(PArent parent) {
        if (parent.getDepartments() != null) {
            for (Department dept : parent.getDepartments()) {
                dept.setName("revathi");

                if (dept.getTeams() != null) {
                    for (Team team : dept.getTeams()) {
                        team.setName("revathi");

                        if (team.getMembers() != null) {
                            for (MembersItem member : team.getMembers()) {
                                member.setName("revathi");
                            }
                        }


                    }
                }
            }
        }

        if (parent.getProjects() != null) {
            for (Project project : parent.getProjects()) {
                project.setName("evaho");
            }
        }
    }
}
