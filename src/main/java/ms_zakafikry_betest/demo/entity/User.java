package ms_zakafikry_betest.demo.entity;

import lombok.Data;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User implements Serializable{
    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    @Indexed(unique = true)
    private String accountNumber;

    @Indexed(unique = true)
    private String emailAddress;

    @Indexed(unique = true)
    private String identityNumber;
}
