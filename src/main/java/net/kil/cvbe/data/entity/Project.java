/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.data.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private @Id
    @GeneratedValue
    Long id;

    @NotNull(message = "project.name.required")
    private String name;
    private String description;
    @NotNull(message = "project.months.required")
    private Integer months;
    @NotNull(message = "project.startedAt.required")
    private LocalDate startedAt;

    @ManyToOne
    @NotNull(message = "project.customer.required")
    private Customer customer;

    @Singular
    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private List<Member> members;
}
