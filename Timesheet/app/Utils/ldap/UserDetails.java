package Utils.ldap;

public class UserDetails {

    private String uid;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String city;
    private String coreBusiness;
    private String presenceUnit;

    public UserDetails(){}

    public UserDetails(String uid, String firstname, String lastname, String email) {
        this.uid = uid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public UserDetails(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "UserDetails(uid=" + uid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", country=" + country +", city=" + city +", core business=" + coreBusiness+ ", presence unit=" + presenceUnit +")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.uid.equals(((UserDetails) obj).getUid());
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoreBusiness() {
        return coreBusiness;
    }

    public void setCoreBusiness(String coreBusiness) {
        this.coreBusiness = coreBusiness;
    }

    public String getPresenceUnit() {
        return presenceUnit;
    }

    public void setPresenceUnit(String presenceUnit) {
        this.presenceUnit = presenceUnit;
    }

}
