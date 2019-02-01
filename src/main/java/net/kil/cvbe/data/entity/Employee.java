/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.kil.cvbe.data.AcademicDegreeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private @Id
    @GeneratedValue
    Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String imgUrl;

    // education
    private AcademicDegreeType academicDegree;
    private String academicProfile;
    // languages
    // certificates

    public Employee(String firstName, String lastName, String role, AcademicDegreeType academicDegree, String academicProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.academicDegree = academicDegree;
        this.academicProfile = academicProfile;
    }
}
