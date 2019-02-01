/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.data.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private @Id
    @GeneratedValue
    Long id;

    private String role;

    @ManyToOne
    @NotNull(message = "Member.employee.required")
    private Employee employee;

    @Singular
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    private List<UsedSkill> skills;
}
