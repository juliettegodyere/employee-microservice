package net.queencoder.employeeservice.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    description = "Employee Model Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
 
    private Long id;

    @Schema(
        description = "Organisation Name"
    )
    private String organizationName;

    @Schema(
        description = "Organisation Description"
    )
    private String organizationDescription;

    @Schema(
        description = "Organisation Code"
    )
    private String organizationCode;

    private LocalDateTime createdDate;
}
