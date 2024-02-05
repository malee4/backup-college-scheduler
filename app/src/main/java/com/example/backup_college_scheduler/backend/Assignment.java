import java.util.Date;

public class Assignment {

    public String name;

    public String description;

    public int courseId;

    public Date dueDate;

    public boolean done;

//    public Date notificationTime;

    public Assignment() {
        this.name = "";
        this.description = "";
        this.courseId = 0;
        this.dueDate = null;
        this.done = false;
//        this.notificationTime = null;
    }

    public Assignment(String name,
                      String description,
                      int courseId,
                      Date dueDate,
                      boolean done,
                      Date notificationTime) {
        this.name = name;
        this.description = description;
        this.courseId = courseId;
        this.dueDate = dueDate;
        this.done = done;
//        this.notificationTime = notificationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

//    public Date getNotificationTime() {
//        return notificationTime;
//    }
//
//    public void setNotificationTime(Date notificationTime) {
//        this.notificationTime = notificationTime;
//    }

}
