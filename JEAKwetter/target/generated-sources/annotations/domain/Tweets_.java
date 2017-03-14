package domain;

import domain.Profile;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-13T14:46:43")
@StaticMetamodel(Tweets.class)
public class Tweets_ { 

    public static volatile SingularAttribute<Tweets, String> subject;
    public static volatile SingularAttribute<Tweets, Profile> profile;
    public static volatile ListAttribute<Tweets, Profile> hearts;
    public static volatile SingularAttribute<Tweets, String> tekst;
    public static volatile SingularAttribute<Tweets, Long> id;
    public static volatile SingularAttribute<Tweets, Integer> complain;

}