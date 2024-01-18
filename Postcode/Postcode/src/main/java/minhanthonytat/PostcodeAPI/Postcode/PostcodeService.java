package minhanthonytat.PostcodeAPI.Postcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostcodeService {
  @Autowired
    private PostcodeRepository postCodeRepository;

    public List<Postcode> getAll(){
      return postCodeRepository.findAll();
    }

    public List<Postcode> getSuburbByPostcode(String postcode) {
      return postCodeRepository.findByPostcode(postcode);
    }

    public List<Postcode> getPostcodeBySuburb(String suburb) {
      return postCodeRepository.findBySuburb(suburb);
    }

    public Postcode createPostcode(PostcodeCreateDTO data) {
      Postcode newPostcode = new Postcode(data.getPostcode(),data.getSuburb());
      Postcode created = postCodeRepository.save(newPostcode);
      return created;
    }
}
