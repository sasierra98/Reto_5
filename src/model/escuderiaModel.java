package model;

public class escuderiaModel {
    private int escuderiaId, raceWin;
    private String name, sponsor, date;

    public escuderiaModel(){}

    public escuderiaModel(String name){
        this.name = name;
    }

    public escuderiaModel(int escuderiaId, String name, String sponsor, int raceWin, String date){
        this.escuderiaId = escuderiaId;
        this.name = name;
        this.sponsor = sponsor;
        this.raceWin = raceWin;
        this.date = date;
    }

    public void setEscuderiaId(int escuderiaId) {
        this.escuderiaId = escuderiaId;
    }

    public int getEscuderiaId() {
        return escuderiaId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setRaceWin(int raceWin) {
        this.raceWin = raceWin;
    }

    public int getRaceWin() {
        return raceWin;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public Object[] toArray(){
        Object[] data = {escuderiaId, name, sponsor, raceWin, date};
        return data;
    }
}
