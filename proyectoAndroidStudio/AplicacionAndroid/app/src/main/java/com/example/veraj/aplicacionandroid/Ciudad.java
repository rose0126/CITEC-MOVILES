package com.example.veraj.aplicacionandroid;

/**
 * Created by Alice on 07/02/2016.
 */
public class Ciudad {
    String Key;
    String EnglishName;
    region Region;
    public class region{
        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String englishName) {
            EnglishName = englishName;
        }

        String EnglishName;
    }
    country Country;
    public class country{
        String ID;

        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String englishName) {
            EnglishName = englishName;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        String EnglishName;
    }
    aa AdministrativeArea;
    public class aa{
        public String getEnglishName() {
            return EnglishName;
        }

        public void setEnglishName(String englishName) {
            EnglishName = englishName;
        }

        String EnglishName;
    }
    gp GeoPosition;
    public class gp{
        public Double getLatitude() {
            return Latitude;
        }

        public void setLatitude(Double latitude) {
            Latitude = latitude;
        }

        Double Latitude;
        Double Longitude;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public void setEnglishName(String englishName) {
        EnglishName = englishName;
    }

    public region getRegion() {
        return Region;
    }

    public void setRegion(region region) {
        Region = region;
    }

    public country getCountry() {
        return Country;
    }

    public void setCountry(country country) {
        Country = country;
    }

    public aa getAdministrativeArea() {
        return AdministrativeArea;
    }

    public void setAdministrativeArea(aa administrativeArea) {
        AdministrativeArea = administrativeArea;
    }

    public gp getGeoPosition() {
        return GeoPosition;
    }

    public void setGeoPosition(gp geoPosition) {
        GeoPosition = geoPosition;
    }
}
