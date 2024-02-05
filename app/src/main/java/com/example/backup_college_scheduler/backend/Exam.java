import java.util.Date;

public class Exam {
    public String name;

    public String description;

    public int courseId;

    public String location;

    public Date start;

    public Date end;

//    public Date notificationTime;

    public Exam() {
        this.name = "";
        this.description = "";
        this.courseId = 0;
        this.location = "";
        this.start = null;
        this.end = null;
//        this.notificationTime = null;
    }

    public Exam(int courseId,
                String name,
                String description,
                String location,
                Date start,
                Date end,
                Date notificationTime) {
        this.courseId = courseId;
        this.name = name;
        this.description = description;
        this.location = location;
        this.start = start;
        this.end = end;
//        this.notificationTime = notificationTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

//    public Date getNotificationTime() {
//        return notificationTime;
//    }
//
//    public void setNotificationTime(Date notificationTime) {
//        this.notificationTime = notificationTime;
//    }
}