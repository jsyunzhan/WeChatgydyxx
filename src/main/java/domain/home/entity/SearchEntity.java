package domain.home.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchEntity extends AbstractEntity{

    private Long tableId;

    private String url;

    private String title;


}
