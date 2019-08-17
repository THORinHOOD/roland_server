package ru.roland.server.models.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {
    @NotNull
    private Long id;
    @NotNull
    private String login;
    private String email;
}
