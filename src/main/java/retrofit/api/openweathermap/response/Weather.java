package retrofit.api.openweathermap.response;

import java.util.ArrayList;

public class Weather {
    private CoordObject coordObject;
    private ArrayList<Object> weather = new ArrayList<>();
    private String base;
    private MainObject mainObject;
    private float visibility;
    private WindObject windObject;
    private CloudsObject cloudsObject;
    private float dt;
    private SysObject sysObject;
    private float timezone;
    private float id;
    private String name;
    private float cod;

    public CoordObject getCoordObject() {
        return coordObject;
    }

    public void setCoordObject(CoordObject coordObject) {
        this.coordObject = coordObject;
    }

    public ArrayList<Object> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Object> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public MainObject getMainObject() {
        return mainObject;
    }

    public void setMainObject(MainObject mainObject) {
        this.mainObject = mainObject;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public WindObject getWindObject() {
        return windObject;
    }

    public void setWindObject(WindObject windObject) {
        this.windObject = windObject;
    }

    public CloudsObject getCloudsObject() {
        return cloudsObject;
    }

    public void setCloudsObject(CloudsObject cloudsObject) {
        this.cloudsObject = cloudsObject;
    }

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public SysObject getSysObject() {
        return sysObject;
    }

    public void setSysObject(SysObject sysObject) {
        this.sysObject = sysObject;
    }

    public float getTimezone() {
        return timezone;
    }

    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCod() {
        return cod;
    }

    public void setCod(float cod) {
        this.cod = cod;
    }
}
