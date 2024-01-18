package minhanthonytat.PostcodeAPI.Postcode;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostcodeRepository extends JpaRepository<Postcode,Long>{
  List<Postcode> findByPostcode(String postcode);
  List<Postcode> findBySuburb(String suburb);
}
