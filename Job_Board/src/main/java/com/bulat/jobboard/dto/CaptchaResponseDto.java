package com.bulat.jobboard.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * The class responsible for captcha in registration and authorization
 * @author Bulat Bilalov
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptchaResponseDto {

    /** The field responsible for the successful or unsuccessful passing of the captcha */
    private boolean success;

    /** The field that is responsible for the collection of errors when passing the captcha */
    @JsonAlias("error-codes")
    private Set<String> errorCodes;
}
