package tickets;

import java.util.Date;

public class Passenger {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public Boolean gender;

    public Passenger(String firstName, String lastName, Date dateOfBirth, Boolean gender){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getFirstname(){return firstName;}
    public String getLastName(){return lastName;}
    public Date getDoB(){return dateOfBirth;}
    public Boolean getGender(){return gender;}



}
