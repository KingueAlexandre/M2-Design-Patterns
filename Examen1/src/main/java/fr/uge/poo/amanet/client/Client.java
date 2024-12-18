package fr.uge.poo.amanet.client;

import com.evilcorp.connect.Connect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class Client {
    private final String nom;
    private final String prenom;
    private final int age;
    private final Country country;
    private final Map<TypeNotif,String> mapInfo;
    private Consumer<String> messagingStrategy = msg -> {};


    public static class Step{
        public static NomStep newbuilder(){
            return new Builder();
        }
        public interface NomStep{
            public PrenomStep nom(String nom);
        }
        public interface PrenomStep{
            public AgeStep prenom(String prenom);
        }
        public interface AgeStep{
            public CountryStep age(Integer age);
        }
        public interface CountryStep{
            public InfoStep county(Country county);
        }
        public interface InfoStep{
            public FinalStep infoSMS(String info);
            public FinalStep infoEMAIL(String info);
            public FinalStep infoTWITTER(String info);
        }
        public interface FinalStep{
            public FinalStep infoSMS(String info);
            public FinalStep infoEMAIL(String info);
            public FinalStep infoTWITTER(String info);
            public Client build();
        }
        public static class Builder implements NomStep,PrenomStep,AgeStep,CountryStep,InfoStep,FinalStep{
            private String nom;
            private String prenom;
            private Integer age;
            private Country country;
            private final Map<TypeNotif,String> mapInfo = new HashMap<>();

            @Override
            public Client build() {
                return new Client(nom,prenom,age,country,mapInfo);
            }

            @Override
            public PrenomStep nom(String nom) {
                Objects.requireNonNull(nom);
                this.nom = nom;
                return this;
            }

            @Override
            public CountryStep age(Integer age) {
                Objects.requireNonNull(age);
                this.age = age;
                return this;
            }

            @Override
            public AgeStep prenom(String prenom) {
                Objects.requireNonNull(prenom);
                this.prenom = prenom;
                return this;
            }

            @Override
            public InfoStep county(Country county) {
                Objects.requireNonNull(county);
                this.country = county;
                return this;
            }

            @Override
            public FinalStep infoSMS(String info) {
                Objects.requireNonNull(info);
                mapInfo.put(TypeNotif.SMS, info);
                return this;
            }

            @Override
            public FinalStep infoEMAIL(String info) {
                Objects.requireNonNull(info);
                mapInfo.put(TypeNotif.EMAIL, info);
                return this;
            }

            @Override
            public FinalStep infoTWITTER(String info) {
                Objects.requireNonNull(info);
                mapInfo.put(TypeNotif.TWITTER, info);
                return this;
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public Country getCountry() {
        return country;
    }


    private Client(String nom, String prenom, int age, Country country, Map<TypeNotif,String> map) {
        if(map.isEmpty()){
            throw new IllegalArgumentException("map is empty");
        }
        this.country = country;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.mapInfo = map;
    }

//    private void setMessagingStrategy(Consumer<String> messagingStrategy) {
//        this.messagingStrategy = Objects.requireNonNull(messagingStrategy);
//    }

    public void emailNotif(){
        changeStrategy(TypeNotif.EMAIL,msg -> Connect.sendMail(mapInfo.get(TypeNotif.EMAIL), "Notification from AmaNet", msg));
    }

    public void smsNotif(){
        changeStrategy(TypeNotif.SMS, msg -> Connect.sendSMS(mapInfo.get(TypeNotif.SMS), msg));
    }

    public void twitterNotif(){
        changeStrategy(TypeNotif.TWITTER, msg -> Connect.sendTweet(mapInfo.get(TypeNotif.TWITTER), msg));
    }

    private void changeStrategy(TypeNotif typeNotif, Consumer<String> messagingStrategy){
        if(mapInfo.containsKey(typeNotif)){
            this.messagingStrategy = Objects.requireNonNull(messagingStrategy);
        }else {
            this.messagingStrategy = msg -> {};
        }
    }


    public void message(String msg) {
        messagingStrategy.accept(msg);
    }

}
