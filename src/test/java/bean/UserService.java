package bean;

import java.sql.SQLOutput;

public class UserService {
    private String uId;
    private UserDao userDao;
    private String location;
    private String company;

    public void queryUserInfo(){
        System.out.println("query" + userDao.queryUserName(uId) + "公司" + company + "地点" + location);

    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }

    public String getuId() {
        return uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
