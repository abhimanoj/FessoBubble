package bubble.fesso.com.fessobubble.pojo;

/**
 * Created by Abhimanoj on 14/10/16.
 */
public class DataFromServer {



    String          UserName;
    String          UserLastName;
    String          EmailId;
    String          Query;
    String          Task;



    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }



    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String UserLastName) {
        this.UserLastName = UserLastName;
    }


    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }


    public String getQuery() {
        return Query;
    }

    public void setQuery(String Query) {
        this.Query = Query;
    }


    public String getTask() {
        return Task;
    }

    public void setTask(String Task) {
        this.Task = Task;
    }


}
