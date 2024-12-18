package fr.uge.poo.amanet.items;

import fr.uge.poo.amanet.client.Client;
import fr.uge.poo.amanet.client.Country;

import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface Item {

    String getShortDescription();
    String getLongDescription();
    int getPrice();
    boolean isAllowedForClient(Client client);
    TYPE_ITEM type();
    int getYear();

    public abstract class AbstractIem implements Item {
        private final String title;
        private final int year;
        private final Predicate<Client> isAllowedForClient;
        public AbstractIem(String title, Integer year, Predicate<Client> isAllowedForClient) {
            Objects.requireNonNull(title);
            Objects.requireNonNull(year);
            Objects.requireNonNull(isAllowedForClient);
            this.title = title;
            this.year = year;
            this.isAllowedForClient = isAllowedForClient;
        }

        @Override
        public int getYear() {
            return year;
        }

        @Override
        public String getShortDescription() {
            return title + " (" + year + ")";
        }

        @Override
        public boolean isAllowedForClient(Client client) {
            return isAllowedForClient.test(client);
        }
    }

    public class DVD extends AbstractIem {
        private final int zone;
        private final Set<Country> languages;
        private final int price;
        public DVD(String title, Integer year, Set<Country> languages, int zone, Predicate<Client> isAllowedForClient){
            super(title, year, isAllowedForClient);
            Objects.requireNonNull(languages);
            if(zone < 1 || 5 < zone){
                throw new IllegalArgumentException("Zone must be between 1 and 5");
            }
            this.languages = languages;
            this.zone = zone;
            if(year < 2000){
                price = 2;
            }else {
                price = 10;
            }
        }

        @Override
        public String getLongDescription() {
            return "DVD : " + this.getShortDescription() + "\n"
                    + "AUDIO : " + languages.stream().map(Country::toString).collect(Collectors.joining(", ","","\n"))
                    + "ZONE : " + zone;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public TYPE_ITEM type() {
            return TYPE_ITEM.DVD;
        }
    }

    public class BluRay extends AbstractIem {
        private final Set<Country> languages;
        private final boolean is3D;
        private final int price;

        public BluRay(String title, Integer year, Set<Country> languages, boolean is3D, Predicate<Client> isAllowedForClient) {
            super(title, year, isAllowedForClient);
            Objects.requireNonNull(languages);
            this.is3D = is3D;
            this.languages = languages;
            if(is3D){
                price = 30;
            }else{
                price = 20;
            }
        }

        @Override
        public String getLongDescription() {
            return "DVD : " + this.getShortDescription() + "\n"
                    + "AUDIO : " + languages.stream().map(Country::toString).collect(Collectors.joining(", ","","\n"))
                    + "3D : " + is3D;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public TYPE_ITEM type() {
            return TYPE_ITEM.BLURAY;
        }
    }

    public class VideoGames extends AbstractIem {
        private final PLATEFORM plateforme;
        private final int price;

        public VideoGames(String title, Integer year, PLATEFORM plateforme, Predicate<Client> isAllowedForClient) {
            super(title, year, isAllowedForClient);
            Objects.requireNonNull(plateforme);
            this.plateforme = plateforme;
            if(this.plateforme == PLATEFORM.PC){
                price = 60;
            }else {
                price = 50;
            }
        }

        @Override
        public String getLongDescription() {
            return "DVD : " + this.getShortDescription() + "\n"
                    + "PLATEFORM : " + plateforme;
        }

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public TYPE_ITEM type() {
            return TYPE_ITEM.DVD;
        }
    }

    public enum PLATEFORM {
        PC,
        SWITCH,
        PS5
    }

    public enum TYPE_ITEM{
        DVD,
        BLURAY,
        VIDEOGAMES
    }

}
