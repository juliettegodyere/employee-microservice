package net.queencoder.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    description = "Employee API Response Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {

    @Schema(
        description = "Employee information"
    )
    private EmployeeDto employee;

    @Schema(
        description = "Department information"
    )
    private DepartmentDto department;

    @Schema(
        description = "Organization information"
    )
    private OrganizationDto organzation;
}
