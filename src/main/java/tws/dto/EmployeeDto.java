package tws.dto;

public class EmployeeDto {
    private String id;
    private String name;
    private int age;
    private String desc;

    public EmployeeDto() {
    }

    public void concat() {
        this.desc = this.name + this.age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
