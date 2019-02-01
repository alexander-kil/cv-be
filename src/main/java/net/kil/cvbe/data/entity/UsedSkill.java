/*
 * Copyright (c) 2019. Killiko
 * @author Alexander.Kill@gmail.com
 */
package net.kil.cvbe.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsedSkill {

    private @Id
    @GeneratedValue
    Long id;

    @NotNull(message = "UsedSkill.name.required")
    @Builder.Default
    private String name = "unnamed skill";

    //Skill proportion in usage
    @NotNull(message = "UsedSkill.rate.required")
    @Builder.Default
    private Integer rate = 100;
}
