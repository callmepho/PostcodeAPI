package minhanthonytat.PostcodeAPI.Postcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/postcode")
public class PostcodeController {
  @Autowired
  private PostcodeService postcodeService;

  @GetMapping
  public ResponseEntity<List<Postcode>> getAll() {
		List<Postcode> allPosts = this.postcodeService.getAll();
		return new ResponseEntity<>(allPosts, HttpStatus.OK);
	}

  @PostMapping
  public ResponseEntity<Postcode> createPostcode(@Valid @RequestBody PostcodeCreateDTO data){
    Postcode newPostcode = this.postcodeService.createPostcode(data);
    return new ResponseEntity<Postcode>(newPostcode, HttpStatus.CREATED);	
  }
  
  @GetMapping("/{postcode}")
  public ResponseEntity<List<Postcode>> getByPostcode(@PathVariable String postcode){
    List<Postcode> found = this.postcodeService.getSuburbByPostcode(postcode);
    return new ResponseEntity<List<Postcode>>(found, HttpStatus.OK);
  }

  @GetMapping("/suburb/{suburb}")
  public ResponseEntity<List<Postcode>> getBySuburb(@PathVariable String suburb){
    List<Postcode> found = this.postcodeService.getPostcodeBySuburb(suburb);
    return new ResponseEntity<List<Postcode>>(found, HttpStatus.OK);
  }
}
