package minhanthonytat.PostcodeAPI.Postcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

public class PostcodeCreateDTO {
  @Getter
  @Setter
  @NotBlank
  @Pattern(regexp = "^\\d{4}$", message = "Postcode must be a 4-digit number")
  private String postcode;

  @Getter
  @Setter
  @NotBlank
  private String suburb;
}
