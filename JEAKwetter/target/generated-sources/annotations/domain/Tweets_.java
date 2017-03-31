package domain;

import domain.Profile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-31T11:39:31")
@StaticMetamodel(Tweets.class)
public class Tweets_ { 

    public static volatile SingularAttribute<Tweets, String> subject;
    public static volatile SingularAttribute<Tweets, Profile> profile;
    public static volatile SingularAttribute<Tweets, String> tekst;
    public static volatile SingularAttribute<Tweets, Date> timeCreated;
    public static volatile SingularAttribute<Tweets, Long> id;
    public static volatile SingularAttribute<Tweets, Integer> complain;

}