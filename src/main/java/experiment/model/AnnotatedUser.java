package experiment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnotatedUser {

    @Id
    private String userName;
    private String email;
}
