public class Course {
    public String name;

    public String description;

    public String instructor;

    public Course() {
        this.name = "";
        this.description = "";
        this.instructor = "";
    }

    public Course(String name,
                  String description,
                  String instructor) {
        this.name = name;
        this.description = description;
        this.instructor = instructor;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}