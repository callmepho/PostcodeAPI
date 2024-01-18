package minhanthonytat.PostcodeAPI.Postcode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Postcodes")
public class Postcode {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Setter
  @NotBlank
  @Pattern(regexp = "^\\d{4}$", message = "Postcode must be a 4-digit number")
  private String postcode;

  @Getter
  @Setter
  @NotBlank
  private String suburb;

  public Postcode() {}

  public Postcode(String postcode,String suburb){
    this.postcode = postcode;
    this.suburb = suburb;
  }
}