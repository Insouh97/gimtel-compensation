package ma.s2m.gimtel.compensationator.model;


public class ParsedModel{

    private long id;
    private String name;
    private String email;
    private String phone;
    private int age;

    public ParsedModel(String ...params){
        try {
            this.id = Long.parseLong(params[0]);
            this.name = params[1];
            this.email = params[2];
            this.phone = params[3];
            this.age = Integer.parseInt(params[4]);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Cannot instanciate a user");
        }

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }

}
