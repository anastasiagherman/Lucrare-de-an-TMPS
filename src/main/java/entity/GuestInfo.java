package entity;


public class GuestInfo {
    private String guestId;
    private String guest_name;
    private String phone_nr;
    private String checkinDate;
    private int nrDays;
    private String checkoutDate;
    private int roomNr;

    public GuestInfo(){}


    public GuestInfo(String guestId,String name, String phone_nr, String checkinDate, int nrDays, String checkoutDate){
        this.guestId = guestId;
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

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestId() {
        return guestId;
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
