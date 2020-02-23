package items;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * Created by Tamir on 22/02/2020.
 */
public class Response {
    public static ResponseEntity<Object> Ok(Collection list){
        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }

    public static ResponseEntity<Object> Ok(Object obj){
        return new ResponseEntity<Object>(obj, HttpStatus.OK);
    }


    public static ResponseEntity<Object> NotFound(){
        return new ResponseEntity<Object>("Resource not found", HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<Object>BadRequest(){
        return new ResponseEntity<Object>("Invalid input",HttpStatus.BAD_REQUEST);
    }
}
