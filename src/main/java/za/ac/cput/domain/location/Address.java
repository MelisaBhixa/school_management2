/*
Address.java
Entity for Address
Author: Melisa Bhixa
Date: 14 June 2022
 */

package za.ac.cput.domain.location;

public class Address {
    private String unitNumber;
    private String complexName;
    private String streetNumber;
    private String streetName;
    private int postalCode;
    private City city;

    public Address(Address.AddressBuilder Builder) {
        this.unitNumber = Builder.unitNumber;
        this.complexName = Builder.complexName;
        this.streetNumber = Builder.streetNumber;
        this.streetName = Builder.streetName;
        this.postalCode = Builder.postalCode;
        this.city = Builder.city;
    }

    public Address() {
    }

    public static String unitNumber() { return unitNumber(); }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City getCity() {
        return city;
    }

    public String complexName() { return complexName; }
    public String streetNumber() { return streetNumber; }
    public String streetName() { return streetName; }
    public int postalCode() { return postalCode; }
    public City city() { return city; }

    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' + ",complexName='" + complexName + '\'' +
                ",streetNumber='" + streetNumber + '\'' + ",streetName='" + streetName + '\'' +
                ",postalCode='" + postalCode + '\'' + ",city=" + city + '}';
    }


    public static class AddressBuilder {
        private String unitNumber, complexName, streetNumber, streetName;
        private int postalCode;
        public City city;

        public Address.AddressBuilder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Address.AddressBuilder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Address.AddressBuilder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }
        public Address.AddressBuilder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Address.AddressBuilder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address.AddressBuilder setCity(City city) {
            this.city = city;
            return this;
        }

        public AddressBuilder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.streetName = address.streetName;
            this.complexName = address.complexName;
            this.postalCode = address.postalCode;
            this.streetNumber = address.streetNumber;
            this.city = address.city;
            return this;
        }

        public Address build() {
            Address address = new Address(this);
            return address; }
    }


}
