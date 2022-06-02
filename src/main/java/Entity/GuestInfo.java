package Entity;


public class GuestInfo {
    private int guest_id;
    private String guest_name;
    private String phone_nr;
    private String checkinDate;
    private int nrDays;
    private String checkoutDate;
    private int roomNr;

    public GuestInfo(){}


    public GuestInfo(int guest_id,String name, String phone_nr, String checkinDate, int nrDays, String checkoutDate){
        this.guest_id = guest_id;
        this.guest_name = name;
        this.phone_nr = phone_nr;
        this.checkinDate = checkinDate;
        this.nrDays = nrDays;
        this.checkoutDate = checkoutDate;


    }

    public int getRoomNr() {
        return roomNr;
    }

    public void setRoomNr(int roomNr) {
        this.roomNr = roomNr;
    }

    public void setName(String name){
        this.guest_name = name;
    }

    public String getName(){
        return guest_name;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public String getPhone_nr() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr = phone_nr;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public void setNrDays(int nrDays) {
        this.nrDays = nrDays;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public int getNrDays() {
        return nrDays;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }
}
