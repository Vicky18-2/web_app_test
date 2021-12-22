
package com.ITtexn.pz4.service.genre;


//@XmlType(name = "genre", namespace = "http://nure/it-texn/pz")
//@XmlEnum
public enum Genre {

//    @XmlEnumValue("Mystery")
    MYSTERY("Mystery"),
//    @XmlEnumValue("Comedy")
    COMEDY("Comedy"),
//    @XmlEnumValue("Fantasy")
    FANTASY("Fantasy"),
//    @XmlEnumValue("Fiction")
    FICTION("Fiction"),
//    @XmlEnumValue("Drama")
    DRAMA("Drama"),
//    @XmlEnumValue("Horror")
    HORROR("Horror");
    private final String value;

    Genre(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Genre fromValue(String v) {
        for (Genre c: Genre.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
